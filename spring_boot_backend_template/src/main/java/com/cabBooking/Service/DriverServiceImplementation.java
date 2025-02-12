package com.cabBooking.Service;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabBooking.Daos.BookingDao;
import com.cabBooking.Daos.BookingHistoryDao;
import com.cabBooking.Daos.DriverDao;
import com.cabBooking.Daos.UserDao;
import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.BookingDetailsDto;
import com.cabBooking.Dto.BookingRespDto;
import com.cabBooking.Dto.DriverRespDto;
import com.cabBooking.Entities.Booking;
import com.cabBooking.Entities.BookingHistory;
import com.cabBooking.Entities.Category;
import com.cabBooking.Entities.Driver;
import com.cabBooking.Entities.Status;
import com.cabBooking.Entities.User;
import com.cabBooking.customexception.ResourceNotFoundException;
import com.cabBooking.Dto.DriverRespDto;

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
	
	
	@Autowired 
	private BookingHistoryDao bookHistoryDao;
	
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

	
	
	
//	@Override
//	public BookingDetailsDto getCustBookingDetails(Long bookingId) {
//		// TODO Auto-generated method stub
//		Booking bookingDetails = bookingDao.findById(bookingId).orElseThrow(()-> new ResourceNotFoundException("Id is not valid"));
//		
//		User user=bookingDetails.getUser();
//		System.out.println("user fname"+user.getFirstName());
//		System.out.println("user lname "+user.getLastName());
//		
//		BookingDetailsDto bookingDto = modelMapper.map(bookingDetails, BookingDetailsDto.class);
//		
//		bookingDto.setFirstName(user.getFirstName());
//		bookingDto.setLastName(user.getLastName());
//		
//		return bookingDto;
//	}

//	@Override
//	public ApiResponse completeJourney(Long bookingId) {
//		// TODO Auto-generated method stub
//		
//	    Booking booking = bookingDao.findById(bookingId)
//	            .orElseThrow(() -> new ResourceNotFoundException("Booking ID not found"));
//	    
//	    booking.setStatus(Status.COMPLETED);
//	    bookingDao.save(booking);
//
//	    BookingHistory bookingHistory = bookHistoryDao.findById(bookingId)
//	            .orElseThrow(() -> new ResourceNotFoundException("Booking history not found"));
//	   
//	   // bookingHistory.setStatus(Status.COMPLETED);
//	    bookHistoryDao.save(bookingHistory);
//
//	    return new ApiResponse("Journey completed successfully");
//	}
//	
	
	
	
	//@Override
//	public List<DriverRespDto> GetAllDriver() {
//		return driverDao.findAll().stream().map(driver -> modelMapper.map(driver, DriverRespDto.class)).collect(Collectors.toList());
//		// TODO Auto-generated method stub
//		//return driverDao.findAll().stream().map(driver->modelMapper.map(driver, driverRespDto.class)).collect(Collectors.toList());
//        
//	}
	
	@Override
	public List<DriverRespDto> GetAllDriver() {
	    List<Driver> drivers = driverDao.findAll();  // Fetch all drivers
	    List<DriverRespDto> driverRespDtos = new ArrayList<>();

	    for (Driver driver : drivers) {
	        // Manually map the fields
	        DriverRespDto driverRespDto = new DriverRespDto();
	        
	        driverRespDto.setId(driver.getId());  
	        driverRespDto.setFirstName(driver.getFirstName());
	        driverRespDto.setLastName(driver.getLastName());
	        driverRespDto.setAge(driver.getAge());
	        driverRespDto.setDob(driver.getDob());
	        driverRespDto.setEmail(driver.getEmail());
	        driverRespDto.setPhoneNo(driver.getPhoneNo());
	        driverRespDto.setCategory(driver.getCategory());

	        // Manually set carId from the associated Car entity
//	        if (driver.getCarId() != null) {
//	            driverRespDto.setCarId(driver.getCarId().getId());
//	        } else {
//	            driverRespDto.setCarId(0L);  // If no car, you can set a default value
//	        }

	        // Add the mapped DTO to the list
	        driverRespDtos.add(driverRespDto);
	    }

	    return driverRespDtos;
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
