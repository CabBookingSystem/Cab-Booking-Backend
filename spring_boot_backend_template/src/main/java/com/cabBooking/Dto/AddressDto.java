package com.cabBooking.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

	private String adrLine1;
	
	private String adrLine2;
	
	private String city;
	
	private String state;
	
	private String pinCode;
}
