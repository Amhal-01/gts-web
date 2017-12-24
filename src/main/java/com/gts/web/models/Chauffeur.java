package com.gts.web.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Chauffeur extends Personne {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Boolean isOk;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateEmbauche;
	@OneToOne
	private Voyage voyage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getIsOk() {
		return isOk;
	}
	public void setIsOk(Boolean isOk) {
		this.isOk = isOk;
	}
	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public Voyage getVoyage() {
		return voyage;
	}
	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	
}
