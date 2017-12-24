package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.Paiement;
import com.gts.web.repository.PaiementR;

@Service("paiementService")
public class PaiementSI implements CRUD<Paiement>{

	@Autowired
	private PaiementR repo;
	@Override
	public void create(Paiement o) {
		repo.save(o);
		
	}

	@Override
	public void update(Paiement o) {
		repo.save(o);
		
	}

	@Override
	public void delete(Paiement o) {
		repo.delete(o);
		
	}

	@Override
	public Paiement getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Paiement> getAll() {
		return repo.findAll();
	}

}
