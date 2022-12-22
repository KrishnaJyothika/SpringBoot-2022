package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Address;
import com.spring.response.AddressResponse;
import com.spring.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;

	@GetMapping("/getByAddressId/{id}")
	public AddressResponse getByAddressId(@PathVariable Long id){
		
		return new AddressResponse(addressService.getByAddressId(id));
	}
}
