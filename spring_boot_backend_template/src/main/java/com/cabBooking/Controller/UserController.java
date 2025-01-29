package com.cabBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.SignInDto;
import com.cabBooking.Dto.SignInDto;
import com.cabBooking.Entities.Car;
import com.cabBooking.Entities.Category;
import com.cabBooking.Entities.User;
import com.cabBooking.Entities.UserRole;
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
	// @PostMapping(value = "/signin", consumes = "application/json", produces = "application/json")
	@PostMapping("/signin")
	public ResponseEntity<?> userSignIn(@RequestBody SignInDto dto ){
		System.out.println("In sign In dto "+dto);
		
		return ResponseEntity.ok(userService.signIn(dto));
	}
	
	
	@GetMapping("/role/{userRole}")
	public ResponseEntity<?> getRole(@PathVariable UserRole userRole){
	    List<User> role=userService.getByRole(userRole);
	    return ResponseEntity.ok(role);
	    
	}
}
