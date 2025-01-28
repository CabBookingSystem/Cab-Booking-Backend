package com.cabBooking.Dto;

import java.time.LocalDate;

import com.cabBooking.Entities.UserRole;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignInDto {
	
	private String email;
	
	
	private String password;
	
}
