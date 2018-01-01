package com.gts.web.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Etudiant implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	private String password;
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateNaissance;
	private Boolean isActive;
	@ManyToOne
	private Ecole ecole;
	@ManyToOne
	private PointDeRamassage pdr;

	public Etudiant() {
	}
	
	public Etudiant(String nom, String prenom, String password, String email, LocalDate dateNaissance,
			Boolean isActive, Ecole ecole) {
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.isActive = isActive;
		this.ecole = ecole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PointDeRamassage getPdr() {
		return pdr;
	}

	public void setPdr(PointDeRamassage pdr) {
		this.pdr = pdr;
	}

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
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
