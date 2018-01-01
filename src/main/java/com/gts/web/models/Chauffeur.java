package com.gts.web.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Chauffeur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	private String password;
	private String telephone;
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateNaissance;
	private Boolean isActive;
	private Boolean isOk;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateEmbauche;
	
	public Chauffeur() {
	}
	
	public Chauffeur(String nom, String prenom, String password, String telephone, String email,
			LocalDate dateNaissance, Boolean isActive, Boolean isOk, LocalDate dateEmbauche) {
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.isActive = isActive;
		this.isOk = isOk;
		this.dateEmbauche = dateEmbauche;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getIsOk() {
		return isOk;
	}
	public void setIsOk(Boolean isOk) {
		this.isOk = isOk;
	}
	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
