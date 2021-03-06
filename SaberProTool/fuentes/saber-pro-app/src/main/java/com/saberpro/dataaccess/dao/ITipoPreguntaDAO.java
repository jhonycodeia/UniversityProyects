package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;
import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.TipoPregunta;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   TipoPreguntaDAO.
*
*/
public interface ITipoPreguntaDAO extends Dao<TipoPregunta, Long> {
	
	public TipoPregunta findByNombre(String nombre);
}
