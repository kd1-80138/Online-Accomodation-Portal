package com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.LoginDto;
import com.portal.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	

	public UserController() {
		System.out.println("in a user cotr " + getClass());
	}
	@PostMapping("/login")
	public String  validateUser(@RequestBody LoginDto dto )
	{
		System.out.println(dto.getEmail()+" "+dto.getPassword());
		
		if(userService.validateUser(dto))
			return "valid user";
		
		return "Invalid User";
	}
		
}
