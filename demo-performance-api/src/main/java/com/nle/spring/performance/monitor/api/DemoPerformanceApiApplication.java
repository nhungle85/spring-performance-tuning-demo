package com.nle.spring.performance.monitor.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class DemoPerformanceApiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoPerformanceApiApplication.class, args);
		SpringApplication apiDemoApplication = new SpringApplication(DemoPerformanceApiApplication.class);
		BufferingApplicationStartup bas = new BufferingApplicationStartup(1000); //set to 1000 events are allowed -- usually just 400 events
		//bas.addFilter(startupStep -> startupStep.getName().startsWith("spring.boot.application.starting"));
		apiDemoApplication.setApplicationStartup(bas);
		
		apiDemoApplication.run(args);
	}

}
