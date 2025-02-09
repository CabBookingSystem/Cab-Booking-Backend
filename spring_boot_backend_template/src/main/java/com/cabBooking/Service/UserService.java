package com.cabBooking.Service;

import java.util.List;

import com.cabBooking.Dto.ApiResponse;

import com.cabBooking.Dto.BookingDto;

import com.cabBooking.Dto.PasswordDto;

import com.cabBooking.Dto.SignInDto;
import com.cabBooking.Dto.UserResDto;
import com.cabBooking.Dto.UserRespDto;
import com.cabBooking.Entities.User;
import com.cabBooking.Entities.UserRole;

public interface UserService {

	ApiResponse userRegistration(User user);
	
	ApiResponse signIn(SignInDto signin);

	List<UserResDto> GetAllUsers();

	ApiResponse deleteUser(Long id);

	List<User> getByRole(UserRole userRole);

	ApiResponse changeUserpass(PasswordDto passDto);

	

	
}
