package com.spring.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentRequestModelClass {
	
	@NotNull(message = "Student ID is requried")
	private Long id;
	
	private String first_name;
	
	private String last_name;
	
	private String email;

}
