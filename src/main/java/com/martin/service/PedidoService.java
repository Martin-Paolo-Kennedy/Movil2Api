package com.martin.service;

import java.util.List;
import java.util.Optional;

import com.martin.entity.Mesa;
import com.martin.entity.Pedido;

public interface PedidoService {
	public abstract List<Pedido> listarTodo();
	public abstract Pedido insertarPedido(Pedido obj);
	public abstract Pedido ActualizaPedido(Pedido obj);
	public abstract void eliminaPedido(int idPedido);
	public abstract Optional<Pedido> buscarPedido(int id);
}
