package com.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
	
	private String street;
	private String cityName;
	private String state;
	private String country;
	private int pincode;
	// private LocalDate someDate;
}
