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
	
	@GetMapping("/{codigo}")
	public Caja CajaXID(@PathVariable(name="num_referencia") String codigo) {
		
		Caja Caja_xid = new Caja();
		
		Caja_xid = cajaServiceImpl.CajaXID(codigo);
		
		return Caja_xid;
		
	}
	
	@PutMapping("/{codigo}")
	public Caja actualizarCaja(@PathVariable(name="num_referencia")String codigo,@RequestBody Caja caja) {
		
		Caja Caja_seleccionado= new Caja();
		Caja Caja_actualizado= new Caja();
		
		Caja_seleccionado= cajaServiceImpl.CajaXID(codigo);
		
		Caja_seleccionado.setNumReferencia(caja.getNumReferencia());
		Caja_seleccionado.setContenido(caja.getContenido());
		Caja_seleccionado.setValor(caja.getValor());
		Caja_seleccionado.setAlmacen(caja.getAlmacen());

		
		Caja_actualizado = cajaServiceImpl.actualizarCaja(Caja_seleccionado);
		
		System.out.println("El cliente actualizado es: "+ Caja_actualizado);
		
		return Caja_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eleiminarCaja(@PathVariable(name="id")String codigo) {
		cajaServiceImpl.eliminarCaja(codigo);
	}
	
}

