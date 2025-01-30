package com.cabBooking.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.Daos.BookingDao;
import com.cabBooking.Daos.LocationDao;
import com.cabBooking.Daos.UserDao;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.BookingDto;
import com.cabBooking.Dto.BookingRespDto;
import com.cabBooking.Entities.Booking;
import com.cabBooking.Entities.Category;
import com.cabBooking.Entities.Locations;
import com.cabBooking.Entities.User;
import com.cabBooking.Entities.UserRole;
import com.cabBooking.customexception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingServiceImplementation implements BookingService {
	

	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LocationDao locationDao;
	
	@Autowired
	private ModelMapper mapper;

	
	
	@Override
	public ApiResponse BookCab(Long cust_id, BookingDto booking) {
		// TODO Auto-generated method stub
		
		Long userId=booking.getUserId();
		Category category=booking.getCategory();
		
		
		User user=userDao.findById(userId)
				.orElseThrow(()->
				new ResourceNotFoundException("Invalid user id!!!!"));
		
		//Check if user is customer or not
		if(user.getRole()==UserRole.CUSTOMER)
		{
			
			//System.out.println("customer if validlocationn");
			
			String source=booking.getSource().toLowerCase();
			String destination=booking.getDestination().toLowerCase();
			
			//check Source and Destination are not equal
			if(source.equalsIgnoreCase(destination))
			{
				return new ApiResponse("source and Destination Cannot be same!!!");
			}
			
			
			Locations validSource=locationDao.findBySource(source);
			Locations validDestination=locationDao.findByDestination(destination);
			
			if(validSource==null || validDestination==null)
			{
				throw new ResourceNotFoundException("enter valid locations!!");
			}
		
			else
			{
				Booking bookingEntity=mapper.map(booking, Booking.class);
				bookingEntity.setUser(user);
				bookingDao.save(bookingEntity);		
			}
		}
		else
		{
			return new ApiResponse("user is not valid!!!");
		}
		
		return new ApiResponse("Request Sent!!!");
	}

	
	
	@Override
	public List<BookingRespDto> GetAllBookings() {
		// TODO Auto-generated method stub
		
		List<Booking> bookingEntity=bookingDao.findAll();
		List<BookingRespDto>bookingResp=new ArrayList<>();
		for(Booking b:bookingEntity)
		{
			BookingRespDto bookingDto=mapper.map(b, BookingRespDto.class);
			if(b.getUser()!=null)
			{
			User user=b.getUser();
			bookingDto.setFirstName(user.getFirstName());
			bookingDto.setLastName(user.getLastName());
			}
			bookingResp.add(bookingDto);
		}
		
		return bookingResp;
		
		//return bookingDao.findAll().stream().map(booking->mapper.map(booking, BookingRespDto.class)).collect(Collectors.toList());
	}

	
	
}
