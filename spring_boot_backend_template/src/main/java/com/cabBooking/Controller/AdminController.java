package com.cabBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.UserRespDto;
import com.cabBooking.Entities.Locations;
import com.cabBooking.Service.AdminService;
import com.cabBooking.Service.UserService;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/add-locations")
	public ResponseEntity<?> addLocations(Locations location)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addLocations(location));
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	@GetMapping("/Customers")
	public ResponseEntity<?> DisplayCustomers()
	{
		List<UserRespDto> users=userService.GetAllUsers();
		if(users.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(users);
		
	}
	
	
	
	

}
