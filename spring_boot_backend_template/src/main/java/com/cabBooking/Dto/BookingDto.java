package com.cabBooking.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.cabBooking.Entities.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class BookingDto {
	
	
	
	
	private String source;
	
	
	private String Destination;
	
	
	private LocalDate Date;
	
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")// Enforces only HH:mm format
	private LocalTime time;
	
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	private Long userId;

	public BookingDto(String source, String destination, LocalDate date, LocalTime time, int hour,int minute,Category category,
			Long userId) {
		super();
		this.source = source;
		Destination = destination;
		Date = date;
		 this.time = LocalTime.of(hour, minute);
		this.category = category;
		this.userId = userId;
	}
	
	


}
