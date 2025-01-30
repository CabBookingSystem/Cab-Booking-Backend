package com.cabBooking.Daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.Entities.Booking;

public interface BookingDao extends JpaRepository<Booking,Long> {

}
