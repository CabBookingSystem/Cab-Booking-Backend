package com.cabBooking.Service;

import java.util.List;

import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.BookingDto;
import com.cabBooking.Dto.BookingRespDto;

public interface BookingService {
	
	ApiResponse BookCab(Long cust_id, BookingDto booking);

	List<BookingRespDto> GetAllBookings();

}
