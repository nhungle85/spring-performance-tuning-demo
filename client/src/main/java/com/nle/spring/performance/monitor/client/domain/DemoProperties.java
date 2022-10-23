package com.nle.spring.performance.monitor.client.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties(prefix = "demo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoProperties {
	private String mode;
}
