package com.gts.web.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Utilisateur implements Serializable{

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
	private String[] role;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateInscription;
	private Boolean isActive;
	
	public Utilisateur(String nom, String prenom, String password, String telephone, String email,
			LocalDate dateNaissance, LocalDate dateInscription, Boolean isActive) {
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.telephone = telephone;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.dateInscription = dateInscription;
		this.isActive = isActive;
	}
	
	public Utilisateur(String password, String email, String... role) {
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public Utilisateur() {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getRole() {
		return this.role;
	}

	public void setRole(String... role) {
		this.role = role;
	}

}
