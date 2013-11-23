package com.caru.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.caru.biz.AuthenticationResultBean;
import com.caru.biz.login.LoginMgrImpl;
import com.caru.biz.login.LogoutBean;
import com.caru.biz.login.Session;
import com.caru.exception.CapiException;
import com.caru.exception.DataFormatInvalidException;
import com.caru.exception.ExceptionKeys;

public class CapiServlet extends HttpServlet {

	public static final int INPUT_BUF_SIZE = 512;

	private String readAll(InputStream in, String encoding) throws IOException {
		final byte[] buffer = new byte[INPUT_BUF_SIZE];
		ByteArrayOutputStream bos = null;
		while (true) {
			int count = in.read(buffer);
			if (count < 0) { // EOF
				break;
			}
			/*
			 * Let's create buffer lazily, to be able to create something that's
			 * not too small (many resizes) or too big (slower to allocate):
			 * mostly to speed up handling of tiny docs.
			 */
			if (bos == null) {
				int cap;
				if (count < 64) {
					cap = 64;
				} else if (count == INPUT_BUF_SIZE) {
					// Let's assume there's more coming, not just this chunk
					cap = INPUT_BUF_SIZE * 4;
				} else {
					cap = count;
				}
				bos = new ByteArrayOutputStream(cap);
			}
			bos.write(buffer, 0, count);
		}
		return (bos == null) ? "" : bos.toString(encoding);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		BasicResponse basicResponse = new BasicResponse();
		try {
			InputStream is = req.getInputStream();
			String json = readAll(is, "UTF-8");

			JSONObject obj1 = null;
			try {
				obj1 = new JSONObject(json);
			} catch (JSONException je) {
				basicResponse.setStatus(false);
				basicResponse.setErrorKey(ExceptionKeys.JSON_FORMAT_ERROR);
				basicResponse.setMsg("Json Format Error : " + je.getMessage());
				sendResponse(res, basicResponse);
				return;
			}
			JSONObject rqstJO = obj1.getJSONObject("Rqst");
			if (rqstJO == null) {
				basicResponse.setStatus(false);
				basicResponse.setErrorKey(ExceptionKeys.JSON_NO_RQST);
				basicResponse.setMsg("No Rqst in request");
				sendResponse(res, basicResponse);
				return;
			}
			String job = rqstJO.getString("Job");
			if (job == null) {
				basicResponse.setStatus(false);
				basicResponse.setErrorKey(ExceptionKeys.JSON_NO_JOB);
				basicResponse.setMsg("No Job in request");
				sendResponse(res, basicResponse);
				return;
			}
			String needAuthentication = (String) BeanConfiguration
					.getInstance().getProperty(job + ".authentication");
			long userId = 0;
			long carId = 0;
			if (needAuthentication == null || needAuthentication.equals("true")) {
				String credential = rqstJO.getString("Credential");
				if (credential == null || credential.equals("")) {
					basicResponse.setStatus(false);
					basicResponse.setErrorKey(ExceptionKeys.NO_CREDENTIAL);
					basicResponse.setMsg("Credential is null");
					sendResponse(res, basicResponse);
					return;
				}
				Session session = LoginMgrImpl.getInstance().getSession(
						credential);
				if (session == null) {
					basicResponse.setStatus(false);
					basicResponse.setErrorKey(ExceptionKeys.INVALID_CREDENTIAL);
					basicResponse.setMsg("Invalid Credential");
					sendResponse(res, basicResponse);
					return;
				} else {
					userId = session.getUId();
					carId = session.getCId();
				}
				if (job.equals("UserLogout")) {
					LogoutBean logoutBean = new LogoutBean();
					logoutBean.setCredential(credential);
					LoginMgrImpl.getInstance().logout(logoutBean);
				}
			}

			if (!job.equals("UserLogout")) {
				String beanClassName = BeanConfiguration.getInstance()
						.getProperty(job);
				if (beanClassName == null) {
					basicResponse.setStatus(false);
					basicResponse.setErrorKey(ExceptionKeys.INVALID_JOB);
					basicResponse.setMsg("Invalid Job in request");
					sendResponse(res, basicResponse);
					return;
				}

				JSONObject dataJO = rqstJO.getJSONObject("Data");
				Object input = JsonUtil.converJsonToBean(dataJO, beanClassName);
				try {
					Method[] abc = input.getClass().getMethods();
					Method setUserID = input.getClass().getMethod("setUserId",
							new Class[] { long.class });
					if (setUserID != null) {
						setUserID.invoke(input,
								new Object[] { new Long(userId) });
					}
					Method setCarID = input.getClass().getMethod("setCarId",
							new Class[] { long.class });
					if (setCarID != null) {
						setCarID
								.invoke(input, new Object[] { new Long(carId) });
					}
				} catch (NoSuchMethodException ex) {
					ex.printStackTrace();
					// ignore ,
				}
				String mgrClassName = BeanConfiguration.getInstance()
						.getProperty(job + ".mgr");
				String jobMethod = BeanConfiguration.getInstance().getProperty(
						job + ".api");
				Class mgr = Class.forName(mgrClassName);
				Method getInstance = mgr.getMethod("getInstance", null);
				Method jobApi = mgr.getMethod(jobMethod, new Class[] { input
						.getClass() });
				Object mgrImpl = getInstance.invoke(null, null);
				Object result = jobApi.invoke(mgrImpl, new Object[] { input });
				if (result instanceof String || result instanceof Integer
						|| result instanceof Long || result instanceof Boolean
						|| result instanceof Byte || result instanceof Double
						|| result instanceof Date) {
					SingleResult temp = new SingleResult();
					temp.setResult(result);
					result = temp;
				}
				basicResponse.setData(result);
				if (result instanceof AuthenticationResultBean) {
					String credential = ((AuthenticationResultBean) result)
							.getCredential();
					((AuthenticationResultBean) result).setCredential(null);
					basicResponse.setCredential(credential);
				} else {
					basicResponse.setCredential(rqstJO.getString("Credential"));
				}
			}
			basicResponse.setJob(job);
		} catch (Exception ex) {
			if (ex instanceof InvocationTargetException) {
				ex = (Exception) ((InvocationTargetException) ex)
						.getTargetException();
			}
			if (ex instanceof CapiException) {
				if (ex instanceof DataFormatInvalidException) {
					String field = ((DataFormatInvalidException) ex).getField();
					String type = ((DataFormatInvalidException) ex).getType();
					basicResponse.setAdditionalInfo("The field [" + field
							+ "] should be " + type);
				}
				basicResponse.setMsg(ex.getMessage());
			} else {
				StackTraceElement[] traces = ex.getStackTrace();
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < traces.length; i++) {
					sb.append("at " + traces[i].getClassName() + "."
							+ traces[i].getMethodName() + "("
							+ traces[i].getFileName()
							+ traces[i].getLineNumber() + ")");
					sb.append('\n');
				}
				basicResponse.setMsg(ex.getClass().getName() + " : "
						+ ex.getMessage() + " \n " + " , Exception trace : "
						+ sb.toString());
			}
			basicResponse.setStatus(false);
		}
		sendResponse(res, basicResponse);
	}

	private void sendResponse(HttpServletResponse res,
			BasicResponse basicResponse) {
		try {
			Response response = new Response();
			response.setRsps(basicResponse);
			JSONObject obj = new JSONObject(response, true);

			Writer writer = res.getWriter();
			writer.write(obj.toString(1));
			writer.flush();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}