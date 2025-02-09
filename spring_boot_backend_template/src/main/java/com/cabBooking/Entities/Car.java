package com.cabBooking.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	private boolean status=true;
	
	@Column(name = "seats",nullable=false)
	private int seats=5;

	@Enumerated(EnumType.STRING)
	@Column(length = 30) 
	private Category category;
	
	
	@Lob
	private byte [] image;
	public Car(String carName, String carNo, boolean status, int seats, Category category, byte[] image) {
		super();
		this.carName = carName;
		this.carNo = carNo;
		this.status = status;
		this.seats = seats;
		this.category = category;
		this.image = image;
	}



	
	
}
