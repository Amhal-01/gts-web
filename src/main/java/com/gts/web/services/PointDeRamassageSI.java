package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.PointDeRamassage;
import com.gts.web.repository.PointDeRamassageR;

@Service("pointDeRamassageService")
public class PointDeRamassageSI implements CRUD<PointDeRamassage>{

	@Autowired
	private PointDeRamassageR repo;
	@Override
	public void create(PointDeRamassage o) {
		repo.save(o);
		
	}

	@Override
	public void update(PointDeRamassage o) {
		repo.save(o);
		
	}

	@Override
	public void delete(PointDeRamassage o) {
		repo.delete(o);
		
	}

	@Override
	public PointDeRamassage getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<PointDeRamassage> getAll() {
		return repo.findAll();
	}

}
