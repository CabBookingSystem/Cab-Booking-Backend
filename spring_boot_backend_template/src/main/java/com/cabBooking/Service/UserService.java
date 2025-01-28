package com.cabBooking.Service;

import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Entities.User;

public interface UserService {

	ApiResponse userRegistration(User user);
	

	
}
