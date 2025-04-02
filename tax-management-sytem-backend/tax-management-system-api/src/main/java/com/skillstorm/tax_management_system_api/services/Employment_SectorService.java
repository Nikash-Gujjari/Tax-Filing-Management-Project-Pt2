package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.Employment_SectorDTO;
import com.skillstorm.tax_management_system_api.models.Employment_Sector;
import com.skillstorm.tax_management_system_api.repositories.Employment_SectorRepository;

@Service
public class Employment_SectorService {

	private Employment_SectorRepository repo;
	
	public Employment_SectorService(Employment_SectorRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Employment_Sector>> findAll() {
		
		Iterable<Employment_Sector> employment_sector = repo.findAll();
		
		if (!employment_sector.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(employment_sector);
		else
			return ResponseEntity.status(HttpStatus.OK).body(employment_sector);
		
	}
	
	public ResponseEntity<Employment_Sector> findById(int id) {
		Optional<Employment_Sector> employment_sector = repo.findById(id);
		
		if (employment_sector.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(employment_sector.get());
	}
	
	public ResponseEntity<Employment_Sector> createOne(Employment_SectorDTO employment_sectorDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Employment_Sector(0, employment_sectorDTO.sector_name(), employment_sectorDTO.taxpayer())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Employment_Sector> updateOne(int id, Employment_SectorDTO employment_sectorDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Employment_Sector(id, employment_sectorDTO.sector_name(), employment_sectorDTO.taxpayer())));
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
