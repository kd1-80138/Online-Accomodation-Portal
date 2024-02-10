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

import com.portal.dto.FlatCategoryDTO;
import com.portal.service.FlatCategoryService;

@RestController
@RequestMapping("/property/{propertyId}/category")
public class FlatCategoryController {

	@Autowired
	private FlatCategoryService flatService;

	public FlatCategoryController() {
		System.out.println("in a cotr " + getClass());
	}

	// adding flat_categories to properties
	// http://host:port/property/{propertyId}/category
	// method post

	@PostMapping
	public ResponseEntity<?> addFlatCategory(@PathVariable @NotNull Long propertyId,
			@RequestBody @Valid FlatCategoryDTO flatdto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(flatService.addingFlatCategory(propertyId, flatdto));

	}
}
