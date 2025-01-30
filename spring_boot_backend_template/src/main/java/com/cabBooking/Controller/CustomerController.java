package com.cabBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.BookingDto;
import com.cabBooking.Entities.Booking;
import com.cabBooking.Entities.Car;
import com.cabBooking.Service.BookingService;
import com.cabBooking.Service.UserService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private BookingService bookingService;
	
	
	
	@PostMapping("/{cust_id}/bookCar")
	public ResponseEntity<?> BookCab(@PathVariable Long cust_id,@RequestBody BookingDto booking)
	{
		
	try {
			return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.BookCab(cust_id,booking));
	}
	catch(RuntimeException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
	}
		
		//return null;
		
	}


	@DeleteMapping("{id}")
	public ResponseEntity<?> softDeleteuser(@PathVariable Long id){
		try {
			return ResponseEntity.ok(userService.deleteUser(id));
		}catch(RuntimeException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse());
		}
	}
	
	
	
	
	
}
