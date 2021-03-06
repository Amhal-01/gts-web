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

import com.gts.web.models.Paiement;
import com.gts.web.services.ChequeSI;
import com.gts.web.services.EcoleSI;
import com.gts.web.services.PaiementSI;

@Controller
@RequestMapping("/paiements")
public class PaiementController {
	@Autowired
	EcoleSI ecole;
	@Autowired
	ChequeSI cheque;
	@Autowired
	PaiementSI service;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Paiement o = new Paiement();
		m.addAttribute("paiement",o);
		m.addAttribute("ecoles",ecole.getAll());
		m.addAttribute("cheques",cheque.getAll());
		return "Paiement/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Paiement o, BindingResult result) {
		if(result.hasErrors()) {
			return "Paiement/input";
		}
		if(o.getId() != 0) {
			o.setDatePaiement(service.getById(o.getId()).getDatePaiement());
			service.update(o);
		}else {
			o.setDatePaiement(LocalDate.now());
			service.create(o);
		}
		return "redirect:/paiements/";
	}
	
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("paiements",service.getAll() );
		return "Paiement/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Paiement o = service.getById(id);
		service.delete(o);
		return "redirect:/paiements/";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("paiement",service.getById(id));
		return "Paiement/input";
	}
}
