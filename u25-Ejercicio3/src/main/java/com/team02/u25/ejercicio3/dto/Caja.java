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
	private Long numReferencia;
	@Column(name = "contenido")//no hace falta si se llama igual
	private String contenido;
	@Column(name = "valor")//no hace falta si se llama igual
	private int valor;
	
	@ManyToOne
    @JoinColumn(name="id_departamento")
    private Almacen almacen;
	
	public Caja() {
		
	}

	public Caja(Long numReferencia, String contenido, int valor, Almacen almacen) {
		this.numReferencia = numReferencia;
		this.contenido = contenido;
		this.valor = valor;
		this.almacen = almacen;
	}

	public Long getNumReferencia() {
		return numReferencia;
	}

	public void setNumReferencia(Long numReferencia) {
		this.numReferencia = numReferencia;
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
		return "Caja [numReferencia=" + numReferencia + ", contenido=" + contenido + ", valor=" + valor + ", almacen="
				+ almacen + "]";
	}
	
	
}
