package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.spring.request.CreateStudentRequestModelClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Transient
	private String fullName;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	public Student(CreateStudentRequestModelClass createStudentRequestModelClass) {
		
		this.firstName = createStudentRequestModelClass.getFirst_name();
		this.lastName = createStudentRequestModelClass.getLast_name();
		this.email = createStudentRequestModelClass.getEmail();
		this.fullName = createStudentRequestModelClass.getFirst_name() + " " + createStudentRequestModelClass.getLast_name();
	}
	
}
