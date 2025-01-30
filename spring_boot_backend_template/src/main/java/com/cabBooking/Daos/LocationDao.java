package com.cabBooking.Daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.Entities.Locations;
import com.cabBooking.Entities.User;

public interface LocationDao extends JpaRepository<Locations,Long>{

	

	

	Locations findBySourceAndDestination(String source, String destination);

	Locations findBySource(String source);

	Locations findByDestination(String destination);

	

	

}
