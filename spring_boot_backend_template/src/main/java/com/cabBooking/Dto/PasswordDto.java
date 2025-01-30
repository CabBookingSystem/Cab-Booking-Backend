package com.cabBooking.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PasswordDto {

	private Long id;
	private String password;
	private  String newPassword;
	private String conpassword;
}
