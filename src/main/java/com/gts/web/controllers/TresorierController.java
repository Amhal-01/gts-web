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

import com.gts.web.models.Tresorier;
import com.gts.web.services.TresorierSI;

@Controller
@RequestMapping("/tresoriers")
public class TresorierController {
	@Autowired
	TresorierSI service;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Tresorier o = new Tresorier();
		m.addAttribute("tresorier",o);
		return "Tresorier/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Tresorier o, BindingResult result) {
		if(result.hasErrors()) {
			return "Tresorier/input";
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
		m.addAttribute("tresoriers",service.getAll() );
		return "Tresorier/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Tresorier o = service.getById(id);
		service.delete(o);
		return "redirect:../liste";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("tresorier",service.getById(id));
		return "Tresorier/input";
	}
}
