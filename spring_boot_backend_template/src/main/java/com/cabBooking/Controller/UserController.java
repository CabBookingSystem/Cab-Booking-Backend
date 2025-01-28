package com.cabBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Entities.User;
import com.cabBooking.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> userSignUp(@RequestBody User user)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.userRegistration(user));
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
		
	}

}
