package com.portal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.AddPropertyDto;
import com.portal.dto.UserDTO;
import com.portal.service.PropertyService;

@RestController
@RequestMapping("/property")
@CrossOrigin(origins = "*")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@PostMapping("/add")
	public ResponseEntity<?> addProperty(@RequestBody @Valid AddPropertyDto dto) {
		System.out.println("in add property " + dto.getSociety());

		return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.addNewProperty(dto));
	}

}
