package com.martin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.entity.Mesero;
import com.martin.repository.MeseroRepository;

@Service
public class MeseroServiceImp implements MeseroService{
	
	@Autowired
	private MeseroRepository repository;
	
	@Override
	public List<Mesero> listarTodo() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mesero insertarMesero(Mesero obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Mesero ActualizaMesero(Mesero obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void eliminaMesero(int idMesero) {
		// TODO Auto-generated method stub
		repository.deleteById(idMesero);
	}

	@Override
	public Optional<Mesero> buscarMesero(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
