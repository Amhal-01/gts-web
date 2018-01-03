package com.gts.web.models;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class PointDeRamassage implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	private Itineraire point;
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime horaire;
	@ManyToMany
	private List<Voyage> voyages;
	@OneToMany
	private List<Etudiant> etudiants;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Itineraire getPoint() {
		return point;
	}
	public void setPoint(Itineraire point) {
		this.point = point;
	}
	public LocalTime getHoraire() {
		return horaire;
	}
	public void setHoraire(LocalTime horaire) {
		this.horaire = horaire;
	}
	public List<Voyage> getVoyages() {
		return voyages;
	}
	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
}
