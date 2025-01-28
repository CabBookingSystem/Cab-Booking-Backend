package com.cabBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.Service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/add-driver")
	public String postMethodName(@RequestBody String entity) {
		
		return entity;
	}
	
}
