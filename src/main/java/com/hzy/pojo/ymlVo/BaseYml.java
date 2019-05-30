package com.hzy.pojo.ymlVo;

import java.util.List;
import java.util.Map;

public class BaseYml {
	
//	private InterceptorYml interceptor;
	
	private SwaggerYml swagger;
	
	private Map<String, List<String>> interceptor;

//	public InterceptorYml getInterceptor() {
//		return interceptor;
//	}

//	public void setInterceptor(InterceptorYml interceptor) {
//		this.interceptor = interceptor;
//	}

	public SwaggerYml getSwagger() {
		return swagger;
	}

	public void setSwagger(SwaggerYml swagger) {
		this.swagger = swagger;
	}

	public Map<String, List<String>> getInterceptor() {
		return interceptor;
	}

	public void setInterceptor(Map<String, List<String>> interceptor) {
		this.interceptor = interceptor;
	}
	
	
}
