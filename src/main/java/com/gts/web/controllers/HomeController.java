package com.gts.web.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String main() {
		return "public";
	}
	
	@GetMapping("/home")
	public String index() {
		System.out.println(SecurityContextHolder.getContext().getAuthentication());
		return "Home/index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}
	
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
