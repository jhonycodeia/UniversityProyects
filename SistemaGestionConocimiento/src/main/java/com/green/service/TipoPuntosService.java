package com.green.service;

import com.green.dto.TipoPuntosDTO;

import com.green.modelo.TipoPuntos;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoPuntosService {
    public List<TipoPuntos> getTipoPuntos() throws Exception;

    /**
         * Save an new TipoPuntos entity
         */
    public void saveTipoPuntos(TipoPuntos entity) throws Exception;

    /**
         * Delete an existing TipoPuntos entity
         *
         */
    public void deleteTipoPuntos(TipoPuntos entity) throws Exception;

    /**
        * Update an existing TipoPuntos entity
        *
        */
    public void updateTipoPuntos(TipoPuntos entity) throws Exception;

    /**
         * Load an existing TipoPuntos entity
         *
         */
    public TipoPuntos getTipoPuntos(Long idTipoPuntos)
        throws Exception;

    public List<TipoPuntos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoPuntos> findPageTipoPuntos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoPuntos() throws Exception;

    public List<TipoPuntosDTO> getDataTipoPuntos() throws Exception;

    public void validateTipoPuntos(TipoPuntos tipoPuntos)
        throws Exception;
}
