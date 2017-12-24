package com.gts.web.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tresorier extends Personne {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	private Paiement paiement;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Paiement getPaiement() {
		return paiement;
	}
	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
}
