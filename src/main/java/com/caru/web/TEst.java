package com.caru.web;

import java.lang.reflect.Method;

import com.caru.biz.register.UserRegisterBean;

public class TEst {

	public TEst() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			Class mgr = Class.forName("com.caru.biz.RegisterMgrImpl");
			Method getInstance = mgr.getMethod("getInstance", null);
			Method jobMethod = mgr.getMethod("register", new Class[]{UserRegisterBean.class});
			Object mgrImpl = getInstance.invoke(null, null);
			UserRegisterBean userRegisterBean = new UserRegisterBean();
			Object o = jobMethod.invoke(mgrImpl, new Object[]{userRegisterBean});
			System.out.println("o = " + o);
			System.out.println(getInstance.getName());
			System.out.println("mgrImpl = " + mgrImpl);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
