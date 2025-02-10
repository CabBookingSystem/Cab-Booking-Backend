package com.cabBooking.Service;

import java.util.List;

import com.cabBooking.Dto.ApiResponse;
import com.cabBooking.Dto.BookingDto;
import com.cabBooking.Dto.BookingRespDto;

public interface BookingService {
	
	Object BookCab( BookingDto booking);

	List<BookingRespDto> GetAllBookings();

	ApiResponse softDeleteBooking(Long id);

	ApiResponse hardDeleteBooking(Long bookid);

	BookingRespDto getDetails(Long id);

}
