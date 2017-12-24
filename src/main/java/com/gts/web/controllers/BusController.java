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

import com.gts.web.models.Bus;
import com.gts.web.services.BusSI;

@Controller
@RequestMapping("/buss")
public class BusController {
	@Autowired
	BusSI service;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Bus o = new Bus();
		m.addAttribute("bus",o);
		return "Bus/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Bus o, BindingResult result) {
		if(result.hasErrors()) {
			return "Bus/input";
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
		m.addAttribute("buss",service.getAll() );
		return "Bus/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Bus o = service.getById(id);
		service.delete(o);
		return "redirect:../liste";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("bus",service.getById(id));
		return "Bus/input";
	}
}
