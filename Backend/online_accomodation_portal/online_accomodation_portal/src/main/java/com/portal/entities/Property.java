package com.portal.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "property_details")
@Getter
@Setter
public class Property extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;

	@Column(length = 150)
	private String instructions;

	@Column(name = "status")
	private Boolean isAvailable;

	private int deposit;

	private int rent;
	@Column(length = 75)
	private String society;
	@Column(length = 50)
	private String landmark;
	@Column(length = 75)
	private String area;

	public Property() {

	}

}
