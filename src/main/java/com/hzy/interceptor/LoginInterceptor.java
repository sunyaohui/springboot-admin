package com.hzy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hzy.util.StringUtil;

@Component
public class LoginInterceptor extends BaseInterceptor{
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		String token=request.getParameter("token");
		
		if(StringUtil.isEmpty(token)){
			token = request.getHeader("token");
		}
		
		if (StringUtil.isEmpty(token)) {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");  
            response.getWriter().print("Token失效.");
            response.setStatus(302);
            return false;
		}
		return true;
	}

}
