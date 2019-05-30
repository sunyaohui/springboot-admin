package com.hzy.interceptor;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hzy.config.YmlConfigStore;
import com.hzy.constants.InterceptorConstants;
import com.hzy.spring.SpringContextUtil;

@SpringBootConfiguration
public class Interceptor extends WebMvcConfigurerAdapter {
	
	@Override  
    public void addInterceptors(InterceptorRegistry registry) {
		Map<String, List<String>> map = YmlConfigStore.getBaseYmls().getInterceptor();
		for(Map.Entry<String, List<String>> entry:map.entrySet()) {
			InterceptorRegistration interceptor = registry.addInterceptor((HandlerInterceptor) SpringContextUtil.getInstance().getBean(entry.getKey()));
			interceptor.addPathPatterns(InterceptorConstants.INTERCEPTOR_URL);
			interceptors(interceptor, entry.getValue()); 
		}
    }
	
	/**
	 * 
	 * @param interceptor 自定义的拦截器
	 * @param filterLicenseUrl commonConfig.yml文件中配置的不需要拦截的请求的key
	 */
	private void interceptors(InterceptorRegistration interceptor ,List<String> list){
		for(int i = 0;i<list.size();i++){
			interceptor.excludePathPatterns(list.get(i));
		}
	}
	
}
