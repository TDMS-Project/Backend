package com.blogs.dtos;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApiResponseDtos {
	private LocalDateTime timeStamp;
	private String message;

	public ApiResponseDtos(String message) {
		super();
		this.message = message;
		this.timeStamp=LocalDateTime.now();
	}

}