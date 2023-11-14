package com.martin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.entity.Orden;
import com.martin.repository.OrdenRepository;

@Service
public class OrdenServiceImp implements OrdenService{
	@Autowired
	private OrdenRepository repository;

	@Override
	public List<Orden> listarTodo() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Orden insertarOrden(Orden obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Orden ActualizaOrden(Orden obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void eliminaOrden(int idOrden) {
		// TODO Auto-generated method stub
		repository.deleteById(idOrden);
	}

	@Override
	public Optional<Orden> buscarOrden(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
}
