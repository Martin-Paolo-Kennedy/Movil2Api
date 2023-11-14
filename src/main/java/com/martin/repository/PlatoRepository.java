package com.martin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martin.entity.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Integer>{
	
}
