package com.nle.spring.performance.monitor.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
	 private String type;
     private Value value;
     
     @Override
     public String toString() {
         return "Quote{" +
                 "type='" + type + '\'' +
                 ", value=" + value +
                 '}';
     }
}
