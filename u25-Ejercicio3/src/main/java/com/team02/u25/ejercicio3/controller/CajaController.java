package com.team02.u25.ejercicio3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team02.u25.ejercicio3.dto.Caja;
import com.team02.u25.ejercicio3.service.CajaServiceImpl;

@RestController
@RequestMapping("/caja")
public class CajaController {
	
	@Autowired
	CajaServiceImpl cajaServiceImpl;

	@GetMapping("/")
	public List<Caja> listarCajas(){
		return cajaServiceImpl.listarCajas();
	}
	
	@PostMapping("/")
	public Caja salvarCaja(@RequestBody Caja caja) {
		return cajaServiceImpl.guardarCaja(caja);
	}
	
	@GetMapping("/{id}")
	public Caja CajaXID(@PathVariable(name="id") Long id) {
		
		Caja Caja_xid = new Caja();
		
		Caja_xid = cajaServiceImpl.CajaXID(id);
		
		return Caja_xid;
		
	}
	
	@PutMapping("/{id}")
	public Caja actualizarCaja(@PathVariable(name="id")Long id,@RequestBody Caja caja) {
		
		Caja Caja_seleccionado= new Caja();
		Caja Caja_actualizado= new Caja();
		
		Caja_seleccionado= cajaServiceImpl.CajaXID(id);
		
		Caja_seleccionado.setNumReferencia(caja.getNumReferencia());
		Caja_seleccionado.setContenido(caja.getContenido());
		Caja_seleccionado.setValor(caja.getValor());
		Caja_seleccionado.setAlmacen(caja.getAlmacen());

		
		Caja_actualizado = cajaServiceImpl.actualizarCaja(Caja_seleccionado);
		
		System.out.println("El cliente actualizado es: "+ Caja_actualizado);
		
		return Caja_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eleiminarCaja(@PathVariable(name="id")Long id) {
		cajaServiceImpl.eliminarCaja(id);
	}
	
}

