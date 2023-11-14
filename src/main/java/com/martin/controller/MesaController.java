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
import com.martin.entity.Mesero;
import com.martin.service.MesaService;
import com.martin.util.Constante;

@RestController
@RequestMapping("/url/mesa")
public class MesaController {
	@Autowired
	private MesaService service;
	
	@GetMapping("/listaMesa")
	@ResponseBody
	public ResponseEntity<List<Mesa>> listaMesa() {
		List<Mesa> lista  = null;
		try {
			lista = service.listarTodo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraMesa")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaMesa(@RequestBody Mesa obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			
			Mesa objSalida =  service.insertarMesa(obj);
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
	
	@PutMapping("/actualizarMesa")
	@ResponseBody
	public ResponseEntity<?> actualizaMesero(@RequestBody Mesa obj){
		HashMap<String, String> mensaje = new HashMap<>();
		
		Optional<Mesa> optPersona = service.buscarMesa(obj.getId());
		if (optPersona.isPresent()) {
			Mesa objSalida = service.ActualizaMesa(obj);
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
	
	@DeleteMapping("/eliminaMesa/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaMesa(@PathVariable("id") int idMesa) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaMesa(idMesa);
			salida.put("mensaje", Constante.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constante.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Object> listaPorId(@PathVariable("id") int idMesa) {
	    Optional<Mesa> listaSalida = service.buscarMesa(idMesa);

	    if (listaSalida.isPresent()) {
	        return ResponseEntity.ok(listaSalida.get());
	    } else {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "No se encontró ninguna persona con el ID proporcionado.");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
}
