package com.skillstorm.tax_management_system_api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Taxpayer;

@Repository
public interface TaxpayerRepository extends CrudRepository<Taxpayer, Integer> {

	@Query(value = "SELECT * FROM taxpayer", nativeQuery = true)
	public Iterable<Taxpayer> findAll();
}
