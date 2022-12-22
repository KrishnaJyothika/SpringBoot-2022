package com.spring.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {
	
	//@JsonIgnore
	private Long id;
	
	//@JsonProperty(value="first_name")
	private String firstName;
	private String lastName;
	private String email;
	
	private String street;
	private String city;
	
	private String fullName;

	public StudentResponse (Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.fullName = student.getFirstName() +" "+ student.getLastName();
		
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
	}
}
