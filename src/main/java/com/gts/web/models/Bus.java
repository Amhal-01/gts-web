package com.gts.web.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bus implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String matricule;
	private String marque;
	private int nbPlaces;
	private Boolean isOk;
	@OneToOne
	private Voyage voyage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public int getNbPlaces() {
		return nbPlaces;
	}
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	public Boolean getIsOk() {
		return isOk;
	}
	public void setIsOk(Boolean isOk) {
		this.isOk = isOk;
	}
	public Voyage getVoyage() {
		return voyage;
	}
	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	
}
