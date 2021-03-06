package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;
import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.TipoModulo;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   TipoModuloDAO.
*
*/
public interface ITipoModuloDAO extends Dao<TipoModulo, Long> {
	
	public TipoModulo findByNombre(String nombre);
}
