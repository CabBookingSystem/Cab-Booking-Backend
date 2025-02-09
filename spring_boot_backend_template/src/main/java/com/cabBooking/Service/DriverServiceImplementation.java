package com.cabBooking.Service;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabBooking.Daos.BookingDao;
import com.cabBooking.Daos.DriverDao;
import com.cabBooking.Daos.UserDao;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.BookingRespDto;
import com.cabBooking.Entities.Booking;
import com.cabBooking.Entities.Category;
import com.cabBooking.Entities.Driver;
import com.cabBooking.Entities.Status;
import com.cabBooking.Entities.User;
import com.cabBooking.customexception.ResourceNotFoundException;

@Service
@Transactional
public class DriverServiceImplementation implements DriverService{

	@Autowired
	private DriverDao driverDao;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Autowired
    private BookingDao bookingDao;
	
	@Autowired 
	private UserDao userDao;
	
	@Override
	public List<BookingRespDto> GetCarType(Long driverId) {
		Driver driver=driverDao.findById(driverId).orElseThrow(()->new ResourceNotFoundException("Not found"));
		Category category=driver.getCategory();
		
		List<Booking> bookings=bookingDao.findAllByCategory(category);
		List<BookingRespDto>bookingResp=new ArrayList<>();
		for(Booking b:bookings)
		{
			if(b.getStatus()==Status.PENDING)
			{
			BookingRespDto bookingDto=modelMapper.map(b, BookingRespDto.class);
			if(b.getUser()!=null)
			{
			User user=b.getUser();
			bookingDto.setFirstName(user.getFirstName());
			bookingDto.setLastName(user.getLastName());
			}
			bookingResp.add(bookingDto);
			}
		}
	
		
		 if (bookings.isEmpty()) {
		        throw new ResourceNotFoundException("No customers found for this car category");
		    }
	 
		 return  bookingResp;
		
	}

	@Override
	public ApiResponse acceptUserRequest(Long bookingId,Long driverId) {
		Driver driver=driverDao.findById(driverId).orElseThrow(()->new ResourceNotFoundException("Id Not Found"));
		
		Booking booking=bookingDao.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Id Not Found"));
		
		driver.setBookingId(booking);
		
		booking.setDriver(driver);
		booking.setStatus(Status.ASSIGNED);
		
	    bookingDao.save(booking);
	    return new ApiResponse("User request accepted successfully");
	}
	
//	
//	@Override
//	public List<BookingRespDto> GetCarType(Long driverId) {
//	    Driver driver = driverDao.findById(driverId)
//	        .orElseThrow(() -> new ResourceNotFoundException("Driver not found"));
//
//	    Category category = driver.getCategory();
//
//	    List<Booking> bookings = bookingDao.findAllByCategory(category);
//
//	    if (bookings.isEmpty()) {
//	        throw new ResourceNotFoundException("No customers found for this car category");
//	    }
//
//	    return bookings.stream().map(b -> {
//	        BookingRespDto bookingDto = modelMapper.map(b, BookingRespDto.class);
//	        User user = b.getUser();
//	        if (user != null) {
//	            bookingDto.setFirstName(user.getFirstName());
//	            bookingDto.setLastName(user.getLastName());
//	        }
//	        return bookingDto;
//	    }).collect(Collectors.toList());
//	}

	
	
	


}
