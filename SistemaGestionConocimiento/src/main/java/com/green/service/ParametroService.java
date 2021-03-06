package com.green.service;

import com.green.dto.ParametroDTO;

import com.green.modelo.Parametro;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ParametroService {
    public List<Parametro> getParametro() throws Exception;

    /**
         * Save an new Parametro entity
         */
    public void saveParametro(Parametro entity) throws Exception;

    /**
         * Delete an existing Parametro entity
         *
         */
    public void deleteParametro(Parametro entity) throws Exception;

    /**
        * Update an existing Parametro entity
        *
        */
    public void updateParametro(Parametro entity) throws Exception;

    /**
         * Load an existing Parametro entity
         *
         */
    public Parametro getParametro(Long idParametro) throws Exception;

    public List<Parametro> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Parametro> findPageParametro(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberParametro() throws Exception;

    public List<ParametroDTO> getDataParametro() throws Exception;

    public void validateParametro(Parametro parametro)
        throws Exception;
}
