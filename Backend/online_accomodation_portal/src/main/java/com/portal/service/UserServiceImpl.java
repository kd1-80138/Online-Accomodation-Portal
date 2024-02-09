package com.portal.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.portal.dao.UserDao;
import com.portal.dto.LoginDto;
import com.portal.entities.Users;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public Boolean validateUser(LoginDto dto) {
		Users user = userdao.findByEmail(dto.getEmail());
		if(user !=null)
		{
			return false;
		}
		else {
			if(user.getEmail().equals(dto.getEmail()))
				return true;
		}
		
		return false;
	}

}
