package com.qa.springust.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springust.dto.PropertyDTO;
import com.qa.springust.persistence.domain.Property;
import com.qa.springust.service.PropertyService;

//localhost:8901/property/<whatever-crud-funtion>

@RestController
@CrossOrigin
@RequestMapping("/property")
public class PropertyController {

	//Re - Representational
	//S - State
	//T - Transfer
	
	private PropertyService service;

	@Autowired
	public PropertyController(PropertyService service) {
		super();
		this.service = service;
	}
	
	
	
	//create
	@PostMapping("/create")
	public ResponseEntity<PropertyDTO> create(@RequestBody Property property){
		return new ResponseEntity<>(this.service.createProperty(property), HttpStatus.CREATED);
	}
	
	//readAll
	@GetMapping("/readAll")
	public ResponseEntity<List<PropertyDTO>> getAllProperties(){
		return ResponseEntity.ok(this.service.readAllProperties());
	}
	
	//readById
	@GetMapping("/read/{id}")
	public ResponseEntity<PropertyDTO> getPropertyById(@PathVariable Long id){
		return ResponseEntity.ok(this.service.readPropertyById(id));
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<PropertyDTO> updatePropertyById(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO){
		PropertyDTO updated = this.service.updatePropertyById(propertyDTO, id);
		return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PropertyDTO> deletePropertyById(@PathVariable Long id){
		return this.service.deletePropertyById(id)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
