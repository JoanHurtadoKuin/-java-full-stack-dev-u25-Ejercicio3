package com.team02.u25.ejercicio3.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "almacen")
public class Almacen {

	// Atributos de entidad cliente
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // busca ultimo valor e incrementa desde id final de db
	private int codigo;
	@Column(name = "lugar") // no hace falta si se llama igual
	private String lugar;
	@Column(name = "capacidad") // no hace falta si se llama igual
	private int capacidad;

	@OneToMany
	@JoinColumn(name = "num_referencia")
	private List<Caja> cajas;

	public Almacen() {

	}

	public Almacen(int id, String lugar, int capacidad) {
		this.codigo = id;
		this.lugar = lugar;
		this.capacidad = capacidad;
	}

	public int getId() {
		return codigo;
	}

	public void setId(int id) {
		this.codigo = id;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Caja")
	public List<Caja> getCajas() {
		return cajas;
	}

	public void setCajas(List<Caja> cajas) {
		this.cajas = cajas;
	}

	@Override
	public String toString() {
		return "Almacen [id=" + codigo + ", lugar=" + lugar + ", capacidad=" + capacidad + "]";
	}

}
