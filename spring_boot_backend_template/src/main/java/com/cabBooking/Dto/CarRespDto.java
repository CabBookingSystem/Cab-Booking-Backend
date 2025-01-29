package com.cabBooking.Dto;

import com.cabBooking.Entities.Category;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarRespDto {
	
	private String carName;
	private String carNo;
	private boolean status;
	private int seats;
	private Category category;
	private byte [] image;

	
	
}
