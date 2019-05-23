package com.zhiyou100.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class MyInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("after....");
	}

	@Override
	public void postHandle(HttpServletRequest request , HttpServletResponse response, Object object, ModelAndView mv)
			throws Exception {
			
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
//		进行拦截判断当前session中是否有用户登录
		System.out.println("+++++++加载中......");
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		System.out.println("user: " + user);
//		判断当前user值是否为空
		boolean  flag = false ;
		if(user != null && !user.isEmpty()){//用户已登录，直接放行
			System.out.println("用户已登录");
			request.getRequestDispatcher("../pages/new_info.html").forward(request, response);
			flag = true;
		}else {//用户没有登录
			request.getRequestDispatcher("../pages/login.html").forward(request, response);
		}
		return flag;
	}

}
