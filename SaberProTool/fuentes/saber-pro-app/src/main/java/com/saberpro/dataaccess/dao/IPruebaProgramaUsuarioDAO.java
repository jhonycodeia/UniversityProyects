package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.Dao;

import com.saberpro.modelo.PruebaProgramaUsuario;
import com.saberpro.modelo.dto.ResultadosModuloDTO;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   PruebaProgramaUsuarioDAO.
*
*/
public interface IPruebaProgramaUsuarioDAO extends Dao<PruebaProgramaUsuario, Long> {
	
	public List<ResultadosModuloDTO> findResultado(long idProgramaUsuario,long idPruebaProgramaUsuario);
}
