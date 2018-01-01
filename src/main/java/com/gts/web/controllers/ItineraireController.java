package com.gts.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gts.web.models.Itineraire;
import com.gts.web.services.ItineraireSI;

@Controller
@RequestMapping("/itineraires")
public class ItineraireController {
	@Autowired
	ItineraireSI service;
	Itineraire it = new Itineraire();
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Itineraire o = new Itineraire();
		m.addAttribute("itineraire",o);
		return "Itineraire/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Itineraire o, BindingResult result) {
		if(result.hasErrors()) {
			return "Itineraire/input";
		}
		if(o.getId() != 0) {
			service.update(o);
		}else {
			service.create(o);
		}
		return "redirect:";
	}
	
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("itineraires",service.getAll() );
		return "Itineraire/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Itineraire o = service.getById(id);
		service.delete(o);
		return "redirect:../";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("itineraire",service.getById(id));
		return "Itineraire/input";
	}
}
