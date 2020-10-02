package com.qa.springust.dto;

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
public class TenantDTO {
	
	//D - Data
	//T - Transfer
	//O - Object

	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Integer roomNo;
	
}
