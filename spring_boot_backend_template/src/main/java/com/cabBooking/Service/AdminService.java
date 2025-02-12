package com.cabBooking.Service;

import java.util.List;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.CarReqDto;
import com.cabBooking.Dto.CarRespDto;
import com.cabBooking.Dto.DriverDto;
import com.cabBooking.Entities.Car;
import com.cabBooking.Entities.Category;
import com.cabBooking.Entities.Locations;
import com.cabBooking.Entities.Driver;

public interface AdminService {

		ApiResponse addLocations(Locations location);

		
		ApiResponse addCar(CarReqDto car);
		
		CarRespDto getCarDetails(Long catId);
		
//		ApiResponse updateCategory(Long carId, Car category);
		
		ApiResponse deleteCar(Long carId);
		
		List<Car>getByCategory(Category carCategory);

		ApiResponse addDriver(DriverDto driverDto);


		List<Car> findAvailableVehicals();


		List<Car> findCarByStatus(Boolean status);

		
}

