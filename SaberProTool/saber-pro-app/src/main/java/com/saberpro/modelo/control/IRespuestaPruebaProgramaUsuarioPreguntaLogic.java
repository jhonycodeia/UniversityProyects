package com.saberpro.modelo.control;

import com.saberpro.modelo.RespuestaPruebaProgramaUsuarioPregunta;
import com.saberpro.modelo.dto.RespuestaPruebaProgramaUsuarioPreguntaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
public interface IRespuestaPruebaProgramaUsuarioPreguntaLogic {
	public List<RespuestaPruebaProgramaUsuarioPregunta> getRespuestaPruebaProgramaUsuarioPregunta() throws Exception;

	public List<RespuestaPruebaProgramaUsuarioPregunta> getRespuestaPruebaProgramaUsuarioPregunta(String tipo)
			throws Exception;

	/**
	 * Save an new RespuestaPruebaProgramaUsuarioPregunta entity
	 */
	public void saveRespuestaPruebaProgramaUsuarioPregunta(RespuestaPruebaProgramaUsuarioPregunta entity)
			throws Exception;

	/**
	 * Delete an existing RespuestaPruebaProgramaUsuarioPregunta entity
	 *
	 */
	public void deleteRespuestaPruebaProgramaUsuarioPregunta(RespuestaPruebaProgramaUsuarioPregunta entity)
			throws Exception;

	/**
	 * Update an existing RespuestaPruebaProgramaUsuarioPregunta entity
	 *
	 */
	public void updateRespuestaPruebaProgramaUsuarioPregunta(RespuestaPruebaProgramaUsuarioPregunta entity)
			throws Exception;

	/**
	 * Load an existing RespuestaPruebaProgramaUsuarioPregunta entity
	 *
	 */
	public RespuestaPruebaProgramaUsuarioPregunta getRespuestaPruebaProgramaUsuarioPregunta(
			Long idRespuestaPruebaProgramaUsuarioPregunta) throws Exception;

	public List<RespuestaPruebaProgramaUsuarioPregunta> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RespuestaPruebaProgramaUsuarioPregunta> findPageRespuestaPruebaProgramaUsuarioPregunta(
			String sortColumnName, boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberRespuestaPruebaProgramaUsuarioPregunta() throws Exception;

	public List<RespuestaPruebaProgramaUsuarioPreguntaDTO> getDataRespuestaPruebaProgramaUsuarioPregunta()
			throws Exception;

	public List<RespuestaPruebaProgramaUsuarioPreguntaDTO> getDataRespuestaPruebaProgramaUsuarioPregunta(String tipo)
			throws Exception;

	public void validateRespuestaPruebaProgramaUsuarioPregunta(
			RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPregunta) throws Exception;

	public List<RespuestaPruebaProgramaUsuarioPregunta> findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuario(
			long idPruebaProgramaUsuario) throws Exception;

	public List<RespuestaPruebaProgramaUsuarioPregunta> findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuarioPregunta(
			long idPruebaProgramaUsuarioPregunta) throws Exception;

	public void guardarRespuestaAPregunta(Long idPruebaProgramaUsuarioPregunta, Long idRespuesta) throws Exception;

}
