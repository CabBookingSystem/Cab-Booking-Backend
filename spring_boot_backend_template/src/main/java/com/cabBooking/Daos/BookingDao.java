package com.cabBooking.Daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.Entities.Booking;
import com.cabBooking.Entities.Car;
import com.cabBooking.Entities.Category;

public interface BookingDao extends JpaRepository<Booking,Long> {
	

	List<Booking> findAllByCategory(Category category);
}
