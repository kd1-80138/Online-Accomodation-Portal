package com.portal.service;

import com.portal.dto.LoginDto;
import com.portal.dto.UserDTO;

public interface UserService {

	Boolean validateUser(LoginDto dto);

	UserDTO addNewUser(UserDTO dto);

}
