package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.Etudiant;
import com.gts.web.repository.EtudiantR;

@Service("etudiantService")
public class EtudiantSI implements CRUD<Etudiant>{

	@Autowired
	private EtudiantR repo;
	@Override
	public void create(Etudiant o) {
		repo.save(o);
		
	}

	@Override
	public void update(Etudiant o) {
		repo.save(o);
		
	}

	@Override
	public void delete(Etudiant o) {
		repo.delete(o);
		
	}

	@Override
	public Etudiant getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Etudiant> getAll() {
		return repo.findAll();
	}

}
