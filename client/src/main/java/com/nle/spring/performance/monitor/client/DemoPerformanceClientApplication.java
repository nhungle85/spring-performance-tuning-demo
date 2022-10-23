package com.nle.spring.performance.monitor.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.nle.spring.performance.monitor.client.domain.CpuLoader;
import com.nle.spring.performance.monitor.client.manage.DemoManager;

@SpringBootApplication
public class DemoPerformanceClientApplication {

	private static DemoManager demoManager;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoPerformanceClientApplication.class, args);
		
//		demoManager = new DemoManager();
//		demoManager.init("challenge-jvm");
	}

	@Bean
	public CpuLoader tracer(){
		return new CpuLoader();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) {
//		return args -> {
//			Quote quote = restTemplate.getForObject(
//					"https://quoters.apps.pcfone.io/api/random", Quote.class);
//		};
//	}
}
