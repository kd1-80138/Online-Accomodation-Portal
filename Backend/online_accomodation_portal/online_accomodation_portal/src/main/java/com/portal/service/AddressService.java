package com.portal.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.portal.dto.ApiResponse;
import com.portal.dto.AddressDTO;

public interface AddressService {

	ApiResponse assignUserCity(Long userId, @Valid AddressDTO city);

}
