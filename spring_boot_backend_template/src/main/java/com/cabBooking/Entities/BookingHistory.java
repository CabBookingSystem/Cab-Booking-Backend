package com.cabBooking.Entities;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.annotations.ManyToAny;
import org.springframework.context.annotation.Fallback;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="BookingHistory")
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper=true)
public class BookingHistory extends BaseEntity{
//	@Column(name="source",length=50)
//	private String source;
//	
//	@Column(name="Destination",length=50)
//	private String Destination;
//	
//	@Column(name="Date",nullable=false)
//	private LocalDate Date;
//	
//	@Column(name="time",nullable=false)
//	private LocalTime time;
//	
//	@Column(name="amount",length=50,nullable=false)
//	private double amount;
//	
//	@Enumerated(EnumType.STRING)
//	@Column(name = "status", length = 20)
//	private Status status;
//
//	@Enumerated(EnumType.STRING)
//	@Column(name="category")
//	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@OneToOne
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking booking;
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;
	

}
