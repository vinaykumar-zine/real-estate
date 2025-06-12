package com.re.service;

import java.util.List;

import com.re.dtos.ApiResponse;
import com.re.dtos.PropertyReqDto;
import com.re.dtos.PropertyResDto;
import com.re.entities.PropertyType;

public interface PropertyService {

	ApiResponse addNewProperty(PropertyReqDto dto);

	List<PropertyResDto> getAllPeroperties();

	List<PropertyResDto> getPropertyByYpe(PropertyType pt);

	ApiResponse deletById(Long id);

}
