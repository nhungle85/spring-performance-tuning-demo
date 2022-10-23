/**
 * This class is copied from kdflint for learning purpose
 */
package com.nle.spring.performance.monitor.api.domain;

import java.util.Properties;

public class DemoProperties {
	private Properties runtimeProperties;

	public void setRuntimeProperties(Properties props) {
		this.runtimeProperties = props;
	}

	public Properties getRuntimeProperties() {
		return runtimeProperties;
	}

	public String getDemoMode() {
		return this.runtimeProperties.getProperty("demo.mode");
	}
}
