package com.cabBooking.Daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.Entities.User;
import com.cabBooking.Entities.UserRole;

public interface UserDao extends JpaRepository<User ,Long> {
	
        User findByEmailAndPassword(String em,String pass);

		List<User> findByRole(UserRole userRole);
		
		Optional<User> findByIdAndPassword(Long long1,String pass);
}
