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

import com.gts.web.models.Admin;
import com.gts.web.services.AdminSI;

@Controller
@RequestMapping("/admins")
public class AdminController {
	@Autowired
	AdminSI service;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Admin o = new Admin();
		m.addAttribute("admin",o);
		return "Admin/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Admin o, BindingResult result) {
		if(result.hasErrors()) {
			return "Admin/input";
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
		m.addAttribute("admins",service.getAll() );
		return "Admin/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Admin o = service.getById(id);
		service.delete(o);
		return "redirect:../liste";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("admin",service.getById(id));
		return "Admin/input";
	}
}
