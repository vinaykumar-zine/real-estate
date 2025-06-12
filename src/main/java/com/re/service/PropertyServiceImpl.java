package com.re.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.re.custom_exception.ApiException;
import com.re.dtos.ApiResponse;
import com.re.dtos.PropertyReqDto;
import com.re.dtos.PropertyResDto;
import com.re.entities.Property;
import com.re.entities.PropertyType;
import com.re.repository.PropertyRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {
	
	private final PropertyRepository propertyRepository;
	private final ModelMapper modelMapper;
	
	
	@Override
	public ApiResponse addNewProperty(PropertyReqDto dto) {
		System.out.println("before persistance: "+dto);
		Property p = modelMapper.map(dto, Property.class);
		propertyRepository.save(p);
		System.out.println("after persistance: "+ p);
		return new ApiResponse("property added successfuly");
	}
	@Override
	public List<PropertyResDto> getAllPeroperties() {
		List<PropertyResDto> list = propertyRepository.findAll().stream().map(p-> modelMapper.map(p, PropertyResDto.class)).collect(Collectors.toList());
		if(list!=null)
			return list;
		throw new ApiException("no properties presents!");
	}
	@Override
	public List<PropertyResDto> getPropertyByYpe(PropertyType pt) {
		List<Property> list = propertyRepository.findByType(pt);
		return list.stream().map(p->modelMapper.map(p, PropertyResDto.class)).collect(Collectors.toList());
	}
	@Override
	public ApiResponse deletById(Long id) {
		propertyRepository.findById(id).orElseThrow(()->new ApiException("invalid id!"));
		propertyRepository.deleteById(id);
		return new ApiResponse("property deleted successfuly with id: "+id);
	}
	
	

}
