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

import com.gts.web.models.Chauffeur;
import com.gts.web.services.ChauffeurSI;

@Controller
@RequestMapping("/chauffeurs")
public class ChauffeurController {
	@Autowired
	ChauffeurSI service;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Chauffeur o = new Chauffeur();
		m.addAttribute("chauffeur",o);
		return "Chauffeur/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Chauffeur o, BindingResult result) {
		if(result.hasErrors()) {
			return "Chauffeur/input";
		}
		if(o.getId() != 0) {
			service.update(o);
		}else {
			service.create(o);
		}
		return "redirect:liste";
	}
	
	@GetMapping("/liste")
	public String index(Model m) {
		m.addAttribute("chauffeurs",service.getAll() );
		return "Chauffeur/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Chauffeur o = service.getById(id);
		service.delete(o);
		return "redirect:../liste";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("chauffeur",service.getById(id));
		return "Chauffeur/input";
	}
}
