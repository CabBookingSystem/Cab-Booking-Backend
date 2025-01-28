package com.cabBooking.Daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.Entities.User;

public interface UserDao extends JpaRepository<User ,Long> {

}
