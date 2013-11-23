package com.caru.biz.register;

import java.util.Date;

import com.caru.biz.UserUtil;
import com.caru.biz.login.LoginBean;
import com.caru.biz.login.LoginMgrImpl;
import com.caru.biz.login.LoginResultBean;
import com.caru.db.DBAgentOO;
import com.caru.exception.CapiException;
import com.caru.exception.ExceptionKeys;
import com.caru.util.CarIDGenerator;
import com.caru.util.UserIDGenerator;
import com.caru.vo.CarVO;
import com.caru.vo.CyuserVO;
import com.caru.vo.UserVO;

public class RegisterMgrImpl{
	private static RegisterMgrImpl instance = new RegisterMgrImpl();
	

	public static RegisterMgrImpl getInstance() {
		return instance;
	}

	private RegisterMgrImpl() {
	}
	
	private void registerValidate(UserRegisterBean register) throws Exception{
		if(register.getUserName() == null || register.getUserName().equals("")){
			throw new CapiException(ExceptionKeys.USERNAME_IS_NULL);
		}
		if(register.getEmail() == null || register.getEmail().equals("")){
			throw new CapiException(ExceptionKeys.EMAIL_IS_NULL);
		}
		if(register.getPassword() == null || register.getPassword().equals("")){
			throw new CapiException(ExceptionKeys.PASSWORD_IS_NULL);
		}
		if(UserUtil.isEmailExist(register.getEmail())){
			throw new CapiException(ExceptionKeys.EMAIL_IS_DUPLICATED);
		}
		if(UserUtil.isUsernameExist(register.getUserName())){
			throw new CapiException(ExceptionKeys.USERNAME_IS_DUPLIDATED);
		}
		if(!register.isAcceptSiteRule()){
			throw new CapiException(ExceptionKeys.REGISTER_MUST_ACCEPT_RULES);
		}
	}
	
	public UserRegisterResultBean register(UserRegisterBean register)
			throws Exception {
		registerValidate(register);
		UserRegisterResultBean result = new UserRegisterResultBean();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			UserVO userVO = new UserVO();
			userVO.setCreatedtime(new Date());
			userVO.setLastmodifiedtime(new Date());
			if (register.getUserID() > 0) {
				userVO.setUserid((int) register.getUserID());
			} else {
				userVO.setUserid(UserIDGenerator.getInstance().getUserID());
			}
			userVO.setUsername(register.getUserName());
			userVO.setEmail(register.getEmail());
			userVO.setPassword(register.getPassword());
			userVO.setProvinceid(register.getProvinceId());
			userVO.setCityid(register.getCityId());
			userVO.setRegisterdate(new Date());
			userVO.setLastlogindate(new Date());
			if(register.isAcceptSiteRule()){
				userVO.setAcceptsiterule(1);
			}
			userVO.setRegisterip(register.getRegisterIP());
			userVO.setRegisterrefform(register.getRegisterRefFrom());
			userVO.setActivetag(1);
			dbAgentOO.insert(userVO);

			CarVO carVO = new CarVO();
			carVO.setUserid(userVO.getUserid());
			carVO.setCarid(CarIDGenerator.getInstance().getCarID());
			
			carVO.setBrandid(register.getBrandId());
			carVO.setModeldiyname(register.getModelDIYname());
			carVO.setModelid(register.getModelId());
			carVO.setVenderid(register.getVenderId());

			carVO.setPurchaseddate(register.getPurchasedDate());
			carVO.setPurchasedtype(register.getPurchasedType());
			carVO.setPurchasedtag(register.getPurchasedTag());
			carVO.setTotalprice(register.getTotalPrice());
			carVO.setNickname(register.getNickName());
			carVO.setTankvolume(register.getDIYTankVolume());
			carVO.setActivetag(1);
			carVO.setCreatedtime(new Date());
			carVO.setLastmodifiedtime(new Date());
			dbAgentOO.insert(carVO);
			dbAgentOO.commitTransaction();
			result.setUserId(userVO.getUserid());
			result.setCarId(carVO.getCarid());
			LoginBean loginBean = new LoginBean();
			loginBean.setUserName(register.getUserName());
			loginBean.setPassword(register.getPassword());
			loginBean.setLoginFromIP(register.getRegisterIP());
			LoginResultBean loginResultBean = LoginMgrImpl.getInstance().login(loginBean);
			result.setCredential(loginResultBean.getCredential());
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

	public boolean isEmailDuplicate(String email)throws Exception {
		return UserUtil.isEmailExist(email); 
	}
	
	public boolean isNameDuplicate(String userName)throws Exception{
		return UserUtil.isUsernameExist(userName);
	}
	
	public String validate(UserRegisterBean register, boolean isEdit) {

		return null;
	}



}
