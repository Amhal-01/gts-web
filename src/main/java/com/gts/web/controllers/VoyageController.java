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

import com.gts.web.models.Voyage;
import com.gts.web.services.VoyageSI;

@Controller
@RequestMapping("/voyages")
public class VoyageController {
	@Autowired
	VoyageSI service;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Voyage o = new Voyage();
		m.addAttribute("voyage",o);
		return "Voyage/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Voyage o, BindingResult result) {
		if(result.hasErrors()) {
			return "Voyage/input";
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
		m.addAttribute("voyages",service.getAll() );
		return "Voyage/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Voyage o = service.getById(id);
		service.delete(o);
		return "redirect:../liste";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("voyage",service.getById(id));
		return "Voyage/input";
	}
}
