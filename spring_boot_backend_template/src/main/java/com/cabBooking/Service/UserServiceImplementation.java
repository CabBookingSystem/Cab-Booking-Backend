package com.cabBooking.Service;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.util.HashMap;
>>>>>>> f5438305f3914aa7495e152c12fc26a6d39cfd2c
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.Daos.DriverDao;
import com.cabBooking.Daos.UserDao;
import com.cabBooking.Dto.AddressDto;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.PasswordDto;
import com.cabBooking.Dto.SignInDto;
import com.cabBooking.Dto.UserResDto;
import com.cabBooking.Dto.UserRespDto;
import com.cabBooking.Entities.Driver;
import com.cabBooking.Entities.User;
import com.cabBooking.Entities.UserRole;
import com.cabBooking.customexception.AuthenticationException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public  class UserServiceImplementation implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DriverDao driverDao;
	
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public ApiResponse userRegistration(User user) {
		User user2=userDao.save(user);
		return new ApiResponse("user Registerd");
	}


	@Override
	public  Object signIn(SignInDto dto) {

		Map<String, Object> response=new HashMap<>();
		User user= userDao.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
	    if (user!=null) {
	       // return new ApiResponse("success","User Login Successful");
	    	return user;
	    	
	         //return response;
	    }

	    // If not a user, try to authenticate as a driver
	    Optional<Driver> driverOptional = driverDao.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
	    if (driverOptional.isPresent()) {
	    	
	       // return new ApiResponse("success","Driver Login Successful");
	    	return driverOptional;
//	    	 response.put("status", "success");
//	         response.put("message", "Driver Login Successful");
//	         response.put("driver", driverOptional.get()); // Use .get() to extract the object
//	         return response;
	    }

	    
	    // If neither user nor driver, throw an exception
	    throw new AuthenticationException("Invalid email or password");
		
		
		
	}


//	@Override
//	public List<UserResDto> GetAllUsers() {
//		// TODO Auto-generated method stub
//		List<UserResDto> userDto = new ArrayList<>();
//		UserResDto user1;
//		List<User>users=userDao.findAll();
//		for (User u : users)
//		{
//			if(u.getRole()==UserRole.CUSTOMER)
//			{
//				user1=modelMapper.map(u, UserResDto.class);
//				userDto.add(user1);
//				//userDto.add(modelMapper.map(u, UserRespDto.class));
//			}
//		}
//		return userDto;
//		//return userDao.findAll().stream().map(user->modelMapper.map(user, UserRespDto.class)).collect(Collectors.toList());
//	}
	
//	@Override
//	public List<UserResDto> GetAllUsers() {
//	    List<UserResDto> userDtoList = new ArrayList<>();
//	    List<User> users = userDao.findAll();
//
//	    for (User u : users) {
//	        if (u.getRole() == UserRole.CUSTOMER) {
//	            UserResDto userDto = modelMapper.map(u, UserResDto.class);
//
//	            // Manually map the address if it exists
//	            if (u.getUserAddress() != null) {
//	                AddressDto addressDto = new AddressDto();
//	                addressDto.setAdrLine1(u.getUserAddress().getAdrLine1());
//	                addressDto.setAdrLine2(u.getUserAddress().getAdrLine2());
//	                addressDto.setCity(u.getUserAddress().getCity());
//	                addressDto.setState(u.getUserAddress().getState());
//	                addressDto.setPinCode(u.getUserAddress().getPinCode());
//
//	                userDto.setAddress(addressDto);
//	            }
//
//	            userDtoList.add(userDto);
//	        }
//	    }
//
//	    return userDtoList;
//	}
	
	@Override
	public List<UserResDto> GetAllUsers() {
	    return userDao.findAll().stream()
	        .filter(user -> user.getRole() == UserRole.CUSTOMER)
	        .map(user -> {
	            UserResDto userDto = modelMapper.map(user, UserResDto.class);
	            
	            // Manually map address if it exists
	            if (user.getUserAddress() != null) {
	                AddressDto addressDto = modelMapper.map(user.getUserAddress(), AddressDto.class);
	                userDto.setAddress(addressDto);
	            }

	            return userDto;
	        })
	        .collect(Collectors.toList());
	}


	@Override
	public ApiResponse deleteUser(Long id) {
	Optional<User> user=userDao.findById(id);
	if(user.isPresent()) {
		User userr=user.get();
		userr.setStatus(false);
		userDao.save(userr);
		 return new ApiResponse("User  deleted successfully");
	}else {
		 return new ApiResponse("User not found");
	}
	}


	@Override
	public List<User> getByRole(UserRole userRole) {
		
		return userDao.findByRole(userRole);
	}


	@Override
	public ApiResponse changeUserpass(PasswordDto passDto) {
		User userEntity=userDao.findByIdAndPassword(passDto.getId(), passDto.getPassword())
				.orElseThrow(()->new AuthenticationException("Invalid Password"));
		
		if(passDto.getNewPassword().equals(passDto.getConpassword())){
			
		userEntity.setPassword(passDto.getNewPassword());
	    userDao.save(userEntity);
	    return new ApiResponse("Password Changed Successfully");
	    }else {
	    	
	    	return new ApiResponse("New Password and Confirm Password shoud match");
	    }
	}
}
