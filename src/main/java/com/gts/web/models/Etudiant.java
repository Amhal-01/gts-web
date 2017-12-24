package com.gts.web.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Etudiant extends Personne {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Ecole ecole;
	private String adresse;
	@ManyToOne
	private PointDeRamassage pdr;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
