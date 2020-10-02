package com.qa.springust.dto;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PropertyDTO {
	
	//D - Data
	//T - Transfer
	//O - Object

	private Long id;
	private String address;
	private String postcode;
	private String type;
	private List<TenantDTO> tenants;
	
}