package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;
import com.saberpro.modelo.EstadoPrueba;
import com.saberpro.modelo.Modulo;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   ModuloDAO.
*
*/
public interface IModuloDAO extends Dao<Modulo, Long> {
	public Modulo findByNombre(String nombre);
	public List<Modulo> findByPrograma(long idPrograma);	
}
