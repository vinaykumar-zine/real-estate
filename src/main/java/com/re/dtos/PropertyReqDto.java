package com.re.dtos;

import com.re.entities.PropertyType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PropertyReqDto {
	private String propertyName;
	
	private PropertyType type;
	
	private double price;
	
	private String owner;
	
	private String address;
	
	private String city;
	
	private String pincode;
}
