package com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD:Backend/online_accomodation_portal/online_accomodation_portal/src/main/java/com/portal/controller/UserController.java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> c6fc4211ce97ca8369668539120321e6bb872c40:Backend/online_accomodation_portal/src/main/java/com/portal/controller/UserController.java
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD:Backend/online_accomodation_portal/online_accomodation_portal/src/main/java/com/portal/controller/UserController.java
import com.portal.dto.EditPasswordDTO;
import com.portal.dto.ForgetPassOtpDTO;
import com.portal.dto.LoginDto;
import com.portal.dto.UserDTO;
import com.portal.dto.UserUpdateDTO;
import com.portal.entities.Users;
=======
import com.portal.dto.LoginDto;
>>>>>>> c6fc4211ce97ca8369668539120321e6bb872c40:Backend/online_accomodation_portal/src/main/java/com/portal/controller/UserController.java
import com.portal.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "*" })
public class UserController {

<<<<<<< HEAD:Backend/online_accomodation_portal/online_accomodation_portal/src/main/java/com/portal/controller/UserController.java
=======
	
>>>>>>> c6fc4211ce97ca8369668539120321e6bb872c40:Backend/online_accomodation_portal/src/main/java/com/portal/controller/UserController.java
	@Autowired
	private UserService userService;
	
	

	public UserController() {
		System.out.println("in a user cotr " + getClass());
	}
<<<<<<< HEAD:Backend/online_accomodation_portal/online_accomodation_portal/src/main/java/com/portal/controller/UserController.java

	// Adding new user
	// http://localhost:7070/user/register
	// method= post
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody @Valid UserDTO dto) {
		System.out.println("in add user " + dto.getFirstName());

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(dto));
	}

	// Update user
	// http://localhoast:7070/user/edit
	@PutMapping("/edit")
	public ResponseEntity<?> updateUser(@RequestBody @Valid UserUpdateDTO user) {
		return ResponseEntity.ok(userService.updateUserDetails(user));
	}

	// to get specific user
	// http://localhoast:7070/user/{id}
	@GetMapping("/{id}")
	public UserDTO getById(@PathVariable Long id) {
		System.out.println("in listUsers");
		return userService.getById(id);
	}

	// change password
	// http://localhoast:7070/user/password
	@PutMapping("/password")
	public ResponseEntity<?> changePassword(@RequestBody EditPasswordDTO password) {
		System.out.println("hiiiiiiiiiiiiiiiiii");
		return ResponseEntity.status(HttpStatus.OK).body(userService.editCustomerPassword(password));
	}

	// Forgot password send otp
	// http://localhoast:7070/user/password
//	@PostMapping("/getotpforforgotpass")
//	public ResponseEntity<String> getOtpForForgotPass(@RequestBody ForgetPassOtpDTO emailId) {
//		System.out.println(emailId);
//		String email = emailId.getEmail();
//		System.out.println(email);
//		userService.getOtpForForgotPass(email);
//		return ResponseEntity.ok("OTP sent for verification.");
//	}

//	@PostMapping("/forgotpass")
//	public ResponseEntity<?> forgotPassword(@RequestBody ForgetPassOtpDTO fpass) {
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(userService.passwordReset(fpass));
//	}
=======
	@PostMapping("/login")
	public String  validateUser(@RequestBody LoginDto dto )
	{
		System.out.println(dto.getEmail()+" "+dto.getPassword());
		
		if(userService.validateUser(dto))
			return "valid user";
		
		return "Invalid User";
	}
		
>>>>>>> c6fc4211ce97ca8369668539120321e6bb872c40:Backend/online_accomodation_portal/src/main/java/com/portal/controller/UserController.java
}
