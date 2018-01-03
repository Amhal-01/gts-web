package com.gts.web.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gts.web.models.Etudiant;
import com.gts.web.services.EtudiantSI;

@RestController
@RequestMapping("/rest/etudiants")
public class EtudiantRController {
	@Autowired
	EtudiantSI service;

	@GetMapping("/")
	public List<Etudiant> index() {
		return service.getAll();
	}
	
	@GetMapping("/details/{id}")
	public Etudiant details(@PathVariable int id) {
		return service.getById(id);
	}
}
