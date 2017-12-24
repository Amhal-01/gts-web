package com.gts.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gts.web.models.Itineraire;
import com.gts.web.repository.ItineraireR;

@Service("itineraireService")
public class ItineraireSI implements CRUD<Itineraire>{

	@Autowired
	private ItineraireR repo;
	@Override
	public void create(Itineraire o) {
		repo.save(o);
		
	}

	@Override
	public void update(Itineraire o) {
		repo.save(o);
		
	}

	@Override
	public void delete(Itineraire o) {
		repo.delete(o);
		
	}

	@Override
	public Itineraire getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Itineraire> getAll() {
		return repo.findAll();
	}

}
