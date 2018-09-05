package com.octopus;

import com.octopus.repositories.PageRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OctopusStarterApplication {

	private static final Log logger = LogFactory.getLog(OctopusStarterApplication.class);

	@Autowired
	private PageRepository pageRepository;

	public static void main(String[] args) {
		SpringApplication.run(OctopusStarterApplication.class);
		logger.info("Init OctopusStarterApplication.class");
	}
}
