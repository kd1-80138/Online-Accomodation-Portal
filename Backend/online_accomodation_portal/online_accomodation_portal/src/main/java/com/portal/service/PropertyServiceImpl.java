package com.portal.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.CityRepository;
import com.portal.dao.FlatCategoryRepository;
import com.portal.dao.PropertyRepository;
import com.portal.dao.UserDao;
import com.portal.dto.AddPropertyDto;
import com.portal.dto.ApiResponse;
import com.portal.entities.City;
import com.portal.entities.FlatCategory;
import com.portal.entities.Property;
import com.portal.entities.Users;
import com.portal.exception.CustomException;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository propertyRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CityRepository cityRepo;

	@Autowired
	private FlatCategoryRepository flatRepo;

	@Autowired
	private UserDao userDao;

	@SuppressWarnings("unused")
	@Override
	public ApiResponse addNewProperty(AddPropertyDto dto) {

		System.out.println(dto.toString());

		Property property = mapper.map(dto, Property.class);
		Users user = userDao.findById(dto.getUserId()).orElseThrow(() -> new CustomException("User Invalid"));

		property.setUser(user);

		City city = cityRepo.findByCityName(dto.getCityName());
		System.out.println(city.toString());
		if (city == null) {
			city = mapper.map(dto, City.class);
			cityRepo.save(city);
			property.setCity(city);
		} else {
			property.setCity(city);

		}
		FlatCategory flatCategory = mapper.map(dto, FlatCategory.class);
		System.out.println(flatCategory.toString());
		flatRepo.save(flatCategory);
		System.out.println(flatCategory.toString());

		property.setCategory(flatCategory);

		System.out.println(flatCategory.toString());
		propertyRepo.save(property);
		System.out.println(property.getSociety() + " " + property.getIsAvailable());

		return new ApiResponse("Added new property of owner , " + property.getUser());
	}

}
