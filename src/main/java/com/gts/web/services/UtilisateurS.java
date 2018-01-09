package com.gts.web.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UtilisateurS extends UserDetailsService{
	UserDetails loadUserByUsername(String email);
}
