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

import com.gts.web.models.Etudiant;
import com.gts.web.services.EtudiantSI;

@Controller
@RequestMapping("/etudiants")
public class EtudiantController {
	@Autowired
	EtudiantSI service;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Etudiant o = new Etudiant();
		m.addAttribute("etudiant",o);
		return "Etudiant/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Etudiant o, BindingResult result) {
		if(result.hasErrors()) {
			return "Etudiant/input";
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
		m.addAttribute("etudiants",service.getAll() );
		return "Etudiant/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Etudiant o = service.getById(id);
		service.delete(o);
		return "redirect:../liste";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("etudiant",service.getById(id));
		return "Etudiant/input";
	}
}
