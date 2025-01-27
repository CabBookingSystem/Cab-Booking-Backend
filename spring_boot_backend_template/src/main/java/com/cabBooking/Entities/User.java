package com.cabBooking.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@ToString
public class User extends BaseEntity {

	@Column(name = "firstName", length = 20)
	private String firstName;
	
	@Column(name = "lastName", length = 20)
	private String lastName;
}
