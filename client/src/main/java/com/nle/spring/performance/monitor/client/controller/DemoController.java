package com.nle.spring.performance.monitor.client.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nle.spring.performance.monitor.client.domain.CpuLoader;
import com.nle.spring.performance.monitor.client.domain.DemoPayload;
import com.nle.spring.performance.monitor.client.domain.Device;
import com.nle.spring.performance.monitor.client.domain.Quote;
import com.nle.spring.performance.monitor.client.repository.DeviceRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("client")
public class DemoController {

	// private static Logger logger = LoggerFactory.getLogger(DemoController.class);

	private final String QUOTER_API = "https://quoters.apps.pcfone.io/api/random";

	private final String DEMO_API = "http://localhost:9092";

	private DeviceRepository deviceRepository;
	private RestTemplate restTemplate;
	private CpuLoader tracer;

	@GetMapping
	public String index() {
		return "Hello from Demo Client.";
	}

	@GetMapping("/err")
	public String err() {
		return "Oops";
	}

	@RequestMapping("/oops")
	public void handleRequest() {
		throw new RuntimeException("test exception");
	}
	
	 @GetMapping("/monitor")
	    public String monitor() {
	        tracer.expensiveCalculation(10000);
	        return "Check Logs";
	    }

	    @GetMapping("/query")
	    public Device getQuery() {
	        return deviceRepository.getDevice(1);
	    }

	    @GetMapping("/quoter")
	    public String getQuoter() {
	        Quote quote = restTemplate.getForObject(
	                QUOTER_API, Quote.class);
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) { }
	        return quote.toString();
	    }

	    @GetMapping("/longwait")
	    public DemoPayload getLongwait() {
	    	ResponseEntity<DemoPayload> payload = restTemplate.exchange(DEMO_API + "/hello-long-wait", HttpMethod.GET, null, new ParameterizedTypeReference<DemoPayload>() {});
//	        DemoPayload payload = restTemplate.getForObject(
//	                DEMO_API + "/hello-long-wait", DemoPayload.class);
	        return payload.getBody();
	    }

	    @GetMapping("/devices")
	    public String getDevices() {
	        DemoPayload payload = restTemplate.getForObject(
	                DEMO_API + "/devices", DemoPayload.class);
	        return payload.toString();
	    }

}
