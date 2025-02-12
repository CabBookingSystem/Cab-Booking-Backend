package com.cabBooking.Daos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.Entities.BookingHistory;

public interface BookingHistoryDao extends JpaRepository<BookingHistory,Long>{

}