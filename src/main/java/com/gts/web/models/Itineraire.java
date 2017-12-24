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
public class Itineraire implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double latitude;
	private double longitude;
	@OneToOne
	private Ecole ecole;
	@OneToOne
	private PointDeRamassage pdr;
	@ManyToMany
	private List<Voyage> voyage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Ecole getEcole() {
		return ecole;
	}
	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	public PointDeRamassage getPdr() {
		return pdr;
	}
	public void setPdr(PointDeRamassage pdr) {
		this.pdr = pdr;
	}
	public List<Voyage> getVoyage() {
		return voyage;
	}
	public void setVoyage(List<Voyage> voyage) {
		this.voyage = voyage;
	}
	
}
