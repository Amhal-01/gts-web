package com.gts.web.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ecole implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String telephone;
	private String email;
	@OneToOne
	private RespEcole respEcole;
	@OneToOne
	private Itineraire itineraire;

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
	public Itineraire getItineraire() {
		return itineraire;
	}
	public void setItineraire(Itineraire itineraire) {
		this.itineraire = itineraire;
	}
	
}
