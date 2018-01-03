package com.gts.web.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gts.web.models.Chauffeur;
import com.gts.web.services.ChauffeurSI;

@RestController
@RequestMapping("/rest/chauffeurs")
public class ChauffeurRController {
	@Autowired
	ChauffeurSI service;

	@GetMapping("/")
	public List<Chauffeur> index() {
		return service.getAll();
	}
	
	@GetMapping("/details/{id}")
	public Chauffeur details(@PathVariable int id) {
		return service.getById(id);
	}
}
