package com.green.service;

import com.green.dto.PuntosDTO;

import com.green.modelo.Puntos;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface PuntosService {
    public List<Puntos> getPuntos() throws Exception;

    /**
         * Save an new Puntos entity
         */
    public void savePuntos(Puntos entity) throws Exception;

    /**
         * Delete an existing Puntos entity
         *
         */
    public void deletePuntos(Puntos entity) throws Exception;

    /**
        * Update an existing Puntos entity
        *
        */
    public void updatePuntos(Puntos entity) throws Exception;

    /**
         * Load an existing Puntos entity
         *
         */
    public Puntos getPuntos(Long idPuntos) throws Exception;

    public List<Puntos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Puntos> findPagePuntos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPuntos() throws Exception;

    public List<PuntosDTO> getDataPuntos() throws Exception;

    public void validatePuntos(Puntos puntos) throws Exception;
}
