package com.saberpro.modelo.control;

import com.saberpro.modelo.PruebaProgramaUsuario;
import com.saberpro.modelo.dto.ModeloPruebaDTO;
import com.saberpro.modelo.dto.PruebaProgramaUsuarioDTO;
import com.saberpro.modelo.dto.ResultadosModuloDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IPruebaProgramaUsuarioLogic {
    public List<PruebaProgramaUsuario> getPruebaProgramaUsuario()
        throws Exception;

    public List<PruebaProgramaUsuario> getPruebaProgramaUsuario(String tipo)
            throws Exception;
    /**
         * Save an new PruebaProgramaUsuario entity
         */
    public void savePruebaProgramaUsuario(PruebaProgramaUsuario entity)
        throws Exception;

    /**
         * Delete an existing PruebaProgramaUsuario entity
         *
         */
    public void deletePruebaProgramaUsuario(PruebaProgramaUsuario entity)
        throws Exception;

    /**
        * Update an existing PruebaProgramaUsuario entity
        *
        */
    public void updatePruebaProgramaUsuario(PruebaProgramaUsuario entity)
        throws Exception;

    /**
         * Load an existing PruebaProgramaUsuario entity
         *
         */
    public PruebaProgramaUsuario getPruebaProgramaUsuario(
        Long idPruebaProgramaUsuario) throws Exception;

    public List<PruebaProgramaUsuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PruebaProgramaUsuario> findPagePruebaProgramaUsuario(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPruebaProgramaUsuario()
        throws Exception;

    public List<PruebaProgramaUsuarioDTO> getDataPruebaProgramaUsuario()
        throws Exception;
    
    public List<PruebaProgramaUsuarioDTO> getDataPruebaProgramaUsuario(String tipo)
            throws Exception;

    public void validatePruebaProgramaUsuario(
        PruebaProgramaUsuario pruebaProgramaUsuario) throws Exception;
    
    public List<ResultadosModuloDTO> findResultado(long idProgramaUsuario,long idPruebaProgramaUsuario)throws Exception;

	public ModeloPruebaDTO consultarPruebaProgramaUsuario(Long idPruebaProgramaUsuario) throws Exception;
    
    
}
