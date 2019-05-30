package com.hzy.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SystemInitRunner implements CommandLineRunner{

	protected Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public void run(String... arg0) throws Exception {
		log.info("SystemInitRunner run...");
		
	}
	
	

}
