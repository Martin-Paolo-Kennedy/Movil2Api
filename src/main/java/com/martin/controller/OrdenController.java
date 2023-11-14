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

import com.martin.entity.Mesa;
import com.martin.entity.Orden;
import com.martin.service.OrdenService;
import com.martin.util.Constante;

@RestController
@RequestMapping("/url/orden")
public class OrdenController {
	@Autowired
	private OrdenService service;
	
	@GetMapping("/listaOrden")
	@ResponseBody
	public ResponseEntity<List<Orden>> listaOden() {
		List<Orden> lista  = null;
		try {
			lista = service.listarTodo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraOrden")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaOrden(@RequestBody Orden obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			
			Orden objSalida =  service.insertarOrden(obj);
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
	
	@PutMapping("/actualizarOrden")
	@ResponseBody
	public ResponseEntity<?> actualizaOrden(@RequestBody Orden obj){
		HashMap<String, String> mensaje = new HashMap<>();
		
		Optional<Orden> optPersona = service.buscarOrden(obj.getId());
		if (optPersona.isPresent()) {
			Orden objSalida = service.ActualizaOrden(obj);
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
	
	@DeleteMapping("/eliminaOrden/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaOrden(@PathVariable("id") int idOrden) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaOrden(idOrden);
			salida.put("mensaje", Constante.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constante.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Object> listaPorId(@PathVariable("id") int idOrden) {
	    Optional<Orden> listaSalida = service.buscarOrden(idOrden);

	    if (listaSalida.isPresent()) {
	        return ResponseEntity.ok(listaSalida.get());
	    } else {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "No se encontró ninguna persona con el ID proporcionado.");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
}
