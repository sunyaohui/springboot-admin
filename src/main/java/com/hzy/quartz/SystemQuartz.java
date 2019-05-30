package com.hzy.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SystemQuartz {
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	public void quartz() {
		log.info("Task scheduling ...");
	}


}
