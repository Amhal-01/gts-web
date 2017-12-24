package com.gts.web.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Paiement implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate datePaiement;
	private double montant;
	@OneToOne
	private Ecole ecole;
	@OneToOne
	private Tresorier tresorier;
	@OneToOne
	// Si Cheque == null donc c'est espece ;)
	private Cheque cheque;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Ecole getEcole() {
		return ecole;
	}
	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	public Cheque getCheque() {
		return cheque;
	}
	public void setCheque(Cheque cheque) {
		this.cheque = cheque;
	}
	public Tresorier getTresorier() {
		return tresorier;
	}
	public void setTresorier(Tresorier tresorier) {
		this.tresorier = tresorier;
	}
}
