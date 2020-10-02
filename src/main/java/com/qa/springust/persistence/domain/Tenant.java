package com.qa.springust.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "tenant")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 120)
	private String firstName;
	
	@NotNull
	@Size(min = 1, max = 120)
	private String lastName;
	
	private Integer age;
	
	private Integer roomNo;
	
	@ManyToOne
	private Property property;
	
	public Tenant(String fName, String lName, Integer age, Integer roomNo, Property property) {
		super();
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
		this.roomNo = roomNo;
		this.property = property;
	}
	
}
