package com.cabBooking.Daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.Entities.User;

public interface UserDao extends JpaRepository<User ,Long> {
        Optional<User> findByEmailAndPassword(String em,String pass);
}
