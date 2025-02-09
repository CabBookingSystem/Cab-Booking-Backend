package com.cabBooking.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.Dto.LocationDestinationDto;
import com.cabBooking.Dto.LocationSourceDto;
import com.cabBooking.Dto.UserRespDto;
import com.cabBooking.Service.LocationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/Location")
@CrossOrigin( origins = "http://localhost:3000")
public class LocationController {
	
	@Autowired
	private LocationService	 locationService;
	
	
	@GetMapping("/loc")
	public ResponseEntity<?> getSources()
	{
		List<LocationSourceDto> loc=locationService.GetAllSources();
		if(loc.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(loc);
		
	}
	
	@GetMapping("/Destination")
	public ResponseEntity<?> getDestinations()
	{
		List<LocationDestinationDto> loc=locationService.GetAllDestinations();
		if(loc.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(loc);
		
	}
	

}
