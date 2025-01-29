package com.cabBooking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cabBooking.Daos.LocationDao;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Entities.Locations;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImplementation implements AdminService {

	
	@Autowired
	private LocationDao locationDao;
	
	
	@Override
	public ApiResponse addLocations(Locations location) {
		// TODO Auto-generated method stub
		locationDao.save(location);
		
		return new ApiResponse("Location Added!!");
	}

}
