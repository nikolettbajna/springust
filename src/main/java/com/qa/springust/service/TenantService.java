package com.qa.springust.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springust.dto.TenantDTO;
import com.qa.springust.exception.TenantNotFoundException;
import com.qa.springust.persistence.domain.Tenant;
import com.qa.springust.presistence.repository.TenantRepository;
import com.qa.springust.utils.SpringustBeanUtils;

@Service
public class TenantService {
	
	private TenantRepository repo;
	
	private ModelMapper mapper;

	@Autowired
	public TenantService(TenantRepository repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private TenantDTO mapToDTO(Tenant tenant) {
		return this.mapper.map(tenant, TenantDTO.class);
	}
	
	private Tenant mapFromDTO(TenantDTO tenantDTO) {
		return this.mapper.map(tenantDTO, Tenant.class);
	}
	
	//create
	public TenantDTO createTenant(Tenant tenant) {
		Tenant saved = this.repo.save(tenant);
		return this.mapToDTO(saved);
	}
	
	//read
	public List<TenantDTO> readAllTenants(){		
		return this.repo.findAll()
				.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}
	
	public List<TenantDTO> read() {
		List<TenantDTO> dtos = new ArrayList<>();
		for (Tenant tenant : this.repo.findAll()) {
			dtos.add(this.mapToDTO(tenant));
		}
		return dtos;
	}
	
	//readById
	public TenantDTO readTenantById(Long id) {
		Tenant found = this.repo.findById(id).orElseThrow(TenantNotFoundException::new);
		return this.mapToDTO(found);
	}
	
	//update
	public TenantDTO updateTenantById(TenantDTO tenantDTO,  Long id) {
		Tenant toUpdate = this.repo.findById(id).orElseThrow(TenantNotFoundException::new);
		SpringustBeanUtils.mergeObject(tenantDTO, toUpdate);
		return this.mapToDTO(this.repo.save(toUpdate));
	}
	
	//delete
	public boolean deleteTenantById(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	
}
