package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;
import com.saberpro.modelo.Programa;




/**
* Interface for   ProgramaDAO.
*
*/
public interface IProgramaDAO extends Dao<Programa, Long> {
	
	public Programa findByNombre(String nombre);
}
