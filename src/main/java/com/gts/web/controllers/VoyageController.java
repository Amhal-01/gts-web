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
import com.gts.web.services.BusSI;
import com.gts.web.services.ChauffeurSI;
import com.gts.web.services.PointDeRamassageSI;
import com.gts.web.services.VoyageSI;

@Controller
@RequestMapping("/voyages")
public class VoyageController {
	@Autowired
	VoyageSI service;
	@Autowired
	PointDeRamassageSI pdrSI;
	@Autowired
	BusSI busSI;
	@Autowired
	ChauffeurSI chauffeurSI;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Voyage o = new Voyage();
		m.addAttribute("voyage",o);
		m.addAttribute("buss",busSI.getAll());
		m.addAttribute("chauffeurs",chauffeurSI.getAll());
		m.addAttribute("pdrs",pdrSI.getAll());
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
		return "redirect:";
	}
	
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("voyages",service.getAll() );
		return "Voyage/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Voyage o = service.getById(id);
		service.delete(o);
		return "redirect:../";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("voyage",service.getById(id));
		return "Voyage/input";
	}
}
