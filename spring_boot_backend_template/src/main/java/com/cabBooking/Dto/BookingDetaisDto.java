package com.cabBooking.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.cabBooking.Entities.Category;
import com.cabBooking.Entities.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingDetaisDto {
private String source;
	
    private Long id;
	
	private String Destination;
	
	
	private LocalDate Date;
	
	
	private LocalTime time;
	
	private double amount;
	
	private String firstName;
	
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Enumerated(EnumType.STRING)
	private Status status=Status.PENDING;
	


}
