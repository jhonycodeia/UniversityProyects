package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;

import com.saberpro.modelo.RespuestaPruebaProgramaUsuarioPregunta;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   RespuestaPruebaProgramaUsuarioPreguntaDAO.
*
*/
public interface IRespuestaPruebaProgramaUsuarioPreguntaDAO extends Dao<RespuestaPruebaProgramaUsuarioPregunta, Long> {
	
	public List<RespuestaPruebaProgramaUsuarioPregunta> findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuario(long idPruebaProgramaUsuario);

	public List<RespuestaPruebaProgramaUsuarioPregunta> findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuarioPregunta(
			long idPruebaProgramaUsuarioPregunta);
}
