package com.cabBooking.Daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.Entities.Locations;

public interface LocationDao extends JpaRepository<Locations,Long>{

}
