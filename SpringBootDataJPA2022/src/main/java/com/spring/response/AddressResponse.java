package com.spring.response;

import com.spring.entity.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
	
	private Long studentId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String email;
	
	private Long addressId;
	private String street;
	private String city;
	
	public AddressResponse(Address address) {
		
		this.studentId = address.getStudent().getId();
		this.firstName = address.getStudent().getFirstName();
		this.lastName = address.getStudent().getLastName();
		this.fullName = address.getStudent().getFirstName() + " " +address.getStudent().getLastName();
		this.email = address.getStudent().getEmail();
		
		this.addressId = address.getAddress_id();
		this.street = address.getStreet();
		this.city = address.getCity();
	}
	

}
