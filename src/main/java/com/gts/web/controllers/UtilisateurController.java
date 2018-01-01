package com.gts.web.controllers;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gts.web.models.Utilisateur;
import com.gts.web.services.UtilisateurSI;

@Controller
@RequestMapping("/utilisateurs")
public class UtilisateurController {
	@Autowired
	UtilisateurSI service;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Utilisateur o = new Utilisateur();
		m.addAttribute("utilisateur",o);
		return "Utilisateur/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Utilisateur o, BindingResult result) {
		if(result.hasErrors()) {
			return "Utilisateur/input";
		}
		if(o.getId() != 0) {
			o.setDateInscription(service.getById(o.getId()).getDateInscription());
			service.update(o);
		}else {
			o.setDateInscription(LocalDate.now());
			service.create(o);
		}
		return "redirect:";
	}
	
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("utilisateurs",service.getAll() );
		System.out.println(service.getById(1).getRole()[0]);
		return "Utilisateur/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Utilisateur o = service.getById(id);
		service.delete(o);
		return "redirect:../";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("utilisateur",service.getById(id));
		return "Utilisateur/input";
	}
}
