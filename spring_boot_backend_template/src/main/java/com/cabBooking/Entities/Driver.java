package com.cabBooking.Entities;
import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name ="Driver")
@ToString(callSuper = true, exclude = {"driverAddress", "adharImage", "drivingLicence", "password"})
public class Driver extends BaseEntity{
	@Column(name = "first_Name", length = 20)
	private String firstName;
	
	@Column(name = "last_Name", length = 20)
	private String lastName;
	
	private LocalDate dob;
	
	private int age;
	
	@Column(length = 25, unique = true)
	private String email;
	
	@Column(length = 20, nullable = false) 
	private String password;
	
	@Column(name = "phone_No",length = 10, nullable = false, unique = true)
	private int phoneNo; 
	
	@Lob
	private byte[] adharImage;
	
	@Lob
	private byte[] drivingLicence;
	
	private boolean status;
	
	private String address;
	
	@OneToOne
	@JoinColumn(name = "car_id")
	private Car carId;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30) 
	private Category category;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30) 
	private UserRole role = UserRole.DRIVER;
	
	@OneToOne
	@JoinColumn(name ="booking_id")
	private Booking bookingId;

	public Driver(String firstName, String lastName, LocalDate dob, int age, String email, String password, int phoneNo,
			byte[] adharImage, byte[] drivingLicence, boolean status, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.age = age;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.adharImage = adharImage;
		this.drivingLicence = drivingLicence;
		this.status = status;
		this.address = address;
	}
}
