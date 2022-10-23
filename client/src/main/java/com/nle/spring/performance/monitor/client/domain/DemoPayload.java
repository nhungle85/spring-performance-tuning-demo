package com.nle.spring.performance.monitor.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemoPayload {
	private int id;
    private String message;
    
    @Override
    public String toString() {
        return "DemoPayload{" +
                "id='" + id + '\'' +
                ", message=" + message +
                '}';
    }
}
