package com.demo.company.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

	public static final String FIELD_ADDRESS_NAME = "addressName";
	public static final String FIELD_ADDR = "address";
	public static final String FIELD_CITY = "city";

	@Field(value = Address.FIELD_ADDRESS_NAME)
	private String addressName;

	@Field(value = Address.FIELD_ADDR)
	private String address;

	@Field(value = Address.FIELD_CITY)
	private String city;

}
