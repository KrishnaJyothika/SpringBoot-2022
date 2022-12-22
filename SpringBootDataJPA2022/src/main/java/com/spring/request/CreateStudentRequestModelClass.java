package com.spring.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequestModelClass {
	
	@NotBlank(message = "first Name is requried")
	private String first_name;
	
	private String last_name;
	
	private String email;
	
	private String street;
	
	private String city;

}
