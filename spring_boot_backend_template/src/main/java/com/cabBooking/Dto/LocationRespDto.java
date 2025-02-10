package com.cabBooking.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationRespDto {

	private String source;
	private String destination;
	private String distance;
}
