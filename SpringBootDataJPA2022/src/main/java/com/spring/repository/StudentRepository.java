package com.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByFirstName(String firstName);
	
	Student findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameOrLastName(String firstName, String lastName);
	
	List<Student> findByfirstNameIn(List<String> firstNames);
	
	List<Student> findByFirstNameContains(String firstName);
	
	List<Student> findByFirstNameStartsWith(String firstName);
	
	@Query("From Student where firstName = :firstName and lastName = :last")
	Student getByFirstNameAndLastNameJPQL(String firstName, @Param("last") String lastName);
	//If method parameter and variable inside query doesn't matches we can use @Param to map them
	
	@Modifying
	@Transactional
	@Query("Update Student set firstName = :firstName where id = :id")
	Integer updateFirstNameJPQL(Long id, String firstName);
	
	@Modifying
	@Transactional
	@Query("Delete Student where firstName = :first")
	Integer deleteByFirstNameJPQL(@Param("first") String firstName);
	
	
//	select * from student s, address a where s.address_id=a.id and a.city='Tirupati';
//	or
//	select * from student s inner join address a on s.address_id=a.id where a.city='Tirupati';
	List<Student> findByAddressCity(String city);
	
	@Query("From Student where address.city = :city")
	List<Student> findByAddressCityJPQL(String city);
}
