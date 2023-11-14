package com.martin.service;

import java.util.List;
import java.util.Optional;

import com.martin.entity.Mesa;
import com.martin.entity.Orden;

public interface OrdenService {
	public abstract List<Orden> listarTodo();
	public abstract Orden insertarOrden(Orden obj);
	public abstract Orden ActualizaOrden(Orden obj);
	public abstract void eliminaOrden(int idOrden);
	public abstract Optional<Orden> buscarOrden(int id);
}
