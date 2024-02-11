package com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.AddPropertyDto;
import com.portal.service.PropertyService;

@RestController
@RequestMapping("/property")
@CrossOrigin()
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	
	
	@PostMapping("/add")
	public String addProperty(@RequestBody AddPropertyDto dto )
	{
		if(propertyService.addProperty(dto))
		{
			return "SuccessFully Added Property";
		}
		
		return "Failed To add property";
	}

}
