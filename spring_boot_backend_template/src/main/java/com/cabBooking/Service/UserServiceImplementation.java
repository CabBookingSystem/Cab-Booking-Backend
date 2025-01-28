package com.cabBooking.Service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.Daos.UserDao;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Entities.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

	
	@Autowired
	private UserDao userDao;
	
	@Override
	public ApiResponse userRegistration(User user) {
		// TODO Auto-generated method stub
		
		User user2=userDao.save(user);
		
		
		return new ApiResponse("user Registerd");
		
		
	}
	
	
	

}
