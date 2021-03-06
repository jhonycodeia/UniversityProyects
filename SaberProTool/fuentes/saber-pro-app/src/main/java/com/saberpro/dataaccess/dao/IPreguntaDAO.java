package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;

import com.saberpro.modelo.Pregunta;
import com.saberpro.modelo.dto.ResultadosPreguntaDTO;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   PreguntaDAO.
*
*/
public interface IPreguntaDAO extends Dao<Pregunta, Long> {
	public List<Pregunta> findByRandom(long idModulo,long limit);
	public List<Pregunta> findByPruebaProgramaUsuario(long idPruebaProgramaUsuario);
	public List<ResultadosPreguntaDTO> findByTopPregunta(long idModulo);
}
