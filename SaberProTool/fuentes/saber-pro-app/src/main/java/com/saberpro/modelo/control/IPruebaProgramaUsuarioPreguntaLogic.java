package com.saberpro.modelo.control;

import com.saberpro.modelo.PruebaProgramaUsuarioPregunta;
import com.saberpro.modelo.dto.PruebaProgramaUsuarioPreguntaDTO;

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
public interface IPruebaProgramaUsuarioPreguntaLogic {
    public List<PruebaProgramaUsuarioPregunta> getPruebaProgramaUsuarioPregunta()
        throws Exception;
    
    public List<PruebaProgramaUsuarioPregunta> getPruebaProgramaUsuarioPregunta(String tipo)
            throws Exception;

    /**
         * Save an new PruebaProgramaUsuarioPregunta entity
         */
    public void savePruebaProgramaUsuarioPregunta(
        PruebaProgramaUsuarioPregunta entity) throws Exception;

    /**
         * Delete an existing PruebaProgramaUsuarioPregunta entity
         *
         */
    public void deletePruebaProgramaUsuarioPregunta(
        PruebaProgramaUsuarioPregunta entity) throws Exception;

    /**
        * Update an existing PruebaProgramaUsuarioPregunta entity
        *
        */
    public void updatePruebaProgramaUsuarioPregunta(
        PruebaProgramaUsuarioPregunta entity) throws Exception;

    /**
         * Load an existing PruebaProgramaUsuarioPregunta entity
         *
         */
    public PruebaProgramaUsuarioPregunta getPruebaProgramaUsuarioPregunta(
        Long idPruebaProgramaUsuarioPregunta) throws Exception;

    public List<PruebaProgramaUsuarioPregunta> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<PruebaProgramaUsuarioPregunta> findPagePruebaProgramaUsuarioPregunta(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPruebaProgramaUsuarioPregunta()
        throws Exception;

    public List<PruebaProgramaUsuarioPreguntaDTO> getDataPruebaProgramaUsuarioPregunta()
        throws Exception;
    
    public List<PruebaProgramaUsuarioPreguntaDTO> getDataPruebaProgramaUsuarioPregunta(String tipo)
            throws Exception;

    public void validatePruebaProgramaUsuarioPregunta(
        PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta)
        throws Exception;
    
    
}
