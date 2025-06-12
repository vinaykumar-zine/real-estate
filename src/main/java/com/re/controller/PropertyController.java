package com.re.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.re.dtos.PropertyReqDto;
import com.re.entities.PropertyType;
import com.re.service.PropertyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/properties")
public class PropertyController {
	
	private final PropertyService propertyService;
	
	@PostMapping
	public ResponseEntity<?> addProperty(@RequestBody PropertyReqDto dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.addNewProperty(dto));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllPropertyInfo()
	{
		return ResponseEntity.ok(propertyService.getAllPeroperties());
	}
	
	@GetMapping("/{property_type}")
	public ResponseEntity<?> getAllMatchingProperties(@PathVariable PropertyType property_type)
	{
		return ResponseEntity.ok(propertyService.getPropertyByYpe(property_type));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePropertyById(@PathVariable Long id)
	{
		return ResponseEntity.ok(propertyService.deletById(id));
	}
 
}
