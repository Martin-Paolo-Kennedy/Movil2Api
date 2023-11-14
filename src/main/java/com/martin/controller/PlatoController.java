package com.martin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.martin.entity.Plato;
import com.martin.service.PlatoService;
import com.martin.util.Constante;

@RestController
@RequestMapping("/url/plato")
public class PlatoController {
	@Autowired
	private PlatoService service;
	
	
	
	
	
	@GetMapping("/listaPlato")
	@ResponseBody
	public ResponseEntity<List<Plato>> listaPlato() {
		List<Plato> lista  = null;
		try {
			lista = service.listarTodo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraPlato")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaPlato(@RequestBody Plato obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			
			Plato objSalida =  service.insertarPlato(obj);
			if (objSalida == null) {
				salida.put("mensaje", Constante.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constante.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constante.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizarPlato")
	@ResponseBody
	public ResponseEntity<?> actualizaPlato(@RequestBody Plato obj){
		HashMap<String, String> mensaje = new HashMap<>();
		
		Optional<Plato> optPersona = service.buscarPlato(obj.getId());
		if (optPersona.isPresent()) {
			Plato objSalida = service.ActualizaPlato(obj);
			if (objSalida == null) {
				mensaje.put("mensaje", "Error en el registro");
			}else {
				mensaje.put("mensaje", "Se ha actualizado el Alumno de ID " + objSalida.getId());
			}
		}else {
			mensaje.put("mensaje", "No existe alumno de ID " + obj.getId());
		}
		return ResponseEntity.ok(mensaje);
	}
	
	@DeleteMapping("/eliminaPlato/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaAlumno(@PathVariable("id") int idPlato) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaPlato(idPlato);
			salida.put("mensaje", Constante.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constante.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Object> listaPorId(@PathVariable("id") int idPlato) {
	    Optional<Plato> listaSalida = service.buscarPlato(idPlato);

	    if (listaSalida.isPresent()) {
	        return ResponseEntity.ok(listaSalida.get());
	    } else {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "No se encontró ninguna persona con el ID proporcionado.");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
}
