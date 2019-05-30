package com.hzy.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	
	@Autowired
	MessageSource messageSource;
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	public String getMessage(String key){
		return this.getMessage(key,null);
	}

	public String getMessage(String key,Object[] args){
		return messageSource.getMessage(key,args,LocaleContextHolder.getLocale());
	}

}
