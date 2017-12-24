package com.gts.web.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class RespEcole extends Personne{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	private Ecole ecole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	
}
