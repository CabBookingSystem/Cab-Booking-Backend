package com.cabBooking.Entities;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Booking")
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper=true)
public class Booking extends BaseEntity {
	

	@Column(name="source",length=50)
	private String source;
	
	@Column(name="Destination",length=50)
	private String Destination;
	
	@Column(name="Date",nullable=false)
	private LocalDate Date;
	
	@Column(name="time",nullable=false)
	private LocalTime time;
	
	@Column(name="amount",length=50,nullable=false)
	private double amount;
	

	@OneToOne
	@JoinColumn(name="cust_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="driver_id")
	private Driver driver;
	
	@OneToOne
	@JoinColumn(name="car_id")
	private Car car;
	
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private Status status=Status.PENDING;

	//argConstructor
	public Booking(String source, String destination, LocalDate date, LocalTime time, double amount, Status status) {
		super();
		this.source = source;
		Destination = destination;
		Date = date;
		this.time = time;
		this.amount = amount;
		this.status = status;
	}
}
