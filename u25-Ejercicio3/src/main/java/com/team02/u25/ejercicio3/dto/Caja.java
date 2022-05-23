package com.team02.u25.ejercicio3.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="caja")//en caso que la tabla sea diferente
public class Caja {

	//Atributos de entidad cliente
	@Id
	private int num_referencia;
	@Column(name = "contenido")//no hace falta si se llama igual
	private String contenido;
	@Column(name = "valor")//no hace falta si se llama igual
	private int valor;
	
	@ManyToOne
    @JoinColumn(name="codigo_almacen")
    private Almacen almacen;
	
	public Caja() {
		
	}

	public Caja(int numReferencia, String contenido, int valor, Almacen almacen) {
		this.num_referencia = numReferencia;
		this.contenido = contenido;
		this.valor = valor;
		this.almacen = almacen;
	}

	public int getNumReferencia() {
		return num_referencia;
	}

	public void setNumReferencia(int numReferencia) {
		this.num_referencia = numReferencia;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	@Override
	public String toString() {
		return "Caja [numReferencia=" + num_referencia + ", contenido=" + contenido + ", valor=" + valor + ", almacen="
				+ almacen + "]";
	}
	
	
}
