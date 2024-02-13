package com.portal.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City extends BaseEntity {

	@Column(name = "city_name", nullable = false, length = 25)
	private String cityName;

	@Column(name = "state", nullable = false, length = 30)
	private String state;

	@Column(name = "pin_code", nullable = false)
	private int pincode;
	
	@OneToMany(mappedBy = "city", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Property> propertyList;

//	@OneToOne
//	@JoinColumn(name="user_id")
//	private Users user;
//	
//	
//	public Users getUser() {
//		return user;
//	}
//
//	public void setUser(Users user) {
//		this.user = user;
//	}

	public City() {
		this.propertyList= new ArrayList<Property>();

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
	@Override
	public String toString() {
		return "City [cityName=" + cityName + ", state=" + state + ", pincode=" + pincode + "]";
	}

}
