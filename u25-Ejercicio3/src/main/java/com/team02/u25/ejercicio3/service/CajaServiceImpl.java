package com.team02.u25.ejercicio3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team02.u25.ejercicio3.dao.ICajaDAO;
import com.team02.u25.ejercicio3.dto.Caja;

@Service
public class CajaServiceImpl implements ICajaService{

	
	@Autowired
	ICajaDAO iCajaDAO;
	
	@Override
	public List<Caja> listarCajas() {
		// TODO Auto-generated method stub
		return iCajaDAO.findAll();
	}

	@Override
	public Caja guardarCaja(Caja caja) {
		// TODO Auto-generated method stub
		return iCajaDAO.save(caja);
	}

	@Override
	public Caja CajaXID(String codigo) {
		// TODO Auto-generated method stub
		return iCajaDAO.findById(codigo).get();
	}

	@Override
	public Caja actualizarCaja(Caja caja) {
		// TODO Auto-generated method stub
		return iCajaDAO.save(caja);
	}

	@Override
	public void eliminarCaja(String codigo) {
		iCajaDAO.deleteById(codigo);		
	}
}
