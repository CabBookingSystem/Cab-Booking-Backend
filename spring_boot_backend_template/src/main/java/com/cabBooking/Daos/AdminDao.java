package com.cabBooking.Daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.Dto.DriverDto;
import com.cabBooking.Entities.Driver;
import com.cabBooking.Entities.User;

public interface AdminDao extends JpaRepository<Driver, Long> {


}
