package com.caru.web;

import java.util.HashMap;
import java.util.Map;

public class BeanConfiguration {
	private Map beanMap = new HashMap();
	private static BeanConfiguration beanConfigration = new BeanConfiguration();
	public static BeanConfiguration getInstance(){
		return beanConfigration;
	}
	private BeanConfiguration() {
		beanMap.put("UserRegister", "com.caru.biz.register.UserRegisterBean");
		beanMap.put("UserRegister.mgr", "com.caru.biz.register.RegisterMgrImpl");
		beanMap.put("UserRegister.api", "register");
		beanMap.put("UserRegister.authentication", "false");
		
		beanMap.put("UserLogin", "com.caru.biz.login.LoginBean");
		beanMap.put("UserLogin.mgr", "com.caru.biz.login.LoginMgrImpl");
		beanMap.put("UserLogin.api", "login");
		beanMap.put("UserLogin.authentication", "false");
		
		beanMap.put("EmailDuplicateChecking", "java.lang.String");
		beanMap.put("EmailDuplicateChecking.mgr", "com.caru.biz.register.RegisterMgrImpl");
		beanMap.put("EmailDuplicateChecking.api", "isEmailDuplicate");
		beanMap.put("EmailDuplicateChecking.authentication", "false");

		beanMap.put("UserNameDuplicateChecking", "java.lang.String");
		beanMap.put("UserNameDuplicateChecking.mgr", "com.caru.biz.register.RegisterMgrImpl");
		beanMap.put("UserNameDuplicateChecking.api", "isNameDuplicate");
		beanMap.put("UserNameDuplicateChecking.authentication", "false");

		beanMap.put("ReadUserAccount", "com.caru.biz.user.ReadUserAccountBean");
		beanMap.put("ReadUserAccount.mgr", "com.caru.biz.user.UserMgrImpl");
		beanMap.put("ReadUserAccount.api", "readUserAccount");
		beanMap.put("ReadUserAccount.authentication", "true");
		
		beanMap.put("UserAccountEdit", "com.caru.biz.user.UserAccountEditBean");
		beanMap.put("UserAccountEdit.mgr", "com.caru.biz.user.UserMgrImpl");
		beanMap.put("UserAccountEdit.api", "editUserAccount");
		beanMap.put("UserAccountEdit.authentication", "true");
		
		beanMap.put("UserPasswordChange", "com.caru.biz.user.UserPasswordChangeBean");
		beanMap.put("UserPasswordChange.mgr", "com.caru.biz.user.UserMgrImpl");
		beanMap.put("UserPasswordChange.api", "changePassword");
		beanMap.put("UserPasswordChange.authentication", "true");

		beanMap.put("AddFee", "com.caru.biz.fee.AddFeeBean");
		beanMap.put("AddFee.mgr", "com.caru.biz.fee.FeeMgrImpl");
		beanMap.put("AddFee.api", "addFee");
		beanMap.put("AddFee.authentication", "true");
		
		beanMap.put("FeeIds", "com.caru.biz.fee.FeeIdResultBean");
		beanMap.put("FeeList", "com.caru.biz.fee.Fee");

		beanMap.put("BatchAddFee", "com.caru.biz.fee.BatchAddFeeBean");
		beanMap.put("BatchAddFee.mgr", "com.caru.biz.fee.FeeMgrImpl");
		beanMap.put("BatchAddFee.api", "batchAddFee");
		beanMap.put("BatchAddFee.authentication", "true");
		
		beanMap.put("EditFee", "com.caru.biz.fee.EditFeeBean");
		beanMap.put("EditFee.mgr", "com.caru.biz.fee.FeeMgrImpl");
		beanMap.put("EditFee.api", "editFee");
		beanMap.put("EditFee.authentication", "true");
		
		beanMap.put("BatchEditFee", "com.caru.biz.fee.BatchEditFeeBean");
		beanMap.put("BatchEditFee.mgr", "com.caru.biz.fee.FeeMgrImpl");
		beanMap.put("BatchEditFee.api", "batchEditFee");
		beanMap.put("BatchEditFee.authentication", "true");

		beanMap.put("DeleteFee", "com.caru.biz.fee.DeleteFeeBean");
		beanMap.put("DeleteFee.mgr", "com.caru.biz.fee.FeeMgrImpl");
		beanMap.put("DeleteFee.api", "deleteFee");
		beanMap.put("DeleteFee.authentication", "true");

		beanMap.put("ListFee", "com.caru.biz.fee.ListFeeBean");
		beanMap.put("ListFee.mgr", "com.caru.biz.fee.FeeMgrImpl");
		beanMap.put("ListFee.api", "listFee");
		beanMap.put("ListFee.authentication", "true");
		
		
		beanMap.put("UserLogout", "com.caru.biz.login.LogoutBean");
		beanMap.put("UserLogout.mgr", "com.caru.biz.login.LoginMgrImpl");
		beanMap.put("UserLogout.api", "logout");
		beanMap.put("UserLogout.authentication", "true");
	}
	
	public String getProperty(String name){
		return (String) beanMap.get(name);
	}
}
