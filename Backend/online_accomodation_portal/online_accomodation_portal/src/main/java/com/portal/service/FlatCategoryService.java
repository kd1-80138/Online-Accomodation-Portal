package com.portal.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.portal.dto.ApiResponse;
import com.portal.dto.FlatCategoryDTO;

public interface FlatCategoryService {

	ApiResponse addingFlatCategory(Long propertyId, FlatCategoryDTO flatdto);

}
