package com.nle.spring.performance.monitor.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device implements Serializable{
	@Id
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
