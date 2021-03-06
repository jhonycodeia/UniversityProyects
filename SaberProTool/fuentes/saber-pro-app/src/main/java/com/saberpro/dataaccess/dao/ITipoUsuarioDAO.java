package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;
import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.TipoUsuario;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   TipoUsuarioDAO.
*
*/
public interface ITipoUsuarioDAO extends Dao<TipoUsuario, Long> {
	
	public TipoUsuario findByNombre(String nombre);
}
