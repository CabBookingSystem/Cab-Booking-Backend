package com.cabBooking.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cabBooking.Daos.LocationDao;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Entities.Locations;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.cabBooking.Daos.AdminDao;
import com.cabBooking.Daos.CarDao;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.CarRespDto;
import com.cabBooking.Dto.DriverDto;
import com.cabBooking.Entities.Car;
import com.cabBooking.Entities.Category;
import com.cabBooking.Entities.Driver;
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
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public ApiResponse addDriver(DriverDto driverDto) {
		
		
		Driver driverEntity = modelmapper.map(driverDto, Driver.class);
		
		Category cat = driverDto.getCategory();
		
		List<Car> cars = carDao.findByCategoryAndStatus(cat, true);
		
		for(Car c : cars) {
			driverEntity.setCarId(c);
			c.setStatus(false);
			break;
		}
		adminDao.save(driverEntity);
		return  new ApiResponse("Driver Added ");
		
	}
	
	@Override
	public ApiResponse addCar(Car car) {
		Car cars=carDao.save(car);
		return new ApiResponse("car Added");
		
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
	
		locationDao.save(location);
		
		return new ApiResponse("Location Added!!");
	}

	@Override
	public List<Car> getByCategory(Category carCategory) {
		
		return carDao.findByCategory(carCategory);
	}

	@Override
	public List<Car> findAvailableVehicals() {
		
		return carDao.findByStatus(true);
	}
}
