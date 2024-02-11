package com.portal.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.portal.dto.AddPropertyDto;


public interface PropertyService {
	
	Boolean addProperty(AddPropertyDto dto) ;
}
