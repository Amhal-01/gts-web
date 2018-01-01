package com.gts.web.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gts.web.models.Utilisateur;
import com.gts.web.repository.UtilisateurR;

@Service("utilisateurService")
public class UtilisateurSI implements UtilisateurS,CRUD<Utilisateur>{
	@Autowired
	private UtilisateurR repo;
	@Override
	public void create(Utilisateur o) {
		repo.save(o);
		
	}

	@Override
	public void update(Utilisateur o) {
		repo.save(o);
		
	}

	@Override
	public void delete(Utilisateur o) {
		repo.delete(o);
		
	}

	@Override
	public Utilisateur getById(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Utilisateur> getAll() {
		return repo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur user = repo.findByEmail(username);
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), Stream.of(user.getRole())
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList()));	
	}

}
