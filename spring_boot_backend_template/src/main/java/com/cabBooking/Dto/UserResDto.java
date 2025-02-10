package com.cabBooking.Dto;

import java.time.LocalDate;

import com.cabBooking.Entities.UserRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResDto {
	private Long Id;
	private String firstName;

	private String lastName;
	
	private LocalDate dob;
	
	private int phoneNo; 
	
	private boolean status;
	
	private UserRole role ;
	
	 private AddressDto address; 
}
