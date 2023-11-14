package com.martin.service;

import java.util.List;
import java.util.Optional;

import com.martin.entity.Mesero;
import com.martin.entity.Plato;

public interface MeseroService {
	public abstract List<Mesero> listarTodo();
	public abstract Mesero insertarMesero(Mesero obj);
	public abstract Mesero ActualizaMesero(Mesero obj);
	public abstract void eliminaMesero(int idMesero);
	public abstract Optional<Mesero> buscarMesero(int id);
}
