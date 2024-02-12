package com.portal.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.Users;

public interface UserDao extends JpaRepository<Users, Long> {

	Optional<Users> findByEmailAndPassword(String email, String password);

	Users findByEmail(String email);
}
