package com.gts.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gts.web.models.Utilisateur;

public interface UtilisateurR extends JpaRepository<Utilisateur, Integer>{
	Utilisateur findByEmail(String email);
}
