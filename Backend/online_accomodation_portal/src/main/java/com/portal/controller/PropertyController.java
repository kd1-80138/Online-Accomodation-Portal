package com.portal.controller;

<<<<<<< HEAD:Backend/online_accomodation_portal/online_accomodation_portal/src/main/java/com/portal/controller/PropertyController.java
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> c6fc4211ce97ca8369668539120321e6bb872c40:Backend/online_accomodation_portal/src/main/java/com/portal/controller/PropertyController.java
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.AddPropertyDto;
<<<<<<< HEAD:Backend/online_accomodation_portal/online_accomodation_portal/src/main/java/com/portal/controller/PropertyController.java
import com.portal.dto.UserDTO;
=======
>>>>>>> c6fc4211ce97ca8369668539120321e6bb872c40:Backend/online_accomodation_portal/src/main/java/com/portal/controller/PropertyController.java
import com.portal.service.PropertyService;

@RestController
@RequestMapping("/property")
<<<<<<< HEAD:Backend/online_accomodation_portal/online_accomodation_portal/src/main/java/com/portal/controller/PropertyController.java
@CrossOrigin(origins = "*")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@PostMapping("/add")
	public ResponseEntity<?> addProperty(@RequestBody @Valid AddPropertyDto dto) {
		System.out.println("in add property " + dto.getSociety());

		return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.addNewProperty(dto));
=======
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
>>>>>>> c6fc4211ce97ca8369668539120321e6bb872c40:Backend/online_accomodation_portal/src/main/java/com/portal/controller/PropertyController.java
	}

}
