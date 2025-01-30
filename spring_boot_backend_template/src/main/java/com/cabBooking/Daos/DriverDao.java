package com.cabBooking.Daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.Entities.Driver;
import com.cabBooking.Entities.User;

public interface DriverDao extends JpaRepository<Driver,Long>{

	Optional<Driver> findByEmailAndPassword(String email, String password);

}
