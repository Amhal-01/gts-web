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
import com.gts.web.services.EcoleSI;
import com.gts.web.services.EtudiantSI;
import com.gts.web.services.PointDeRamassageSI;

@Controller
@RequestMapping("/etudiants")
public class EtudiantController {
	@Autowired
	EtudiantSI service;
	@Autowired
	EcoleSI ecoleSI;
	@Autowired
	PointDeRamassageSI pointDeRamassageSI;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Etudiant o = new Etudiant();
		m.addAttribute("etudiant",o);
		m.addAttribute("ecoles",ecoleSI.getAll());
		m.addAttribute("pdrs",pointDeRamassageSI.getAll());
		return "Etudiant/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Etudiant o, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.getFieldError());
			return "Etudiant/input";
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
		m.addAttribute("etudiants",service.getAll() );
		return "Etudiant/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Etudiant o = service.getById(id);
		service.delete(o);
		return "redirect:../";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("etudiant",service.getById(id));
		return "Etudiant/input";
	}
}
