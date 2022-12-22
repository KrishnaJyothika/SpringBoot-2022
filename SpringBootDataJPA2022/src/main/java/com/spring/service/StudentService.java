package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.entity.Address;
import com.spring.entity.Student;
import com.spring.repository.AddressRepository;
import com.spring.repository.StudentRepository;
import com.spring.request.CreateStudentRequestModelClass;
import com.spring.request.InQueryFirstName;
import com.spring.request.UpdateStudentRequestModelClass;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public List<Student> getAllStudents(){
		
		return studentRepository.findAll();
	}
	
	
	public Student createStudent(CreateStudentRequestModelClass createStudentRequestModelClass) {
		
		Student student = new Student(createStudentRequestModelClass);
		
		Address address = new Address();
		address.setStreet(createStudentRequestModelClass.getStreet());
		address.setCity(createStudentRequestModelClass.getCity());
		
		address = addressRepository.save(address);
		
		student.setAddress(address);
		student = studentRepository.save(student);
		return student;
	}
	
	
	public Student updateStudent(UpdateStudentRequestModelClass updateStudentRequestModelClass) {
		
		Student student = studentRepository.findById(updateStudentRequestModelClass.getId()).get();
		
		if(student.getFirstName() != null && !student.getFirstName().isEmpty()) {	
			student.setFirstName(updateStudentRequestModelClass.getFirst_name());
		}
		
		studentRepository.save(student);
		
		return student;
	}
	
	public String deleteStudent(Long id) {
		
		studentRepository.deleteById(id);
		
		return "Student : "+id+" has been delected successfully";
	}

	
	public List<Student> findByFirstName(String firstName){
		
		return studentRepository.findByFirstName(firstName);
	}
	
	public Student findByFirstAndLastName(String firstName, String lastName) {
		
		//Method Proxy
		//return studentRepository.findByFirstNameAndLastName(firstName, lastName);
		
		//JPQL
		return studentRepository.getByFirstNameAndLastNameJPQL(firstName, lastName);
	}
	
	public List<Student> findByFirstNameOrLastName(String firstName, String lastName){
		
		return studentRepository.findByFirstNameOrLastName(firstName, lastName);
	}
	
	public List<Student> getByFirstNameIn(InQueryFirstName inQueryFirstName){
		
		return studentRepository.findByfirstNameIn(inQueryFirstName.getFirstNames());
	}
	
	public List<Student> getAllStudentWithPagination(int pageNo, int pageSize){
		
		//select * from student limit 10 offset 10;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return studentRepository.findAll(pageable).getContent();
	}
	
	public List<Student> getAllWithSorting(){
		
		//select * from student order by first_name,last_name,email asc
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName", "lastName", "email");
		
		//Sort sort = Sort.by(Sort.Direction.ASC, "firstName", "lastName");
		//Sort sort = Sort.by(Sort.Direction.ASC, "firstName")
		;
		return studentRepository.findAll(sort);
	}
	
	public List<Student> findByFirstNameContains(String firstName){
		
		return studentRepository.findByFirstNameContains(firstName);
	}
	
	public List<Student> firstNameStartsWith(String firstName){
		
		return studentRepository.findByFirstNameStartsWith(firstName);
	}
	
	public Integer updateStudentWithJPQL(Long id, String firstName) {
		
		return studentRepository.updateFirstNameJPQL(id, firstName);
	}
	
	public Integer deleteStudentByIdJPQL(String firstName) {
		
		return studentRepository.deleteByFirstNameJPQL(firstName);
	}
	
	public List<Student> getByCity(String city){
		
		//return studentRepository.findByAddressCity(city);
		
		return studentRepository.findByAddressCityJPQL(city);
	}
}
