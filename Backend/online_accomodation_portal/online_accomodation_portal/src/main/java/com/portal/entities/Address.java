package com.portal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Setter
@Getter
public class Address extends BaseEntity {

	@Column(nullable = false, length = 30)
	private String street;

	@Column(name = "city_name", nullable = false, length = 25)
	private String cityName;

	@Column(name = "state", nullable = false, length = 30)
	private String state;

	@Column(name = "country", nullable = false, length = 30)
	private String country;

	@Column(name = "pin_code", nullable = false)
	private int pincode;

	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id")
	private Users user;

	public Address() {
	}
}
