package com.qa.springust.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springust.dto.PropertyDTO;
import com.qa.springust.exception.PropertyNotFoundException;
import com.qa.springust.persistence.domain.Property;
import com.qa.springust.presistence.repository.PropertyRepository;
import com.qa.springust.utils.SpringustBeanUtils;

@Service
public class PropertyService {

private PropertyRepository repo;
	
	private ModelMapper mapper;

	@Autowired
	public PropertyService(PropertyRepository repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private PropertyDTO mapToDTO(Property property) {
		return this.mapper.map(property, PropertyDTO.class);
	}
	
	private Property mapFromDTO(PropertyDTO propertyDTO) {
		return this.mapper.map(propertyDTO, Property.class);
	}
	
	//create
	public PropertyDTO createProperty(Property property) {
		Property saved = this.repo.save(property);
		return this.mapToDTO(saved);
	}
	
	//read
	public List<PropertyDTO> readAllProperties(){		
		return this.repo.findAll()
				.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}
	
	//readById
	public PropertyDTO readPropertyById(Long id) {
		Property found = this.repo.findById(id).orElseThrow(PropertyNotFoundException::new);
		return this.mapToDTO(found);
	}
	
	//update
	public PropertyDTO updatePropertyById(PropertyDTO propertyDTO,  Long id) {
		Property toUpdate = this.repo.findById(id).orElseThrow(PropertyNotFoundException::new);
		SpringustBeanUtils.mergeObject(propertyDTO, toUpdate);
		return this.mapToDTO(this.repo.save(toUpdate));
	}
	
	//delete
	public boolean deletePropertyById(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
}
