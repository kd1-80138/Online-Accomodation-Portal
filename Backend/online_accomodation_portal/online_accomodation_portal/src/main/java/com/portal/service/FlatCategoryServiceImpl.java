package com.portal.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.custom_exceptions.ResourceNotFoundException;
import com.portal.dao.FlatCategoryRepository;
import com.portal.dao.PropertyRepository;
import com.portal.dto.ApiResponse;
import com.portal.dto.FlatCategoryDTO;
import com.portal.entities.FlatCategory;
import com.portal.entities.Property;

@Service
@Transactional
public class FlatCategoryServiceImpl implements FlatCategoryService {

	@Autowired
	private FlatCategoryRepository flatRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PropertyRepository propertyRepo;

	@Override
	public ApiResponse addingFlatCategory(Long propertyId, FlatCategoryDTO flatdto) {

		Property property = propertyRepo.findById(propertyId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Property Id or not yet assigned !!!!"));
		FlatCategory flatEntity = mapper.map(flatdto, FlatCategory.class);
		flatEntity.setProperty(property);
		flatRepo.save(flatEntity);
		return new ApiResponse("Added new flats to property of owner , " + property.getUser());
	}

}
