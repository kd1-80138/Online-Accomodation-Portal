package com.portal.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.custom_exceptions.ResourceNotFoundException;
import com.portal.dao.AddressRepository;
import com.portal.dao.UserRepository;
import com.portal.dto.ApiResponse;
import com.portal.dto.AddressDTO;
import com.portal.entities.Address;
import com.portal.entities.Users;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	public AddressServiceImpl() {
		System.out.println("in a cotr " + getClass());
	}

	@Override
	public ApiResponse assignUserCity(Long userId, @Valid AddressDTO address) {

		Users user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid user Id Or Address not yet assigned !!!!"));

		// map dto --> entity
		Address addressEntity = mapper.map(address, Address.class);

		// establish un dir link , address ---> user
		addressEntity.setUser(user);
		//System.out.println(addressEntity.getCountry());
		// save adr details
		addressRepo.save(addressEntity);
		return new ApiResponse("Assigned new address to User , " + user.getFirstName());
	}

}
