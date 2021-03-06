package com.green.service;

import com.green.dto.ProcesoDTO;

import com.green.modelo.Proceso;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ProcesoService {
    public List<Proceso> getProceso() throws Exception;

    /**
         * Save an new Proceso entity
         */
    public void saveProceso(Proceso entity) throws Exception;

    /**
         * Delete an existing Proceso entity
         *
         */
    public void deleteProceso(Proceso entity) throws Exception;

    /**
        * Update an existing Proceso entity
        *
        */
    public void updateProceso(Proceso entity) throws Exception;

    /**
         * Load an existing Proceso entity
         *
         */
    public Proceso getProceso(Long idProceso) throws Exception;

    public List<Proceso> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Proceso> findPageProceso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberProceso() throws Exception;

    public List<ProcesoDTO> getDataProceso() throws Exception;

    public void validateProceso(Proceso proceso) throws Exception;
}
