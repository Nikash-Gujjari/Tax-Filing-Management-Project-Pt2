package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.TaxpayerDTO;
import com.skillstorm.tax_management_system_api.models.Taxpayer;
import com.skillstorm.tax_management_system_api.repositories.TaxpayerRepository;

@Service
public class TaxpayerService {

	private TaxpayerRepository repo;
	
	public TaxpayerService(TaxpayerRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Taxpayer>> findAll() {
		
		Iterable<Taxpayer> taxpayers = repo.findAll();
		
		if (!taxpayers.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(taxpayers);
		else
			return ResponseEntity.status(HttpStatus.OK).body(taxpayers);
		
	}
	
	public ResponseEntity<Taxpayer> findById(int id) {
		Optional<Taxpayer> taxpayers = repo.findById(id);
		
		if (taxpayers.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(taxpayers.get());
	}
	
	public ResponseEntity<Taxpayer> createOne(TaxpayerDTO taxpayerDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Taxpayer(0, taxpayerDTO.first_name(),  taxpayerDTO.middle_name(),  taxpayerDTO.last_name(),
										 taxpayerDTO.social_security_number(),  taxpayerDTO.address(),  taxpayerDTO.date_of_birth(),  taxpayerDTO.bank_account_number(),
										 taxpayerDTO.bank_routing_number(), taxpayerDTO.employment_sector(),  taxpayerDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Taxpayer> updateOne(int id, TaxpayerDTO taxpayerDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Taxpayer(id, taxpayerDTO.first_name(),  taxpayerDTO.middle_name(),  taxpayerDTO.last_name(),
										 taxpayerDTO.social_security_number(),  taxpayerDTO.address(),  taxpayerDTO.date_of_birth(),  taxpayerDTO.bank_account_number(),
										 taxpayerDTO.bank_routing_number(), taxpayerDTO.employment_sector(),  taxpayerDTO.tax_return())));
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
