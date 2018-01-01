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

import com.gts.web.models.Cheque;
import com.gts.web.services.BanqueSI;
import com.gts.web.services.ChequeSI;

@Controller
@RequestMapping("/cheques")
public class ChequeController {
	@Autowired
	ChequeSI service;
	@Autowired
	BanqueSI banque;
	
	@GetMapping("/add")
	public String ajouter(Model m) {
		Cheque o = new Cheque();
		m.addAttribute("cheque",o);
		m.addAttribute("banques",banque.getAll());
		return "Cheque/input";
	}
	
	@PostMapping("/add")
	public String ajouter(@ModelAttribute Cheque o, BindingResult result) {
		if(result.hasErrors()) {
			return "Cheque/input";
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
		m.addAttribute("cheques",service.getAll() );
		return "Cheque/index";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimer(@PathVariable int id) {
		Cheque o = service.getById(id);
		service.delete(o);
		return "redirect:../";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable int id,Model m) {
		m.addAttribute("cheque",service.getById(id));
		return "Cheque/input";
	}
}
