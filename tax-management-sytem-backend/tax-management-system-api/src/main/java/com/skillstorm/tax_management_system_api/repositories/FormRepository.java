package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Form;


@Repository
public interface FormRepository extends CrudRepository<Form, Integer> {
	
	@Query(value = "SELECT * FROM form", nativeQuery = true)
	public Iterable<Form> findAll();
}
