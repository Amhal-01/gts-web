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

import com.gts.web.models.PointDeRamassage;
import com.gts.web.services.ItineraireSI;
import com.gts.web.services.PointDeRamassageSI;

@Controller
@RequestMapping("/pointDeRamassages")
public class PointDeRamassageController {
	@Autowired
	PointDeRamassageSI service;
	@Autowired
	ItineraireSI it;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		PointDeRamassage o = new PointDeRamassage();
		m.addAttribute("pointDeRamassage",o);
		m.addAttribute("points",it.getAll());
		return "PointDeRamassage/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute PointDeRamassage o, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.getFieldValue("horaire"));
			return "PointDeRamassage/input";
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
		m.addAttribute("pointDeRamassages",service.getAll() );
		return "PointDeRamassage/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		PointDeRamassage o = service.getById(id);
		service.delete(o);
		return "redirect:../";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("pointDeRamassage",service.getById(id));
		return "PointDeRamassage/input";
	}
}
