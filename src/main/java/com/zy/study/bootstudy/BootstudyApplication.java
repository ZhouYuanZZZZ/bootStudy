package com.zy.study.bootstudy;

import com.zy.study.bootstudy.properties.PropertiesTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BootstudyApplication {

	private static final Logger logger = LoggerFactory.getLogger(BootstudyApplication.class);

	@Resource
	private PropertiesTest propertiesTest;

	public static void main(String[] args) {
		SpringApplication.run(BootstudyApplication.class, args);
	}


	@RequestMapping("helloWorld")
	public String helloWorld() {
		logger.info("hello world:{}",propertiesTest.getName());
		return "hello world xxxxxx";
	}
}
