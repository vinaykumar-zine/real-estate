package com.re.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
public class ApiResponse {
	
	private String msg;
	private LocalDate tstamp;
	
	public ApiResponse(String msg) {
		this.msg = msg;
		tstamp = LocalDate.now();
	}

}
