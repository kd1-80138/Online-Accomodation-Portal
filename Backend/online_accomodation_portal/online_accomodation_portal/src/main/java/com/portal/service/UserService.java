package com.portal.service;

import javax.validation.Valid;

import com.portal.dto.ApiResponse;
import com.portal.dto.EditPasswordDTO;
import com.portal.dto.ForgetPassOtpDTO;
import com.portal.dto.LoginDto;
import com.portal.dto.UserDTO;
import com.portal.dto.UserUpdateDTO;

public interface UserService {

	UserDTO addNewUser(UserDTO dto);

	UserUpdateDTO updateUserDetails(UserUpdateDTO user);

	UserDTO getById(Long id);

	ApiResponse Signin(@Valid LoginDto request);

	String editCustomerPassword(EditPasswordDTO password);

//	void getOtpForForgotPass(String email);
//
//	ApiResponse passwordReset(ForgetPassOtpDTO fpass);

}
