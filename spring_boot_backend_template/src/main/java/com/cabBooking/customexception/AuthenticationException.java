package com.cabBooking.customexception;

public class AuthenticationException extends RuntimeException {
public AuthenticationException(String errormsg) {
	super(errormsg);
}
	
}
