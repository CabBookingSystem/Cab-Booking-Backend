package com.cabBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin( origins = "http://localhost:3000")
public class CustomerController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private BookingService bookingService;
	
	
	
	@PostMapping("/bookCar")
	public ResponseEntity<?> BookCab(@RequestBody BookingDto booking)
	{
		
	try {
			return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.BookCab(booking));
	}
	catch(RuntimeException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
	}
		
		//return null;
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> confirmBooking(@PathVariable Long id)
	{
		try {
			return ResponseEntity.ok(bookingService.getDetails(id));
		}catch(RuntimeException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse());
		}
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> softDeleteuser(@PathVariable Long id){
		try {
			return ResponseEntity.ok(userService.deleteUser(id));
		}catch(RuntimeException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse());
		}
	}
	
	
	@DeleteMapping("/softDelete/{bookid}")
	public ResponseEntity<?> softDeleteBooking(@PathVariable Long bookid){
		try {
			return ResponseEntity.ok(bookingService.softDeleteBooking(bookid));
		}catch(RuntimeException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse());
		}
	}
	
	
	@DeleteMapping("/hardDelete/{bookid}")
	public ResponseEntity<?> hardDeleteBooking(@PathVariable Long bookid){
		try {
			return ResponseEntity.ok(bookingService.hardDeleteBooking(bookid));
		}catch(RuntimeException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse());
		}
	}
	
	
	
	
}
