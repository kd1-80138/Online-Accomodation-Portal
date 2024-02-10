package com.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.entities.FlatCategory;

@Repository
public interface FlatCategoryRepository extends JpaRepository<FlatCategory, Long> {

}
