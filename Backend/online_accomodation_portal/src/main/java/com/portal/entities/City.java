package com.portal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City extends BaseEntity {

	@Column(name = "cirt_name", nullable = false, length = 25)
	private String cityName;

	@Column(name = "state", nullable = false, length = 30)
	private String state;

	@Column(name = "pin_code", nullable = false)
	private int pincode;

	public City() {

	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
