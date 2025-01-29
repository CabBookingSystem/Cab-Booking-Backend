package com.cabBooking.Service;

import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.DriverDto;
import com.cabBooking.Entities.Driver;

public interface AdminService {

//	ApiResponse addDrivers(DriverDto driverDto);

	ApiResponse addDrivers(DriverDto driverDto, Long driverId);

	ApiResponse addDrivers(Driver driverEntity);

}
