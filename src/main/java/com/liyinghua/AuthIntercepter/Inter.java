package com.liyinghua.AuthIntercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.liyinghua.common.ConstantClass;

public class Inter implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object attribute = request.getSession().getAttribute(ConstantClass.USER_KEY);
		if(attribute!=null) {
			return true;
		}
		request.getRequestDispatcher("/").forward(request, response);
		return false;
	}
}
