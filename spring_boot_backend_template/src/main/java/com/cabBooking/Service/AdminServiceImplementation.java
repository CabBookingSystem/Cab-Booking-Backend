package com.cabBooking.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cabBooking.Daos.LocationDao;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.CarReqDto;
import com.cabBooking.Entities.Locations;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.Daos.CarDao;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.CarRespDto;
import com.cabBooking.Entities.Car;
import com.cabBooking.Entities.Category;
import com.cabBooking.Entities.User;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImplementation implements AdminService {


	
	@Autowired
	private LocationDao locationDao;

	@Autowired
	private CarDao carDao;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public ApiResponse addCar(CarReqDto carDto) {
		Car carEntity=modelmapper.map(carDto, Car.class);
		carDao.save(carEntity);
		return new ApiResponse("success","car Added");
		
	}

	@Override
	public CarRespDto getCarDetails(Long carId) {
		Car car=carDao.findById(carId).orElseThrow();
		return modelmapper.map(car,CarRespDto.class);
	}

	@Override
	
	public ApiResponse deleteCar(Long carId) {
		if(carDao.existsById(carId)) {
			carDao.deleteById(carId);
			
			return new ApiResponse("Delete car successfully");
		}
		else {
		return new ApiResponse("Invalid car id");
		}
	}

	

	@Override
	public ApiResponse addLocations(Locations location) {
		// TODO Auto-generated method stub
		locationDao.save(location);
		
		return new ApiResponse("Location Added!!");
	}

	@Override
	public List<Car> getByCategory(Category carCategory) {
		
		return carDao.findByCategory(carCategory);
	}

	@Override
	public List<Car> findCarByStatus(Boolean status) {
		
		return carDao.findByStatus(status);
	}

	

}
