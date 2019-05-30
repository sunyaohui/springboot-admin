package com.hzy.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware{
	private static SpringContextUtil instance;

    private static ApplicationContext applicationContext = null;

    private SpringContextUtil() {

    }

    /**
     * 单例模式
     *
     * @return SpringContextUtil
     */
    public static SpringContextUtil getInstance() {

        if (instance == null) {
            instance = new SpringContextUtil();
        }

        return instance;
    }

    /**
     * 获取 Bean 对象
     *
     * @param beanId Bean 对象的ID
     * @return Object
     */
    public Object getBean(final String beanId) {

        Object obj = applicationContext.getBean(beanId);
        return obj;
    }

    public ApplicationContext getApplicationContext() {

        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext ac) {

        applicationContext = ac;
    }
    
    
//    @SuppressWarnings("unused")
//	private static Logger log = LoggerFactory.getLogger(SpringContextUtil.class);
//	
//	private static ApplicationContext applicationContext;
//
//	public static ApplicationContext getApplicationContext() {
//		return applicationContext;
//	}
//
//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) {
//		if(SpringContextUtil.applicationContext == null) {
//			SpringContextUtil.applicationContext = applicationContext;
//		}
//	}
//
//	
//	public static Object getBean(String name) {
//		return getApplicationContext().getBean(name);
//	}
//	
//	public static<T> T getBean(Class<T> clazz) {
//		return getApplicationContext().getBean(clazz);
//	}
//	
//	public static<T> T getBean(String name,Class<T> clazz) {
//		return getApplicationContext().getBean(name,clazz);
//	}
	
	
}
