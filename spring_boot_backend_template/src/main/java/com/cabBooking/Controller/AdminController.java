package com.cabBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.CarRespDto;
import com.cabBooking.Dto.SignInDto;
import com.cabBooking.Dto.UserRespDto;
import com.cabBooking.Entities.Car;
import com.cabBooking.Entities.Category;
import com.cabBooking.Entities.Locations;
import com.cabBooking.Entities.User;
import com.cabBooking.Service.AdminService;

import com.cabBooking.Service.UserService;



@RestController
@RequestMapping("/Admin")
public class AdminController {
	

	@Autowired
	private AdminService  adminService;

	@Autowired
	private UserService userService;

	
	@PostMapping("/car")
	public ResponseEntity<?> addCar(@RequestBody Car car)
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
	
	@GetMapping("getStatus/{carStatus}")
	public ResponseEntity<?> getCarByStatus(@PathVariable Boolean carStatus){
		List<Car> cars=adminService.findCarByStatus(carStatus);
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
		
		List<UserRespDto> users=userService.GetAllUsers();
		if(users.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(users);
		
	}

	
}
	

