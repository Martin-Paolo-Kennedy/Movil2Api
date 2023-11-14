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
import com.martin.entity.Pedido;
import com.martin.service.PedidoService;
import com.martin.util.Constante;

@RestController
@RequestMapping("/url/pedido")
public class PedidoController {
	@Autowired
	private PedidoService service;
	
	@GetMapping("/listaPedido")
	@ResponseBody
	public ResponseEntity<List<Pedido>> listaPedido() {
		List<Pedido> lista  = null;
		try {
			lista = service.listarTodo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraPedido")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaPedido(@RequestBody Pedido obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			
			Pedido objSalida =  service.insertarPedido(obj);
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
	
	@PutMapping("/actualizarPedido")
	@ResponseBody
	public ResponseEntity<?> actualizaPedido(@RequestBody Pedido obj){
		HashMap<String, String> mensaje = new HashMap<>();
		
		Optional<Pedido> optPersona = service.buscarPedido(obj.getId());
		if (optPersona.isPresent()) {
			Pedido objSalida = service.ActualizaPedido(obj);
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
	
	@DeleteMapping("/eliminaPedido/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaPedido(@PathVariable("id") int idPedido) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaPedido(idPedido);
			salida.put("mensaje", Constante.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constante.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Object> listaPorId(@PathVariable("id") int idPedido) {
	    Optional<Pedido> listaSalida = service.buscarPedido(idPedido);

	    if (listaSalida.isPresent()) {
	        return ResponseEntity.ok(listaSalida.get());
	    } else {
	        Map<String, String> response = new HashMap<>();
	        response.put("mensaje", "No se encontró ninguna persona con el ID proporcionado.");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
}
