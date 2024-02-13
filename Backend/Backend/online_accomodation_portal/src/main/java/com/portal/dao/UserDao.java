package com.portal.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.Users;
public interface UserDao extends JpaRepository<Users, Long> {

	
	public Users findByEmail(String email);

}
