package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.Banque;
import com.gts.web.repository.BanqueR;

@Service("banqueService")
public class BanqueSI implements CRUD<Banque>{

	@Autowired
	private BanqueR repo;
	@Override
	public void create(Banque o) {
		repo.save(o);
		
	}

	@Override
	public void update(Banque o) {
		repo.save(o);
		
	}

	@Override
	public void delete(Banque o) {
		repo.delete(o);
		
	}

	@Override
	public Banque getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Banque> getAll() {
		return repo.findAll();
	}

}
