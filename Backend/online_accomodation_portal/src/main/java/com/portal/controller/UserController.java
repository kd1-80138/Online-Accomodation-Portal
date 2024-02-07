package com.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	public UserController() {
		System.out.println("in a user cotr " + getClass());
	}
}
