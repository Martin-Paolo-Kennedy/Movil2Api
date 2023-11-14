package com.martin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.martin.entity.Mesero;
import com.martin.entity.Plato;
import com.martin.service.MeseroService;
import com.martin.util.Constante;

@RestController
@RequestMapping("/url/mesero")
public class MeseroController {
	@Autowired 
	private MeseroService service;
	
	@GetMapping("/listaMesero")
	@ResponseBody
	public ResponseEntity<List<Mesero>> listaMesero() {
		List<Mesero> lista  = null;
		try {
			lista = service.listarTodo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraMesero")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaMesero(@RequestBody Mesero obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			
			Mesero objSalida =  service.insertarMesero(obj);
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
	
	@PutMapping("/actualizarMesero")
	@ResponseBody
	public ResponseEntity<?> actualizaMesero(@RequestBody Mesero obj){
		HashMap<String, String> mensaje = new HashMap<>();
		
		Optional<Mesero> optPersona = service.buscarMesero(obj.getId());
		if (optPersona.isPresent()) {
			Mesero objSalida = service.ActualizaMesero(obj);
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
	
	@DeleteMapping("/eliminaMesero/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaMesero(@PathVariable("id") int idMesero) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaMesero(idMesero);
			salida.put("mensaje", Constante.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constante.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Object> listaPorId(@PathVariable("id") int idMesero) {
	    Optional<Mesero> listaSalida = service.buscarMesero(idMesero);

	    if (listaSalida.isPresent()) {
	        return ResponseEntity.ok(listaSalida.get());
	    } else {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "No se encontró ninguna persona con el ID proporcionado.");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
}
