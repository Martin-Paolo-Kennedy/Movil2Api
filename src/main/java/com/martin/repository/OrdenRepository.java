package com.martin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martin.entity.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Integer>{

}
