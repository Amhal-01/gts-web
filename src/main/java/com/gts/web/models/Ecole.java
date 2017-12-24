package com.gts.web.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ecole implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	@OneToOne
	private Itineraire adresse;
	private String telephone;
	private String email;
	@OneToOne
	private RespEcole respEcole;
	@OneToMany
	private List<Etudiant> etudiants;
	@OneToOne
	private Paiement paiement;
	@OneToOne
	private Itineraire itineraire;
	
	public Paiement getPaiement() {
		return paiement;
	}
	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Itineraire getAdresse() {
		return adresse;
	}
	public void setAdresse(Itineraire adresse) {
		this.adresse = adresse;
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
	public RespEcole getRespEcole() {
		return respEcole;
	}
	public void setRespEcole(RespEcole respEcole) {
		this.respEcole = respEcole;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public Itineraire getItineraire() {
		return itineraire;
	}
	public void setItineraire(Itineraire itineraire) {
		this.itineraire = itineraire;
	}
	
}
