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

import com.gts.web.models.Banque;
import com.gts.web.services.BanqueSI;

@Controller
@RequestMapping("/banques")
public class BanqueController {
	@Autowired
	BanqueSI service;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Banque o = new Banque();
		m.addAttribute("banque",o);
		return "Banque/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Banque o, BindingResult result) {
		if(result.hasErrors()) {
			return "Banque/input";
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
		m.addAttribute("banques",service.getAll() );
		return "Banque/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Banque o = service.getById(id);
		service.delete(o);
		return "redirect:../";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("banque",service.getById(id));
		return "Banque/input";
	}
}
