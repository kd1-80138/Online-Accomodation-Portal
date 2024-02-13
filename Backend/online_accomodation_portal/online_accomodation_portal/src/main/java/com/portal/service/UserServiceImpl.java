package com.portal.service;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.custom_exceptions.ApiException;
import com.portal.custom_exceptions.ResourceNotFoundException;
import com.portal.dao.UserDao;
import com.portal.dto.ApiResponse;
import com.portal.dto.EditPasswordDTO;
import com.portal.dto.ForgetPassOtpDTO;
import com.portal.dto.LoginDto;
import com.portal.dto.UserDTO;
import com.portal.dto.UserUpdateDTO;
import com.portal.entities.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	@Autowired
	private ModelMapper mapper;

	public UserServiceImpl() {
		System.out.println("in a cotr " + getClass());
	}

	// add new user
	@Override
	public UserDTO addNewUser(UserDTO dto) {

		// if (dto.getPassword().equals(dto.getConfirmPassword())) {
		Users user = mapper.map(dto, Users.class);

		userdao.save(user);
		return mapper.map(user, UserDTO.class);
		// }
		// throw new ApiException("Password Invalid Try Again ");
	}

	// update user
	@Override
	public UserUpdateDTO updateUserDetails(UserUpdateDTO user) {
		Users user2 = userdao.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Id or Not yet assigned "));

		mapper.map(user, user2);

		userdao.save(user2);

		return mapper.map(user2, UserUpdateDTO.class);
	}

	// get user by id;
	@Override
	public UserDTO getById(Long id) {
		Users user = userdao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
		return mapper.map(user, UserDTO.class);
	}

	// sign in /login
	@Override
	public ApiResponse Signin(LoginDto req) {
		Users user = userdao.findByEmailAndPassword(req.getEmail(), req.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("invalid email or Password....!"));
		System.out.println(user);
		mapper.map(user, LoginDto.class);
		return new ApiResponse("Successfuly Loged In");
	}

	// change password
	@Override
	public String editCustomerPassword(EditPasswordDTO pass) {

		Users cust = userdao.findById(pass.getId()).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id"));
		if (cust.getPassword().equals(pass.getOldpassword())) {
			cust.setPassword(pass.getNewpaasword());
			return "Password changed successfully";
		}
		return "Invalid email or old password";
	}

//	@Override
//	public void getOtpForForgotPass(String email) {
//
//	}

//	@Override
//	public ApiResponse passwordReset(ForgetPassOtpDTO fpass) {
//		Users user = userdao.findByEmail(fpass.getEmail());
//
//		if (user != null && user.getEmail().equals(fpass.getEmail())) {
//			user.setPassword(fpass.getPassword());
//			userdao.save(user);
//		}
//		return new ApiResponse("Password changed Successfully");
//
//	}
}
