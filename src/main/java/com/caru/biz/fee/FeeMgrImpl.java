package com.caru.biz.fee;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.caru.db.DBAgentOO;
import com.caru.exception.CapiException;
import com.caru.exception.DataFormatInvalidException;
import com.caru.exception.ExceptionKeys;
import com.caru.util.FeeIDGenerator;
import com.caru.vo.FeeVO;
import com.caru.web.JsonUtil;

public class FeeMgrImpl {
	private static FeeMgrImpl instance = new FeeMgrImpl();

	public static FeeMgrImpl getInstance() {
		return instance;
	}

	private FeeMgrImpl() {
	}

	public FeeIdResultBean addFee(AddFeeBean addFeeBean) throws Exception {
		FeeIdResultBean result = new FeeIdResultBean();
		double ammount = addFeeBean.getAmount();
		if (ammount == 0) {
			throw new CapiException(ExceptionKeys.FEE_AMOUNT_IS_NULL);
		}
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			long feeId = addFee(addFeeBean.getUserId(), addFeeBean.getCarId(),
					addFeeBean.getFee(), dbAgentOO);
			dbAgentOO.commitTransaction();
			result.setFeeId(feeId);
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		}
		return result;
	}

	private long addFee(long userId, long carId, Fee fee, DBAgentOO dbAgentOO)
			throws SQLException, Exception {
		FeeVO feeVO = new FeeVO();
		long feeId = FeeIDGenerator.getInstance().getFeeID();
		feeVO.setFeeid((int) feeId);
		feeVO.setUserid((int) userId);
		feeVO.setCarid((int) carId);
		feeVO.setType(fee.getType());
		if (fee.getAmount() == 0) {
			throw new CapiException(ExceptionKeys.FEE_AMOUNT_IS_NULL);
		}
		feeVO.setAmount(fee.getAmount());
		feeVO.setDate(fee.getDate());
		feeVO.setRemarks(fee.getRemarks());
		feeVO.setOdometer((int) fee.getOdometer());
		feeVO.setLastmodifiedtime(new Date());
		feeVO.setCreatedtime(new Date());
		feeVO.setActivetag(1);
		dbAgentOO.insert(feeVO);
		return feeId;
	}

	public BatchFeeIdResultBean batchAddFee(BatchAddFeeBean batchAddFeeBean)
			throws Exception {
		if (batchAddFeeBean.getFeeList() == null) {
			return null;
		}
		BatchFeeIdResultBean result = new BatchFeeIdResultBean();
		List feeIds = new ArrayList();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			List feeList = batchAddFeeBean.getFeeList();
			for (int i = 0; i < feeList.size(); i++) {
				Fee fee = (Fee) feeList.get(i);
				long feeId = addFee(batchAddFeeBean.getUserId(),
						batchAddFeeBean.getCarId(), fee, dbAgentOO);
				FeeIdResultBean feeIdBean = new FeeIdResultBean();
				feeIdBean.setFeeId(feeId);
				feeIds.add(feeIdBean);
			}
			dbAgentOO.commitTransaction();
			result.setFeeIds(feeIds);
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		}
		return result;
	}

	public FeeIdResultBean editFee(EditFeeBean editFeeBean) throws Exception {
		FeeIdResultBean result = new FeeIdResultBean();
		double ammount = editFeeBean.getAmount();
		if (ammount == 0) {
			throw new CapiException(ExceptionKeys.FEE_AMOUNT_IS_NULL);
		}
		if (editFeeBean.getFeeId() == 0) {
			throw new CapiException(ExceptionKeys.FEE_AMOUNT_IS_NULL);
		}
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			editFee(editFeeBean.getUserId(), editFeeBean.getCarId(),
					editFeeBean.getFee(), dbAgentOO);
			dbAgentOO.commitTransaction();
			result.setFeeId(editFeeBean.getFee().getFeeId());
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		}
		return result;
	}

	public BatchFeeIdResultBean batchEditFee(BatchEditFeeBean batchEditFeeBean)
			throws Exception {
		if (batchEditFeeBean.getFeeList() == null) {
			return null;
		}
		BatchFeeIdResultBean result = new BatchFeeIdResultBean();
		List feeIds = new ArrayList();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			List feeList = batchEditFeeBean.getFeeList();
			for (int i = 0; i < feeList.size(); i++) {
				Fee fee = (Fee) feeList.get(i);
				editFee(batchEditFeeBean.getUserId(), batchEditFeeBean
						.getCarId(), fee, dbAgentOO);
				FeeIdResultBean feeIdBean = new FeeIdResultBean();
				feeIdBean.setFeeId(fee.getFeeId());
				feeIds.add(feeIdBean);
			}
			dbAgentOO.commitTransaction();
			result.setFeeIds(feeIds);
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		}
		return result;
	}

	private void editFee(long userId, long carId, Fee fee, DBAgentOO dbAgentOO)
			throws SQLException, Exception {
		FeeVO feeVO = new FeeVO();
		feeVO.setFeeid((int) fee.getFeeId());
		feeVO.setWhereFeeid(true);
		feeVO.setUserid((int) userId);
		feeVO.setWhereUserid(true);
		feeVO.setCarid((int) carId);
		feeVO.setWhereCarid(true);
		feeVO.setType(fee.getType());
		feeVO.setAmount(fee.getAmount());
		feeVO.setDate(fee.getDate());
		feeVO.setRemarks(fee.getRemarks());
		feeVO.setOdometer((int) fee.getOdometer());
		feeVO.setLastmodifiedtime(new Date());
		feeVO.setCreatedtime(new Date());
		feeVO.setActivetag(1);
		dbAgentOO.update(feeVO);
	}

	public void deleteFee(DeleteFeeBean deleteFeeBean) throws Exception {
		List result = null;
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			List feeIds = deleteFeeBean.getFeeIds();
			for (int i = 0; i < feeIds.size(); i++) {
				FeeVO feeVO = new FeeVO();
				FeeIdResultBean feeIdBean = (FeeIdResultBean) feeIds.get(i);
				feeVO.setFeeid((int) feeIdBean.getFeeId());
				feeVO.setWhereFeeid(true);
				feeVO.setUserid((int) deleteFeeBean.getUserId());
				feeVO.setWhereUserid(true);
				feeVO.setCarid((int) deleteFeeBean.getCarId());
				feeVO.setWhereCarid(true);
				feeVO.setActivetag(0);
				dbAgentOO.update(feeVO);
			}
			dbAgentOO.commitTransaction();
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		}
	}

	public static String formatDate(Date value)
			throws DataFormatInvalidException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sValue = null;
		try {
			sValue = sdf.format(value);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sValue;
	}

	public List listFee(ListFeeBean listFeeBean) throws Exception {
		List result = new ArrayList();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();

			String sql = "select * from fee where userId = "
					+ listFeeBean.getUserId() + " and carId = "
					+ listFeeBean.getCarId() + " and ActiveTag = 1"; 
			if(listFeeBean.getStartDate() != null){
				Date startDate = listFeeBean.getStartDate();			
				String sStartDate = formatDate(startDate);
				sql += " and date > '" + sStartDate + "'";
			}
			if(listFeeBean.getEndDate() != null){
				Date startDate = listFeeBean.getStartDate();			
				Date endDate = listFeeBean.getEndDate();
				String sEndDate = formatDate(endDate);
			}

			List data = dbAgentOO.selectData(sql, "com.caru.vo.FeeVO");
			for (int i = 0; i < data.size(); i++) {
				FeeVO feeVO = (FeeVO) data.get(i);
				Fee fee = new Fee();
				fee.setAmount(feeVO.getAmount());
				fee.setDate(feeVO.getDate());
				fee.setFeeId(feeVO.getFeeid());
				fee.setOdometer(feeVO.getOdometer());
				fee.setRemarks(feeVO.getRemarks());
				fee.setType(feeVO.getType());
				result.add(fee);
			}
			dbAgentOO.commitTransaction();
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				dbAgentOO.rollbackTransaction();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			throw ex;
		}
		return result;
	}

	public static void main(String[] args) {
		// AddFeeBean addFeeBean = new AddFeeBean();
		// addFeeBean.setAmount(100);
		// addFeeBean.setCarId(1);
		// addFeeBean.setUserId(1);
		// addFeeBean.setDate(new Date());
		// addFeeBean.setOdometer(100);
		// addFeeBean.setRemarks("this is testing");
		// addFeeBean.setType(1);
		// addFeeBean.setUserId(1);
		//		
		// try{
		// FeeMgrImpl.getInstance().addFee(addFeeBean);
		// }catch(Exception ex){
		// ex.printStackTrace();
		// }

// EditFeeBean editFeeBean = new EditFeeBean();
// editFeeBean.setAmount(100);
// editFeeBean.setCarId(1);
// editFeeBean.setUserId(1);
// editFeeBean.setDate(new Date());
// editFeeBean.setOdometer(100);
// editFeeBean.setRemarks("this is testing1");
// editFeeBean.setType(2);
// editFeeBean.setUserId(1);
// editFeeBean.setFeeId(1);
//
// try {
// FeeMgrImpl.getInstance().editFee(editFeeBean);
// } catch (Exception ex) {
// ex.printStackTrace();
// }
 try {
		ListFeeBean listFeeBean = new ListFeeBean();
		listFeeBean.setCarId(1);
		listFeeBean.setUserId(1);
		listFeeBean.setStartDate(parseDate("2009-01-01"));
		listFeeBean.setEndDate(parseDate("2009-10-01"));
		List result = FeeMgrImpl.getInstance().listFee(listFeeBean);
		System.out.println(result.size());
 		} catch (Exception ex) {
 			ex.printStackTrace();
 		}
	 }

	public static Date parseDate(Object value)
			throws DataFormatInvalidException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dValue = null;
		try {
			dValue = sdf.parse(value.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dValue;
	}

}
