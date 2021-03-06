package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;

import com.saberpro.modelo.EstadoPrueba;
import com.saberpro.modelo.Facultad;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   EstadoPruebaDAO.
*
*/
public interface IEstadoPruebaDAO extends Dao<EstadoPrueba, Long> {
	
	public EstadoPrueba findByNombre(String nombre);
}
