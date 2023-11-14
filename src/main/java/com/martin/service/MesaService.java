package com.martin.service;

import java.util.List;
import java.util.Optional;

import com.martin.entity.Mesa;
import com.martin.entity.Mesero;

public interface MesaService {
	public abstract List<Mesa> listarTodo();
	public abstract Mesa insertarMesa(Mesa obj);
	public abstract Mesa ActualizaMesa(Mesa obj);
	public abstract void eliminaMesa(int idMesa);
	public abstract Optional<Mesa> buscarMesa(int id);
}
