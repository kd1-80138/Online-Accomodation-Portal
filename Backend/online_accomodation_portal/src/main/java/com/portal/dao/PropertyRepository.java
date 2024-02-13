package com.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.Property;

public interface PropertyRepository  extends JpaRepository<Property, Long>{
	
}
