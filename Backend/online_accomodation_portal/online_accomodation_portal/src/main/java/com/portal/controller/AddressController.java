package com.portal.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.AddressDTO;
import com.portal.service.AddressService;

@RestController
@RequestMapping("/user/{userId}/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	public AddressController() {
		System.out.println("in a cotr " + getClass());
	}

	// assign address/address to user
	// http://host:port/user/{userId}/address
	// method post
	@PostMapping
	public ResponseEntity<?> assignUserAddress(@PathVariable @NotNull Long userId,
			@RequestBody @Valid AddressDTO address) {
		System.out.println("in assign adr " + userId + " " + address.getCountry());
		return ResponseEntity.status(HttpStatus.CREATED).body(addressService.assignUserCity(userId, address));
	}
}
