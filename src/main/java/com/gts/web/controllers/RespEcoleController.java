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

import com.gts.web.models.RespEcole;
import com.gts.web.services.EcoleSI;
import com.gts.web.services.RespEcoleSI;

@Controller
@RequestMapping("/respEcoles")
public class RespEcoleController {
	@Autowired
	RespEcoleSI service;
	@Autowired
	EcoleSI ecoleSI;
	@GetMapping("/add")
	public String ajouter(Model m) {
		RespEcole o = new RespEcole();
		m.addAttribute("respEcole",o);
		m.addAttribute("ecoles",ecoleSI.getAll());
		return "RespEcole/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute RespEcole o, BindingResult result) {
		if(result.hasErrors()) {
			return "RespEcole/input";
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
		m.addAttribute("respEcoles",service.getAll() );
		return "RespEcole/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		RespEcole o = service.getById(id);
		service.delete(o);
		return "redirect:../";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("respEcole",service.getById(id));
		return "RespEcole/input";
	}
}
