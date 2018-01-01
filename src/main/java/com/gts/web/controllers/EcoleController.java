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

import com.gts.web.models.Ecole;
import com.gts.web.services.EcoleSI;
import com.gts.web.services.ItineraireSI;

@Controller
@RequestMapping("/ecoles")
public class EcoleController {
	@Autowired
	EcoleSI service;
	@Autowired
	ItineraireSI it;
	@GetMapping("/add")
	public String ajouter(Model m) {
		Ecole o = new Ecole();
		m.addAttribute("ecole",o);
		m.addAttribute("itineraires",it.getAll());
		return "Ecole/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Ecole o, BindingResult result) {
		if(result.hasErrors()) {
			return "Ecole/input";
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
		m.addAttribute("ecoles",service.getAll() );
		return "Ecole/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Ecole o = service.getById(id);
		service.delete(o);
		return "redirect:../";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("ecole",service.getById(id));
		return "Ecole/input";
	}
}
