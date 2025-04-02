package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Tax_Return;

@Repository
public interface Tax_ReturnRepository extends CrudRepository<Tax_Return, Integer> {
	@Query(value = "SELECT * FROM tax_return", nativeQuery = true)
	public Iterable<Tax_Return> findAll();
}
