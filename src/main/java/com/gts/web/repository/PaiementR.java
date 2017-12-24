package com.gts.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gts.web.models.Paiement;

public interface PaiementR extends JpaRepository<Paiement, Integer>{

}
