package com.portal.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.custom_exceptions.ApiException;
import com.portal.dao.UserRepository;
import com.portal.dto.LoginDto;
import com.portal.dto.UserDTO;
import com.portal.entities.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Boolean validateUser(LoginDto dto) {
		Users user = userRepo.findByEmail(dto.getEmail());
		if (user != null) {
			return false;
		} else {
			if (user.getEmail().equals(dto.getEmail()))
				return true;
		}

		return false;
	}

	// add new user
	@Override
	public UserDTO addNewUser(UserDTO dto) {

		 if (dto.getPassword().equals(dto.getConfirmPassword())) {
		Users user = modelMapper.map(dto, Users.class);

		userRepo.save(user);
		return modelMapper.map(user, UserDTO.class);
		 }
		 throw new ApiException("Password Invalid Try Again ");
	}

}
