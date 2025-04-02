package com.skillstorm.tax_management_system_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.tax_management_system_api.dtos.CpaDTO;
import com.skillstorm.tax_management_system_api.models.Cpa;
import com.skillstorm.tax_management_system_api.services.CpaService;

@RestController
@RequestMapping("/cpa")
public class CpaController {
	
	private CpaService service;
	
	public CpaController(CpaService service) {
		this.service = service;
	}
	
	
	//login
	@GetMapping("/login")
	public ResponseEntity<Boolean> attemptLogin(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {
		return service.attemptLogin(username, password);
	}
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Cpa>> findAll(@RequestParam(required = false) String startsWith) {
		return service.findAll();
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Cpa> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Cpa> createOne(@RequestBody CpaDTO dto) {
		return service.createOne(dto);
	}
	
	// find Id by username
	@GetMapping("/username")
	public ResponseEntity<Integer> findUsernameFromId(@RequestParam(required = true) String username) {
		return service.findUsernameFromId(username);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Cpa> updateOne(@PathVariable int id, @RequestBody CpaDTO dto) {
		return service.updateOne(id, dto);
	}
	
	// delete one
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}