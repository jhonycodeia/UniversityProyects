package com.green.service;

import com.green.dto.CalificacionDTO;

import com.green.modelo.Calificacion;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface CalificacionService {
    public List<Calificacion> getCalificacion() throws Exception;

    /**
         * Save an new Calificacion entity
         */
    public void saveCalificacion(Calificacion entity) throws Exception;

    /**
         * Delete an existing Calificacion entity
         *
         */
    public void deleteCalificacion(Calificacion entity)
        throws Exception;

    /**
        * Update an existing Calificacion entity
        *
        */
    public void updateCalificacion(Calificacion entity)
        throws Exception;

    /**
         * Load an existing Calificacion entity
         *
         */
    public Calificacion getCalificacion(Long idCalificacion)
        throws Exception;

    public List<Calificacion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Calificacion> findPageCalificacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCalificacion() throws Exception;

    public List<CalificacionDTO> getDataCalificacion()
        throws Exception;

    public void validateCalificacion(Calificacion calificacion)
        throws Exception;
}
