package com.gts.web.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Voyage implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	private Chauffeur chauffeur;
	@OneToOne
	private Bus bus;
	@ManyToMany
	private List<PointDeRamassage> pdr;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Chauffeur getChauffeur() {
		return chauffeur;
	}
	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public List<PointDeRamassage> getPdr() {
		return pdr;
	}
	public void setPdr(List<PointDeRamassage> pdr) {
		this.pdr = pdr;
	}

}
