package com.gts.web.models;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public abstract class Personne implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String password;
	private String telephone;
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateNaissance;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateInscription;
	private Boolean isActive;
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
	public LocalDate getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(LocalDate dateInscription) {
		this.dateInscription = dateInscription;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
