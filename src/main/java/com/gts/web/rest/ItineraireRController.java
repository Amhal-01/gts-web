package com.gts.web.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gts.web.models.Itineraire;
import com.gts.web.services.ItineraireSI;

@RestController
@RequestMapping("/rest/itineraires")
public class ItineraireRController {
	@Autowired
	ItineraireSI service;

	@GetMapping("/")
	public List<Itineraire> index() {
		return service.getAll();
	}
	
	@GetMapping("/details/{id}")
	public Itineraire details(@PathVariable int id) {
		return service.getById(id);
	}
}
