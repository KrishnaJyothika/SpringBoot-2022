package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Student;
import com.spring.request.CreateStudentRequestModelClass;
import com.spring.request.InQueryFirstName;
import com.spring.request.UpdateStudentRequestModelClass;
import com.spring.response.StudentResponse;
import com.spring.service.StudentService;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

//	@Value("${app.name:Default Demo App}")
//	private String appName;
//	
//	@GetMapping("/get")
//	//@RequestMapping(value = "/get", method = RequestMethod.GET)
//	public StudentResponse getStudent() {
//		
//		StudentResponse studentResponse = new StudentResponse(101,"Krishna","Jyothika");
//		
//		return studentResponse;
//	}

	@Autowired
	StudentService studentService;

	@GetMapping("/getAllStudents")
	public List<StudentResponse> getAllStudents() {

		List<Student> studentList = studentService.getAllStudents();
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@PostMapping("/createStudent")
	public StudentResponse createStudent(
			@Valid @RequestBody CreateStudentRequestModelClass createStudentRequestModelClass) {

		Student student = studentService.createStudent(createStudentRequestModelClass);

		return new StudentResponse(student);

	}

	@PutMapping("/updateStudent")
	public StudentResponse updateStudent(
			@Valid @RequestBody UpdateStudentRequestModelClass updateStudentRequestModelClass) {

		Student student = studentService.updateStudent(updateStudentRequestModelClass);
		return new StudentResponse(student);
	}

	@DeleteMapping("/deleteStudent") // http://localhost:8080/api/student/deleteStudent?id=103
	public String deleteStudentRequesParam(@RequestParam Long id) {

		return studentService.deleteStudent(id);
	}

	@DeleteMapping("/deleteStudent-1/{id}") // http://localhost:8080/api/student/deleteStudent-1/105
	public String deleteStudentPathVariable(@PathVariable Long id) {

		return studentService.deleteStudent(id);
	}

	@GetMapping("/findByFirstName/{firstName}")
	public List<StudentResponse> findByFirstName(@PathVariable String firstName) {

		List<Student> studentList = studentService.findByFirstName(firstName);

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@GetMapping("/findByFirstAndLastName/{firstName}/{lastName}")
	public StudentResponse findByFirstAndLastName(@PathVariable String firstName, @PathVariable String lastName) {

		return new StudentResponse(studentService.findByFirstAndLastName(firstName, lastName));
	}

	@GetMapping("/findByFirstNameOrLastName/{firstName}/{lastName}")
	public List<StudentResponse> findByFirstNameOrLastName(@PathVariable String firstName,
			@PathVariable String lastName) {

		List<Student> studentList = studentService.findByFirstNameOrLastName(firstName, lastName);

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@GetMapping("/getByFirstNameIn")
	public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryFirstName inQueryFirstName) {

		List<Student> studentList = studentService.getByFirstNameIn(inQueryFirstName);

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@GetMapping("/getAllStudentWithPagination")
	public List<StudentResponse> getAllStudentWithPagination(@RequestParam int pageNo, int pageSize) {

		List<Student> studentList = studentService.getAllStudentWithPagination(pageNo, pageSize);

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@GetMapping("/getAllWithSorting")
	public List<StudentResponse> getAllWithSorting() {

		List<Student> studentList = studentService.getAllWithSorting();

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@GetMapping("/firstNameLike/{firstName}")
	public List<StudentResponse> firstNameContains(@PathVariable String firstName) {

		List<Student> studentList = studentService.findByFirstNameContains(firstName);

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}
	
	@GetMapping("/firstNameStartsWith/{firstName}")
	public List<StudentResponse> firstNameStartsWith(@PathVariable String firstName) {

		List<Student> studentList = studentService.firstNameStartsWith(firstName);

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}
	
	@PutMapping("updateFirstNameJPQL/{id}/{firstName}")
	public String updateStudentWithJpql(@PathVariable Long id, @PathVariable String firstName) {
		
		return studentService.updateStudentWithJPQL(id, firstName)+ " Student(s) updated";
	}
	
	@DeleteMapping("deletebyFirstNameJPQL/{firstName}")
	public String deleteStudentByFirstName(@PathVariable String firstName) {
		
		return studentService.deleteStudentByIdJPQL(firstName) + " Student(s) deleted";
	}
	
	
	@GetMapping("/getByCity/{city}")
	public List<StudentResponse> getByCity(@PathVariable String city){
		
		List<Student> studentList = studentService.getByCity(city);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
}
