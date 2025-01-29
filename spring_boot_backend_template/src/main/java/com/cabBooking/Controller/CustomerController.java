package com.cabBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.Service.UserService;

import io.swagger.v3.oas.models.responses.ApiResponse;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired 
	private UserService userService;
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> softDeleteuser(@PathVariable Long id){
		try {
			return ResponseEntity.ok(userService.deleteUser(id));
		}catch(RuntimeException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse());
		}
	}
	
	
	
	
	
}
