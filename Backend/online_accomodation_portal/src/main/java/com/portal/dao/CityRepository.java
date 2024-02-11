package com.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.City;
import com.portal.entities.Property;

public interface CityRepository extends JpaRepository<City, Long> {


	City findByCityName(String cityName);


}
