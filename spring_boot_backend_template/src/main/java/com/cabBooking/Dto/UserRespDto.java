package com.cabBooking.Dto;

import java.time.LocalDate;

import com.cabBooking.Entities.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRespDto extends BaseDto{
	
	private String firstName;

	private String lastName;
	
	private LocalDate dob;
	
	private int phoneNo; 
	
	private boolean status;
	
	private UserRole role ;
}
