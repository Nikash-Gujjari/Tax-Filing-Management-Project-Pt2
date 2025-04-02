package com.skillstorm.tax_management_system_api.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.tax_management_system_api.dtos.FormDTO;
import com.skillstorm.tax_management_system_api.models.Form;
import com.skillstorm.tax_management_system_api.repositories.FormRepository;

@Service
public class FormService {

	private FormRepository repo;
	
	public FormService(FormRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Form>> findAll() {
		
		Iterable<Form> forms = repo.findAll();
		
		if (!forms.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(forms);
		else
			return ResponseEntity.status(HttpStatus.OK).body(forms);
		
	}
	
	public ResponseEntity<Form> findById(int id) {
		Optional<Form> forms = repo.findById(id);
		
		if (forms.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(forms.get());
	}
	
	public ResponseEntity<Form> createOne(FormDTO FormDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Form(0, FormDTO.form_name(), FormDTO.form_type(), FormDTO .form(), FormDTO.tax_return())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Form> updateOne(int id, FormDTO FormDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					 			 .body(repo.save(new Form(id, FormDTO.form_name(), FormDTO.form_type(), FormDTO.form(), FormDTO.tax_return())));
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
