package com.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
