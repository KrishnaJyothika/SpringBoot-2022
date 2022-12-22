package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{

	Address getById(Long id);
}
