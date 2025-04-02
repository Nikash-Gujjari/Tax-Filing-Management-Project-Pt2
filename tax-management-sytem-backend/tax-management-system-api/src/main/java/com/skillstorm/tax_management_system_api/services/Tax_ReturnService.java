package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Tax_ReturnDTO;
import com.skillstorm.tax_management_system_api.models.Tax_Return;
import com.skillstorm.tax_management_system_api.repositories.Tax_ReturnRepository;

@Service
public class Tax_ReturnService {

	private Tax_ReturnRepository repo;
	
	public Tax_ReturnService(Tax_ReturnRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Tax_Return>> findAll() {
		
		Iterable<Tax_Return> tax_returns = repo.findAll();
		
		if (!tax_returns.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(tax_returns);
		else
			return ResponseEntity.status(HttpStatus.OK).body(tax_returns);
		
	}
	
	public ResponseEntity<Tax_Return> findById(int id) {
		Optional<Tax_Return> tax_returns = repo.findById(id);
		
		if (tax_returns.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(tax_returns.get());
	}
	
	public ResponseEntity<Tax_Return> createOne(Tax_ReturnDTO tax_returnDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Tax_Return(0, tax_returnDTO.filing_status(), tax_returnDTO.cpa(), tax_returnDTO.taxpayer(), tax_returnDTO.forms())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Tax_Return> updateOne(int id, Tax_ReturnDTO tax_returnDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Tax_Return(id,tax_returnDTO.filing_status(), tax_returnDTO.cpa(), tax_returnDTO.taxpayer(), tax_returnDTO.forms())));
		else
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	
	public ResponseEntity<Void> deleteById(int id) {
		try {
			repo.deleteById(id); 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	
}
