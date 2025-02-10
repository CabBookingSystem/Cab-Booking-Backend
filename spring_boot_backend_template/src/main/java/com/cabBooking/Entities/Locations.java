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
	
	@Column(name="source",length=50)
	private String source;
	
	@Column(name="km")
	private double km;
	
	@Column(name="destination",length=50)
	private String destination;
	
	
	@Column(name="distance")
	private double distance;
	
	public Locations(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}

	
	
	

}
