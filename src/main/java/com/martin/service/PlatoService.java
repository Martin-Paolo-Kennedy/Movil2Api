package com.martin.service;

import java.util.List;
import java.util.Optional;

import com.martin.entity.Plato;

public interface PlatoService {
	public abstract List<Plato> listarTodo();
	public abstract Plato insertarPlato(Plato obj);
	public abstract Plato ActualizaPlato(Plato obj);
	public abstract void eliminaPlato(int idPlato);
	public abstract Optional<Plato> buscarPlato(int id);
}
