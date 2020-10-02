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

import com.qa.springust.dto.TenantDTO;
import com.qa.springust.persistence.domain.Tenant;
import com.qa.springust.service.TenantService;

//localhost:8901/tenant/<whatever-crud-funtion>

@RestController
@CrossOrigin
@RequestMapping("/tenant")
public class TenantController {

	//Re - Representational
	//S - State
	//T - Transfer
	
	private TenantService service;

	@Autowired
	public TenantController(TenantService service) {
		super();
		this.service = service;
	}
	
	
	
	//create
	@PostMapping("/create")
	public ResponseEntity<TenantDTO> create(@RequestBody Tenant tenant){
		return new ResponseEntity<>(this.service.createTenant(tenant), HttpStatus.CREATED);
	}
	
	//readAll
	@GetMapping("/readAll")
	public ResponseEntity<List<TenantDTO>> getAllTenants(){
		return ResponseEntity.ok(this.service.readAllTenants());
	}
	
	//readById
	@GetMapping("/read/{id}")
	public ResponseEntity<TenantDTO> getTenantById(@PathVariable Long id){
		return ResponseEntity.ok(this.service.readTenantById(id));
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<TenantDTO> updateTenantById(@PathVariable Long id, @RequestBody TenantDTO tenantDTO){
		TenantDTO updated = this.service.updateTenantById(tenantDTO, id);
		return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TenantDTO> deleteTenantById(@PathVariable Long id){
		return this.service.deleteTenantById(id)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
