package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;
import com.saberpro.dataaccess.api.DaoException;
import com.saberpro.modelo.Opcion;
import java.util.List;



/**
* Interface for   OpcionDAO.
*
*/
public interface IOpcionDAO extends Dao<Opcion, Long> {
	
	public List<Opcion> findByGrupo(long grupo)throws DaoException;
	
	public List<Opcion> findByGrupo(long grupo,String activo)throws DaoException;
	
}
