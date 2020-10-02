package com.qa.springust.presistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springust.persistence.domain.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long>{

	//J - Java
	//P - Persistence
	//A - A Application
	//P - Programming
	//I - Interface
}
