package com.cabBooking.Dto;

import com.cabBooking.Entities.Category;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DriverRespDto {

	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String email;
	
	private int phoneNo; 
	
	private Category category;
	
	private long carId;
}
