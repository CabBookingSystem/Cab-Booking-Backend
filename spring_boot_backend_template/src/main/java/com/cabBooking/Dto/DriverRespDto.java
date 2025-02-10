package com.cabBooking.Dto;

import java.time.LocalDate;
import com.cabBooking.Entities.Address;
import com.cabBooking.Entities.Category;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DriverRespDto {


	private Long id;

	private String firstName;
	
	private String lastName;
	

	private LocalDate dob;
	

	private int age;
	
	private String email;
	

	private String password;
	
	

	private String address;
	
	private Category category;
	
	private byte[] adharImage;
	
	private byte[] drivingLicence; 
	

	private int phoneNo; 
	
	
	private long carId;
}
