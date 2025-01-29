package com.cabBooking.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.Daos.AdminDao;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.DriverDto;
import com.cabBooking.Entities.Address;
import com.cabBooking.Entities.Driver;
import com.cabBooking.customexception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addDrivers(DriverDto driverDto, Long driverId) {
//		Driver driver = adminDao.findById(driverId).orElseThrow(()-> new ResourceNotFoundException("Invalid Driver ID !!!!"));
//		
//		Address entity = mapper.map(driverDto.getAddress(), Address.class);
//		
//		driver.setDriverAddress(entity);
//		
//		adminDao.save(driver);
//		return new ApiResponse("Driver Added");
		

//		Driver driver;
//        if (driverId != null) {
//        	driver = adminDao.findById(driverId).orElseThrow(()-> new ResourceNotFoundException("Invalid Driver ID !!!!"));
//        } 
//        else {
//            driver = new Driver();
//        }
//
//        driver = mapper.map(driverDto, Driver.class);
//
//        if (driverDto.getAddress() != null) {
//            Address address = mapper.map(driverDto.getAddress(), Address.class);
//            driver.setDriverAddress(address); 
//        }
//
//        Driver savedDriver = adminDao.save(driver);
//
//        return new ApiResponse("Driver and Address added successfully with ID=" + savedDriver.getId());
        return null;
	
	}

	@Override
	public ApiResponse addDrivers(Driver driverEntity) {
		adminDao.save(driverEntity);
		return new ApiResponse("Driver Addded succesufully");
	}        

}


