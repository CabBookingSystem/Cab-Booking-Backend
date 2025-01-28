package com.cabBooking.Service;

<<<<<<< HEAD
=======



import org.modelmapper.ModelMapper;
>>>>>>> cc30d5d7e91f466aff36009485459be0369a997f
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cabBooking.Daos.UserDao;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.SignInDto;
import com.cabBooking.Dto.UserRespDto;
import com.cabBooking.Entities.User;
import com.cabBooking.customexception.AuthenticationException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public ApiResponse userRegistration(User user) {
		User user2=userDao.save(user);
		return new ApiResponse("user Registerd");
	}
<<<<<<< HEAD
=======

	@Override
	public UserRespDto signIn(SignInDto dto) {
		
		User userEntity = userDao.findByEmailAndPassword(dto.getEmail(),dto.getPassword())
				.orElseThrow(()->new AuthenticationException("Invalid email or password"));
		return modelMapper.map(userEntity,UserRespDto.class);
	}
	
	
	

>>>>>>> cc30d5d7e91f466aff36009485459be0369a997f
}
