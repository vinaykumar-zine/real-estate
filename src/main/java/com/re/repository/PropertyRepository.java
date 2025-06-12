package com.re.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.re.entities.Property;
import com.re.entities.PropertyType;

public interface PropertyRepository extends JpaRepository<Property, Long> {

	
	List<Property> findByType(PropertyType pt);

}
