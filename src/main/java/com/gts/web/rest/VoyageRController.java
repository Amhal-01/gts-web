package com.gts.web.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gts.web.models.Voyage;
import com.gts.web.services.VoyageSI;

@RestController
@RequestMapping("/rest/voyages")
public class VoyageRController {
	@Autowired
	VoyageSI service;

	@GetMapping("/")
	public List<Voyage> index() {
		return service.getAll();
	}
	
	@GetMapping("/details/{id}")
	public Voyage details(@PathVariable int id) {
		return service.getById(id);
	}
}
