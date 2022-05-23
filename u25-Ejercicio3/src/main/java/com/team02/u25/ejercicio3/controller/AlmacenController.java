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

import com.team02.u25.ejercicio3.dto.Almacen;
import com.team02.u25.ejercicio3.service.AlmacenServiceImpl;

@RestController
@RequestMapping("/almacen")
public class AlmacenController {
	
	@Autowired
	AlmacenServiceImpl almacenServiceImpl;

	@GetMapping("/")
	public List<Almacen> listarAlmacens(){
		return almacenServiceImpl.listarAlmacenes();
	}
	
	@PostMapping("/")
	public Almacen salvarAlmacen(@RequestBody Almacen Almacen) {
		return almacenServiceImpl.guardarAlmacen(Almacen);
	}
	
	@GetMapping("/{codigo}")
	public Almacen AlmacenXID(@PathVariable(name="codigo") int codigo) {
		
		Almacen Almacen_xid = new Almacen();
		
		Almacen_xid = almacenServiceImpl.almacenXID(codigo);
		
		return Almacen_xid;
		
	}
	
	@PutMapping("/{id}")
	public Almacen actualizarAlmacen(@PathVariable(name="codigo")int codigo,@RequestBody Almacen almacen) {
		
		Almacen almacen_seleccionado= new Almacen();
		Almacen almacen_actualizado= new Almacen();
		
		almacen_seleccionado= almacenServiceImpl.almacenXID(codigo);
		
		almacen_seleccionado.setId(almacen.getId());
		almacen_seleccionado.setLugar(almacen.getLugar());
		almacen_seleccionado.setCapacidad(almacen.getCapacidad());

		
		almacen_actualizado = almacenServiceImpl.actualizarAlmacen(almacen_seleccionado);
		
		System.out.println("El cliente actualizado es: "+ almacen_actualizado);
		
		return almacen_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eleiminarAlmacen(@PathVariable(name="id")int codigo) {
		almacenServiceImpl.eliminarAlmacen(codigo);
	}
	
}
