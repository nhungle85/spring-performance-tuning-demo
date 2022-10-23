package com.nle.spring.performance.monitor.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nle.spring.performance.monitor.api.domain.Device;
import com.nle.spring.performance.monitor.api.repository.DeviceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeviceService {
	private DeviceRepository deviceRepository;
	
	public List<Device> getAllDevices() {
		return deviceRepository.findAll();
	}
}
