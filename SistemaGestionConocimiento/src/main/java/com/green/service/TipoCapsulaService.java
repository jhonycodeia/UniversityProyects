package com.green.service;

import com.green.dto.TipoCapsulaDTO;

import com.green.modelo.TipoCapsula;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoCapsulaService {
    public List<TipoCapsula> getTipoCapsula() throws Exception;

    /**
         * Save an new TipoCapsula entity
         */
    public void saveTipoCapsula(TipoCapsula entity) throws Exception;

    /**
         * Delete an existing TipoCapsula entity
         *
         */
    public void deleteTipoCapsula(TipoCapsula entity) throws Exception;

    /**
        * Update an existing TipoCapsula entity
        *
        */
    public void updateTipoCapsula(TipoCapsula entity) throws Exception;

    /**
         * Load an existing TipoCapsula entity
         *
         */
    public TipoCapsula getTipoCapsula(Long idTipoCapsula)
        throws Exception;

    public List<TipoCapsula> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoCapsula> findPageTipoCapsula(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoCapsula() throws Exception;

    public List<TipoCapsulaDTO> getDataTipoCapsula() throws Exception;

    public void validateTipoCapsula(TipoCapsula tipoCapsula)
        throws Exception;
}
