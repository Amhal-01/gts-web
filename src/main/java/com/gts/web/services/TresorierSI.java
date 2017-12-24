package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.Tresorier;
import com.gts.web.repository.TresorierR;

@Service("tresorierService")
public class TresorierSI implements CRUD<Tresorier>{

	@Autowired
	private TresorierR repo;
	@Override
	public void create(Tresorier o) {
		repo.save(o);
		
	}

	@Override
	public void update(Tresorier o) {
		repo.save(o);
		
	}

	@Override
	public void delete(Tresorier o) {
		repo.delete(o);
		
	}

	@Override
	public Tresorier getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Tresorier> getAll() {
		return repo.findAll();
	}

}
