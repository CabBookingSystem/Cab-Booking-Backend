package com.cabBooking.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.Daos.LocationDao;
import com.cabBooking.Dto.LocationDestinationDto;
import com.cabBooking.Dto.LocationSourceDto;
import com.cabBooking.Entities.Locations;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocationServiceImplementation implements LocationService {

	@Autowired
	private LocationDao locationDao;
	
	@Autowired 
	private ModelMapper mapper;
	
	@Override
	public List<LocationSourceDto> GetAllSources() {
		// TODO Auto-generated method stub
		
		
		return locationDao.findAll().stream().map(location->mapper.map(location, LocationSourceDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<LocationDestinationDto> GetAllDestinations() {
		// TODO Auto-generated method stub
		return locationDao.findAll().stream().map(location->mapper.map(location, LocationDestinationDto.class)).collect(Collectors.toList());
	}
	
	
	

}
