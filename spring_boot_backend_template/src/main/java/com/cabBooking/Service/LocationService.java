package com.cabBooking.Service;

import java.util.List;

import com.cabBooking.Dto.LocationDestinationDto;
import com.cabBooking.Dto.LocationSourceDto;

public interface LocationService {

	List<LocationSourceDto> GetAllSources();

	List<LocationDestinationDto> GetAllDestinations();

	//Double getDistance(String source, String destination);

	Double getDistance(LocationSourceDto locations);

	//Object getLocation();

	
		
}
