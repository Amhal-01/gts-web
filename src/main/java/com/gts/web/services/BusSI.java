package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.Bus;
import com.gts.web.repository.BusR;

@Service("busService")
public class BusSI implements CRUD<Bus>{

	@Autowired
	private BusR repo;
	@Override
	public void create(Bus o) {
		repo.save(o);
		
	}

	@Override
	public void update(Bus o) {
		repo.save(o);
		
	}

	@Override
	public void delete(Bus o) {
		repo.delete(o);
		
	}

	@Override
	public Bus getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Bus> getAll() {
		return repo.findAll();
	}

}
