package com.cabBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.Dto.BookingRespDto;
import com.cabBooking.Dto.DriverRespDto;
import com.cabBooking.Service.DriverService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/Driver")

public class DriverController {

	@Autowired 
	private DriverService driverService;
	
	@GetMapping("/{driverId}")
	public ResponseEntity<?> getReqByType(@PathVariable Long driverId){
		return ResponseEntity.status(HttpStatus.FOUND).body(driverService.GetCarType(driverId));
	}
	
	@PutMapping("/{driverId}/{bookingId}")
	public ResponseEntity<?> acceptUserReq(@PathVariable Long bookingId,@PathVariable Long driverId){
		return ResponseEntity.status(HttpStatus.FOUND).body(driverService.acceptUserRequest(bookingId,driverId));
	}
	
	@GetMapping("/driver-details")
	public ResponseEntity<?> getAllDrivers(){
//		List<BookingRespDto> bookings=bookingService.GetAllBookings();
//		if(bookings.isEmpty())
//		{
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
//		return ResponseEntity.ok(bookings);
		
		List<DriverRespDto> drivers = driverService.GetAllDriver();
		if(drivers.isEmpty())
		{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
		return ResponseEntity.ok(drivers);
		
		
	}
		
}
