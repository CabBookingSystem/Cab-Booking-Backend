package com.cabBooking.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cabBooking.Dto.DriverDto;
import com.cabBooking.Dto.UserResDto;
import com.cabBooking.Service.AdminService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.BookingRespDto;
import com.cabBooking.Dto.CarReqDto;
import com.cabBooking.Dto.CarRespDto;
import com.cabBooking.Dto.UserRespDto;
import com.cabBooking.Entities.Car;
import com.cabBooking.Entities.Category;
import com.cabBooking.Entities.Locations;
import com.cabBooking.Entities.User;
import com.cabBooking.Service.BookingService;
import com.cabBooking.Service.UserService;

@RestController
@RequestMapping("/Admin")
@CrossOrigin( origins = "http://localhost:3000")

public class AdminController {
	@Autowired
	private AdminService  adminService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private BookingService bookingService;


	
	@PostMapping("/addcar")
	public ResponseEntity<?> addCar(@RequestBody CarReqDto car)
	{
		try 
		{
		    System.out.println("Received Car Object: " + car);  
			   System.out.println("Car Name in Controller: " + car.getCarName());
			return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addCar(car));
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteCar(@RequestParam() Long carId){
		try {
			return ResponseEntity.ok(adminService.deleteCar(carId));
		}catch(RuntimeException e){
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	
	
	@GetMapping("/{carId}")
	public ResponseEntity<?> getCategoryDetails(@PathVariable Long carId) {
		System.out.println("in get dtls " + carId);
	
			CarRespDto category = adminService
					.getCarDetails(carId);
			return ResponseEntity.ok(category);

	}
	
	@GetMapping("/category/{carCategory}")
	public ResponseEntity<?> getCategory(@PathVariable Category carCategory){
	    List<Car> cars=adminService.getByCategory(carCategory);
	    return ResponseEntity.ok(cars);
	    
	}
	
	@GetMapping("/availablecars")
	public ResponseEntity<?> findAvailableVehicals(){
		List<Car> cars=adminService.findAvailableVehicals();
		return ResponseEntity.ok(cars);
	}
	
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
		
		List<UserResDto> users=userService.GetAllUsers();
		if(users.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/bookings")
	public ResponseEntity<?> DisplayBookings()
	{
		List<BookingRespDto> bookings=bookingService.GetAllBookings();
		if(bookings.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(bookings);
	}

	
	@PostMapping("/add-driver")
	public ResponseEntity<?> addDrivers(@RequestBody DriverDto driverDto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addDriver(driverDto));
	}	
	

	
}
	

