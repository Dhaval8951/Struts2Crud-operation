package com.struts2crud.Interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ValidSession implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("inside destroy interceptor");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("inside init interceptor");
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("Inside interceptor");
		if (ServletActionContext.getRequest().getSession().getAttribute("user") != null) {
			arg0.invoke();
		}
		return "input";
	}

}
