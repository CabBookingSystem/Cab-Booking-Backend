package com.cabBooking.Service;




import org.modelmapper.ModelMapper;
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
		// TODO Auto-generated method stub
		
		User user2=userDao.save(user);
		
		
		return new ApiResponse("user Registerd");
		
		
	}

	@Override
	public UserRespDto signIn(SignInDto dto) {
		
		User userEntity = userDao.findByEmailAndPassword(dto.getEmail(),dto.getPassword())
				.orElseThrow(()->new AuthenticationException("Invalid email or password"));
		return modelMapper.map(userEntity,UserRespDto.class);
	}
	
	
	

}
