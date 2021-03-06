package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;

import com.saberpro.modelo.Facultad;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   FacultadDAO.
*
*/
public interface IFacultadDAO extends Dao<Facultad, Long> {
	
	public Facultad findByNombre(String nombre);
}
