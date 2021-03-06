package com.green.service;

import com.green.dto.SubprocesoDTO;

import com.green.modelo.Subproceso;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface SubprocesoService {
    public List<Subproceso> getSubproceso() throws Exception;

    /**
         * Save an new Subproceso entity
         */
    public void saveSubproceso(Subproceso entity) throws Exception;

    /**
         * Delete an existing Subproceso entity
         *
         */
    public void deleteSubproceso(Subproceso entity) throws Exception;

    /**
        * Update an existing Subproceso entity
        *
        */
    public void updateSubproceso(Subproceso entity) throws Exception;

    /**
         * Load an existing Subproceso entity
         *
         */
    public Subproceso getSubproceso(Long idSubproceso)
        throws Exception;

    public List<Subproceso> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Subproceso> findPageSubproceso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSubproceso() throws Exception;

    public List<SubprocesoDTO> getDataSubproceso() throws Exception;

    public void validateSubproceso(Subproceso subproceso)
        throws Exception;
}
