package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;
import com.saberpro.dataaccess.api.DaoException;
import com.saberpro.modelo.GrupoOpcion;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   GrupoOpcionDAO.
*
*/
public interface IGrupoOpcionDAO extends Dao<GrupoOpcion, Long> {
	
	public List<GrupoOpcion> findByTipoUsuario(long tipoUsuario,String activo)throws DaoException;
	
	public List<GrupoOpcion> findByTipoUsuario(long tipoUsuario)throws DaoException;
}
