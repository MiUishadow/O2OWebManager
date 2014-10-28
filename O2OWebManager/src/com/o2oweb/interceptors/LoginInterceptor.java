package com.o2oweb.interceptors;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.o2oweb.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		// 取得请求的Action名
		String name = invocation.getInvocationContext().getName();
		if (name.equals("loginInterceptorAction")) {
			return invocation.invoke();
		}
		ActionContext ac = invocation.getInvocationContext();
		Map session = (Map) ac.get(ServletActionContext.SESSION);

		if (session == null) {
			return "user";
		} else {
			User user = (User) session.get("user");
			if (user == null) {
				return "user";
			}

			return invocation.invoke();
		}

	}

}