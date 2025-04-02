package com.skillstorm.tax_management_system_api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.tax_management_system_api.models.Cpa;

@Repository
public interface CpaRepository extends CrudRepository<Cpa, Integer> {

	@Query(value = "SELECT * FROM cpa WHERE username = ?1 AND  password = ?2", nativeQuery = true)
	public Iterable<Cpa> attemptLogin(String username, String password);
	
	@Query(value = "SELECT * FROM cpa", nativeQuery = true)
	public Iterable<Cpa> findAll();
	
	@Query(value = "SELECT * FROM cpa WHERE username = ?1", nativeQuery=true) 
	public Optional<Cpa> findUsernameFromId(String username);
}
