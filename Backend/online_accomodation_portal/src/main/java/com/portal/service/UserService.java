package com.portal.service;

import com.portal.dto.LoginDto;

public interface UserService {
	
	Boolean validateUser (LoginDto dto);

}
