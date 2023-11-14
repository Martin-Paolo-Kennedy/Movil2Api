package com.martin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.entity.Plato;
import com.martin.repository.PlatoRepository;

@Service
public class PlatoServiceImp implements PlatoService{
	
	@Autowired
	private PlatoRepository repository;
	
	@Override
	public List<Plato> listarTodo() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	@Override
	public void eliminaPlato(int idPlato) {
		// TODO Auto-generated method stub
		repository.deleteById(idPlato);
	}

	@Override
	public Plato insertarPlato(Plato obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}


	@Override
	public Plato ActualizaPlato(Plato obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}


	@Override
	public Optional<Plato> buscarPlato(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}



}
