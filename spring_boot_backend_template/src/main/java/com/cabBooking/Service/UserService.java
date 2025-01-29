package com.cabBooking.Service;

import java.util.List;

import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.SignInDto;
import com.cabBooking.Dto.UserRespDto;
import com.cabBooking.Entities.User;
import com.cabBooking.Entities.UserRole;

public interface UserService {

	ApiResponse userRegistration(User user);
	
	UserRespDto signIn(SignInDto signin);

	List<UserRespDto> GetAllUsers();

	ApiResponse deleteUser(Long id);

	List<User> getByRole(UserRole userRole);

	
}
