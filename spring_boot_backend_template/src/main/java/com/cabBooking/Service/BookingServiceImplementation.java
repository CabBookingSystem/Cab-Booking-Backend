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
import com.cabBooking.Entities.Status;
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
	public Object BookCab(BookingDto booking) {
		// TODO Auto-generated method stub
		double price=10;//for 5km
		double distance,totalAmt;
		BookingRespDto bookingdto = null;
		
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
//			if(source.equalsIgnoreCase(destination))
//			{
//				return new ApiResponse("source and Destination Cannot be same!!!");
//			}
			
			
//			Locations validSource=locationDao.findBySource(source);
//			Locations validDestination=locationDao.findByDestination(destination);
			
		if(!source.equalsIgnoreCase(destination))
		{
			Locations validRoute=locationDao.findBySourceAndDestination(source,destination);			
//			if(validSource==null || validDestination==null)
//			{
//				throw new ResourceNotFoundException("enter valid locations!!");
//			}
			if(validRoute==null)
			{
				throw new ResourceNotFoundException("enter valid locations!!");
			}
			else
			{
				distance=validRoute.getDistance();
				totalAmt=price*distance;
				
				Booking bookingEntity=mapper.map(booking, Booking.class);
				bookingEntity.setUser(user);
				bookingEntity.setAmount(totalAmt);
				Booking bookingE=bookingDao.save(bookingEntity);
				bookingdto=mapper.map(bookingE, BookingRespDto.class);
				
			}
		}
		else
		{
			return new ApiResponse("error","Source and Destination can not be same");
		}

		}
		else
			
		{
			return new ApiResponse("error","User is not valid");
		}
		//return new ApiResponse("Request Sent!!!");
		return bookingdto;
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



	@Override
	public ApiResponse softDeleteBooking(Long bookingId) {
		// TODO Auto-generated method stub
		Booking booking=bookingDao.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Invalid Id"));
		booking.setStatus(Status.COMPLETED);
		return new ApiResponse("success","Journey Completed");
	}

	@Override
	public ApiResponse hardDeleteBooking(Long bookingId) {
		// TODO Auto-generated method stub
		//Booking booking=bookingDao.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Invalid Id"));
		bookingDao.deleteById(bookingId);
		return new ApiResponse("success","Booking Canceled");
	}



	@Override
	public BookingRespDto getDetails(Long id) {
		// TODO Auto-generated method stub
		Booking bookingEntity=bookingDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Invali id"));
		BookingRespDto bookingDto=mapper.map(bookingEntity, BookingRespDto.class);
		return bookingDto;
	}

	
}
