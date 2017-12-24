package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.Chauffeur;
import com.gts.web.repository.ChauffeurR;

@Service("chauffeurService")
public class ChauffeurSI implements CRUD<Chauffeur>{

	@Autowired
	private ChauffeurR repo;
	@Override
	public void create(Chauffeur o) {
		repo.save(o);
		
	}

	@Override
	public void update(Chauffeur o) {
		repo.save(o);
		
	}

	@Override
	public void delete(Chauffeur o) {
		repo.delete(o);
		
	}

	@Override
	public Chauffeur getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Chauffeur> getAll() {
		return repo.findAll();
	}

}
