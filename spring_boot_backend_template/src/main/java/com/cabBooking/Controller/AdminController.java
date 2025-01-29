package com.cabBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cabBooking.Dto.DriverDto;
import com.cabBooking.Entities.Driver;
import com.cabBooking.Service.AdminService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/{driverId}/add-driver")
	public ResponseEntity<?> addDriver(@RequestBody DriverDto driverDto, @PathVariable Long driverId) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addDrivers(driverDto, driverId));
	}
	
	@PostMapping("/add-driver")
	public ResponseEntity<?> addDrivers(@RequestBody Driver driverEntity) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addDrivers(driverEntity));
	}
	
	
}
