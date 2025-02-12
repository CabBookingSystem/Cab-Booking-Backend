package com.cabBooking.Service;

import java.util.List;

import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.BookingDetailsDto;
import com.cabBooking.Dto.BookingRespDto;
import com.cabBooking.Dto.DriverRespDto;
import com.cabBooking.Entities.Booking;

public interface DriverService {

	List<BookingRespDto> GetCarType(Long driverId);

	ApiResponse acceptUserRequest(Long bookingId, Long driverId);

	List<DriverRespDto> GetAllDriver();

	//BookingDetailsDto getCustBookingDetails(Long bookingId);

	

}

