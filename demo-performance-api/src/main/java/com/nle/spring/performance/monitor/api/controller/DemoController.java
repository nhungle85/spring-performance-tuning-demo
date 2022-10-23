package com.nle.spring.performance.monitor.api.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nle.spring.performance.monitor.api.domain.GenericResponse;
import com.nle.spring.performance.monitor.api.service.DeviceService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
public class DemoController {
	private DeviceService deviceService;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/")
	public GenericResponse index() {
		return new GenericResponse(-1, "Hello from Demo Api.");
	}

	@GetMapping("/hello-api")
	public GenericResponse sayHello(
			@RequestParam(name = "name", required = false, defaultValue = "Learner") String name) {
		log.debug("Debug message");
		return new GenericResponse(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/hello-long-wait")
	public GenericResponse sayHelloLong(
			@RequestParam(name = "name", required = false, defaultValue = "Learner") String name) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		return new GenericResponse(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/devices")
	public GenericResponse getDevices() {
		deviceService.getAllDevices();
		return new GenericResponse(counter.incrementAndGet(), "Hello. Check api logs.");
	}
}
