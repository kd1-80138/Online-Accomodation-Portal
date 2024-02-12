package com.portal.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.portal.dto.AddPropertyDto;
import com.portal.dto.ApiResponse;

public interface PropertyService {

	ApiResponse addNewProperty(AddPropertyDto dto);
}
