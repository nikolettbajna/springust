package com.qa.springust.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "property")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String address;
	
	private String postcode;
	
	private String type;
	
	@OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
	private List<Tenant> tenants;
	
	public Property(String address, String postcode, String type) {
		this.address = address;
		this.postcode = postcode;
		this.type = type;
	}
	
}
