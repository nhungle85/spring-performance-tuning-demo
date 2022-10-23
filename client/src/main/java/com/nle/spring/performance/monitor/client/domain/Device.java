package com.nle.spring.performance.monitor.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {
	private int id;
    private String name;
    private String display;
    private boolean isUp;
    
    @Override
    public String toString() {
        return "Quote{" +
                "id='" + id + '\'' +
                ", name=" + name +
                '}';
    }
}
