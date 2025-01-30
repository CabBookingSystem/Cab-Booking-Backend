package com.cabBooking.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Locations")
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper=true)
public class Locations extends BaseEntity {
	@Column(name="location",length=50)
	private String location;

	public Locations(String location) {
		super();
		this.location = location;
	}
	
	

}
