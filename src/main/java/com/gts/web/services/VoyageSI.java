package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.Voyage;
import com.gts.web.repository.VoyageR;

@Service("voyageService")
public class VoyageSI implements CRUD<Voyage>{

	@Autowired
	private VoyageR repo;
	@Override
	public void create(Voyage o) {
		repo.save(o);
		
	}

	@Override
	public void update(Voyage o) {
		repo.save(o);
		
	}

	@Override
	public void delete(Voyage o) {
		repo.delete(o);
		
	}

	@Override
	public Voyage getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Voyage> getAll() {
		return repo.findAll();
	}

}
