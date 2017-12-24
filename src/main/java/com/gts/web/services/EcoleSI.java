package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.Ecole;
import com.gts.web.repository.EcoleR;

@Service("ecoleService")
public class EcoleSI implements CRUD<Ecole>{

	@Autowired
	private EcoleR repo;
	@Override
	public void create(Ecole o) {
		repo.save(o);
		
	}

	@Override
	public void update(Ecole o) {
		repo.save(o);
		
	}

	@Override
	public void delete(Ecole o) {
		repo.delete(o);
		
	}

	@Override
	public Ecole getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Ecole> getAll() {
		return repo.findAll();
	}

}
