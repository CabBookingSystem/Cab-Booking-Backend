package com.cabBooking.Dto;

import com.cabBooking.Entities.Category;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CarReqDto {



	
	

		
		private String carName;
		
		
		private String carNo;
		
		
		
		
		
		private int seats;

		@Enumerated(EnumType.STRING)
		private Category category;
		
		
		
		//private byte [] image;
	



		
		
	}

	
	
	

