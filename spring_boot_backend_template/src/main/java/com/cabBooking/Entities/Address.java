package com.cabBooking.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "address")

public class Address extends BaseEntity {
	@Column(name="adr_line1",length=100)
	private String adrLine1;
	
	@Column(name="adr_line2",length=100)
	private String adrLine2;
	
	@Column(length=20)
	private String city;
	
	@Column(length=20)
	private String state;
	
	@Column(length=20,name="pin_code")
	private String pinCode;

	public Address(String adrLine1, String adrLine2, String city, String state, String pinCode) {
		super();
		this.adrLine1 = adrLine1;
		this.adrLine2 = adrLine2;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
}
