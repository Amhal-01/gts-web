package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.Admin;
import com.gts.web.repository.AdminR;

@Service("adminService")
public class AdminSI implements CRUD<Admin>{

	@Autowired
	private AdminR repo;
	@Override
	public void create(Admin o) {
		repo.save(o);
		
	}

	@Override
	public void update(Admin o) {
		repo.save(o);
		
	}

	@Override
	public void delete(Admin o) {
		repo.delete(o);
		
	}

	@Override
	public Admin getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Admin> getAll() {
		return repo.findAll();
	}

}
