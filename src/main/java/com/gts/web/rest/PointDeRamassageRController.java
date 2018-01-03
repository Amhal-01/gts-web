package com.gts.web.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gts.web.models.PointDeRamassage;
import com.gts.web.services.PointDeRamassageSI;

@RestController
@RequestMapping("/rest/pointDeRamassages")
public class PointDeRamassageRController {
	@Autowired
	PointDeRamassageSI service;

	@GetMapping("/")
	public List<PointDeRamassage> index() {
		return service.getAll();
	}
	
	@GetMapping("/details/{id}")
	public PointDeRamassage details(@PathVariable int id) {
		return service.getById(id);
	}
}
