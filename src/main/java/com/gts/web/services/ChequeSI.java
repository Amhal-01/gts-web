package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.Cheque;
import com.gts.web.repository.ChequeR;

@Service("chequeService")
public class ChequeSI implements CRUD<Cheque>{

	@Autowired
	private ChequeR repo;
	@Override
	public void create(Cheque o) {
		repo.save(o);
		
	}

	@Override
	public void update(Cheque o) {
		repo.save(o);

	}

	@Override
	public void delete(Cheque o) {
		repo.delete(o);
		
	}

	@Override
	public Cheque getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Cheque> getAll() {
		return repo.findAll();
	}

}
