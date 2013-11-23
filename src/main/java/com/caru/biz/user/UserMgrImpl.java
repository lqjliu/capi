package com.caru.biz.user;

import com.caru.biz.UserUtil;
import com.caru.db.DBAgentOO;
import com.caru.exception.CapiException;
import com.caru.exception.ExceptionKeys;
import com.caru.vo.CarVO;
import com.caru.vo.UserVO;

public class UserMgrImpl {
	private static UserMgrImpl instance = new UserMgrImpl();

	public static UserMgrImpl getInstance() {
		return instance;
	}

	private UserMgrImpl() {
	}

	public ReadUserAccountResultBean readUserAccount(
			ReadUserAccountBean readUserAccountBean) throws Exception {
		ReadUserAccountResultBean result = new ReadUserAccountResultBean();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			UserVO userVO = new UserVO();
			userVO.setUserid(readUserAccountBean.getUserId());
			userVO.setWhereUserid(true);
			userVO = (UserVO) dbAgentOO.select(userVO);
			if (userVO == null) {
				throw new CapiException(ExceptionKeys.USER_NOT_FOUND);
			} else {
				result.setUserCityId(userVO.getCityid());
				result.setUserEmail(userVO.getEmail());
				result.setUserId(userVO.getUserid());
				result.setUserName(userVO.getUsername());
				result.setUserProvinceId(userVO.getProvinceid());
				CarVO carVO = new CarVO();
				carVO.setUserid(readUserAccountBean.getUserId());
				carVO.setWhereUserid(true);
				carVO.setCarid(readUserAccountBean.getCarId());
				carVO.setWhereCarid(true);
				carVO = (CarVO) dbAgentOO.select(carVO);
				if (carVO == null) {
					throw new CapiException(ExceptionKeys.CAR_NOT_FOUND);
				}
				result.setCarBrandId(carVO.getBrandid());
				result.setCarDIYTankVolume(carVO.getTankvolume());
				result.setCarId(carVO.getCarid());
				result.setCarModelDIYname(carVO.getModeldiyname());
				result.setCarModelId(carVO.getModelid());
				result.setCarNickName(carVO.getNickname());
				result.setCarPicURL(carVO.getPicurl());
				result.setCarPurchasedDate(carVO.getPurchaseddate());
				result.setCarPurchasedType(carVO.getPurchasedtype());
				result.setCarTotalPrice(carVO.getTotalprice());
				result.setCarVenderId(carVO.getVenderid());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return result;
	}

	private void editUserAccountValidate(UserAccountEditBean userAccountEditBean) throws Exception{
		if(userAccountEditBean.getUserName() == null || userAccountEditBean.getUserName().equals("")){
			throw new CapiException(ExceptionKeys.USERNAME_IS_NULL);
		}
		if(userAccountEditBean.getUserEmail() == null || userAccountEditBean.getUserEmail().equals("")){
			throw new CapiException(ExceptionKeys.EMAIL_IS_NULL);
		}
		if(UserUtil.isEmailExist(userAccountEditBean.getUserId(),userAccountEditBean.getUserEmail())){
			throw new CapiException(ExceptionKeys.EMAIL_IS_DUPLICATED);
		}
		if(UserUtil.isUsernameExist(userAccountEditBean.getUserId(),userAccountEditBean.getUserName())){
			throw new CapiException(ExceptionKeys.USERNAME_IS_DUPLIDATED);
		}
	}
	
	public UserAccountEditResultBean editUserAccount(
			UserAccountEditBean userAccountEditBean) throws Exception {
		editUserAccountValidate(userAccountEditBean);
		UserAccountEditResultBean result = new UserAccountEditResultBean();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			UserVO userVO = new UserVO();
			userVO.setEmail(userAccountEditBean.getUserEmail());
			userVO.setUsername(userAccountEditBean.getUserName());
			userVO.setProvinceid(userAccountEditBean.getUserProvinceId());
			userVO.setCityid(userAccountEditBean.getUserCityId());
			userVO.setUserid(userAccountEditBean.getUserId());
			userVO.setWhereUserid(true);
			dbAgentOO.update(userVO);
			CarVO carVO = new CarVO();
			carVO.setBrandid(userAccountEditBean.getCarBrandId());
			carVO.setVenderid(userAccountEditBean.getCarVenderId());
			carVO.setModelid(userAccountEditBean.getCarModelId());
			carVO.setModeldiyname(userAccountEditBean.getCarModelDIYname());
			carVO.setTankvolume(userAccountEditBean.getCarDIYTankVolume());
			carVO.setPurchasedtype(userAccountEditBean.getCarPurchasedType());
			carVO.setPurchaseddate(userAccountEditBean.getCarPurchasedDate());
			carVO.setTotalprice(userAccountEditBean.getCarTotalPrice());
			carVO.setNickname(userAccountEditBean.getCarNickName());
			carVO.setPicurl(userAccountEditBean.getCarPicURL());
			carVO.setUserid(userAccountEditBean.getUserId());
			carVO.setWhereUserid(true);
			carVO.setCarid(userAccountEditBean.getCarId());
			carVO.setWhereCarid(true);
			dbAgentOO.update(carVO);
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
	public UserPasswordChangeResultBean changePassword(UserPasswordChangeBean userPasswordChangeBean) throws Exception{
		UserPasswordChangeResultBean result = new UserPasswordChangeResultBean();
		DBAgentOO dbAgentOO = new DBAgentOO();
		try {
			dbAgentOO.beginTransaction();
			UserVO userVO = new UserVO();
			userVO.setUserid(userPasswordChangeBean.getUserId());
			userVO.setWhereUserid(true);
			userVO = (UserVO) dbAgentOO.select(userVO);
			if (userVO == null) {
				throw new CapiException(ExceptionKeys.USER_NOT_FOUND);
			} else {
				String oldPassword1 = userVO.getPassword();
				if(!oldPassword1.equals(userPasswordChangeBean.getOldPassword())){
					throw new CapiException(ExceptionKeys.OLD_PASSWORD_WRONG);
				}
				userVO = new UserVO();
				userVO.setUserid(userPasswordChangeBean.getUserId());				userVO.setWhereUserid(true);
				userVO.setPassword(userPasswordChangeBean.getNewPassword());
				dbAgentOO.update(userVO);
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
		result.setEditStatus(true);
		return result;
	}
}
