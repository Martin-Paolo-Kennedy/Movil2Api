package com.martin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.entity.Mesa;
import com.martin.repository.MesaRepository;

@Service
public class MesaServiceImp implements MesaService{
	
	@Autowired
	private MesaRepository repository;
	
	@Override
	public List<Mesa> listarTodo() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mesa insertarMesa(Mesa obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Mesa ActualizaMesa(Mesa obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void eliminaMesa(int idMesa) {
		// TODO Auto-generated method stub
		repository.deleteById(idMesa);
	}

	@Override
	public Optional<Mesa> buscarMesa(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
