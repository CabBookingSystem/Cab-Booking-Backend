package com.cabBooking.Entities;

import java.time.LocalDate;

import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = {"userAddress", "password"})
public class User extends BaseEntity {

	@Column(name = "first_Name", length = 20)
	private String firstName;
	
	@Column(name = "last_Name", length = 20)
	private String lastName;
	
	private LocalDate dob;
	
	@Column(length = 25, unique = true)
	private String email;
	
	@Column(length = 20, nullable = false) 
	private String password;
	
	@Column(name = "phone_No",length = 10, nullable = false, unique = true)
	private int phoneNo; 
	
	private boolean status;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30) 
	private UserRole role;
	
	@OneToOne
	@JoinColumn(name= "address_id")
	private Address userAddress;

	public User(String firstName, String lastName, LocalDate dob, String email, String password, int phoneNo,
			boolean status, UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.status = status;
		this.role = role;
	}
	
	
	
}
