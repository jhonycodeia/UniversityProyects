package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;
import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.TipoPrueba;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   TipoPruebaDAO.
*
*/
public interface ITipoPruebaDAO extends Dao<TipoPrueba, Long> {
	
	public TipoPrueba findByNombre(String nombre);
}
