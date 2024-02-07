package com.portal.entities;

import javax.persistence.Column; 
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Property extends BaseEntity {
	
	@JoinColumn(name="user_id")
	private User user;
	@JoinColumn(name="category_id")
	private Category category ;
	@Column(length =150 )
	private String instructions ;
	@Column(name = "status" )
	private Boolean isAvailable;
	
	private int deposit;
	
	private int rent;
	@Column(length = 75)
	private String society;
	@Column(length=50)
	private String landmark;
	@Column(length = 75)
	private String area;
	
	@JoinColumn(name= "city_id")
	private City city;
	

}
