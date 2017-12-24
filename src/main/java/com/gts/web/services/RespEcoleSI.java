package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.RespEcole;
import com.gts.web.repository.RespEcoleR;

@Service("respEcoleService")
public class RespEcoleSI implements CRUD<RespEcole>{

	@Autowired
	private RespEcoleR repo;
	@Override
	public void create(RespEcole o) {
		repo.save(o);
		
	}

	@Override
	public void update(RespEcole o) {
		repo.save(o);
		
	}

	@Override
	public void delete(RespEcole o) {
		repo.delete(o);
		
	}

	@Override
	public RespEcole getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<RespEcole> getAll() {
		return repo.findAll();
	}

}
