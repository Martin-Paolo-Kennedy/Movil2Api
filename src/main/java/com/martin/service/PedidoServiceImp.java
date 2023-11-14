package com.martin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.entity.Mesa;
import com.martin.entity.Pedido;
import com.martin.repository.PedidoRepository;

@Service
public class PedidoServiceImp implements PedidoService{
	@Autowired
	private PedidoRepository repository;

	@Override
	public List<Pedido> listarTodo() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Pedido insertarPedido(Pedido obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Pedido ActualizaPedido(Pedido obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void eliminaPedido(int idPedido) {
		// TODO Auto-generated method stub
		repository.deleteById(idPedido);
	}

	@Override
	public Optional<Pedido> buscarPedido(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
}
