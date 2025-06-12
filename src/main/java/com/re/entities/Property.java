package com.re.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "properties")
@NoArgsConstructor
@ToString
public class Property {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String propertyName;
	
	@Enumerated(value = EnumType.STRING)
	private PropertyType type;
	
	private double price;
	
	private String owner;
	
	private String address;
	
	private String city;
	
	private String pincode;
}
