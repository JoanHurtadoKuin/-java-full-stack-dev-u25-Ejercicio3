package com.team02.u25.ejercicio3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team02.u25.ejercicio3.dto.Almacen;
import com.team02.u25.ejercicio3.dao.IAlmacenDAO;

@Service
public class AlmacenServiceImpl implements IAlmacenService{
	
	@Autowired
	IAlmacenDAO iAlmacenDAO;
	
	@Override
	public List<Almacen> listarAlmacenes() {
		// TODO Auto-generated method stub
		return iAlmacenDAO.findAll();
	}

	@Override
	public Almacen guardarAlmacen(Almacen Almacen) {
		// TODO Auto-generated method stub
		return iAlmacenDAO.save(Almacen);
	}

	@Override
	public Almacen almacenXID(int codigo) {
		// TODO Auto-generated method stub
		return iAlmacenDAO.findById(codigo).get();
	}

	@Override
	public Almacen actualizarAlmacen(Almacen almacen) {
		// TODO Auto-generated method stub
		return iAlmacenDAO.save(almacen);
	}

	@Override
	public void eliminarAlmacen(int codigo) {
		iAlmacenDAO.deleteById(codigo);		
	}

}
