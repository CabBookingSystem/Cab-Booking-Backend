package com.cabBooking.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="car")
public class Car  extends BaseEntity{

	@Column(name = "carName", length = 20,nullable=false)
	private String carName;
	
	@Column(name="carNo",length=8,unique=true,nullable=false)
	private String carNo;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "seats",nullable=false)
	private int seats;

	@Lob
	private byte [] image;
}
