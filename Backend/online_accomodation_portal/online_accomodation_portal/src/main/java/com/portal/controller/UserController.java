package com.portal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.UserDTO;
import com.portal.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("in a user cotr " + getClass());
	}

	// http://localhost:7070/user
	// method= post
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody @Valid UserDTO dto) {
		System.out.println("in add user " + dto.getFirstName());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(dto));
	}
}
