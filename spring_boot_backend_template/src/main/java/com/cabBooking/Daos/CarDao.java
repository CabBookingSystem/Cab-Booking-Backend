package com.cabBooking.Daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.Entities.Car;
import com.cabBooking.Entities.Category;

public interface CarDao extends JpaRepository<Car,Long>{

	List<Car> findByCategory(Category carCategory);

}
