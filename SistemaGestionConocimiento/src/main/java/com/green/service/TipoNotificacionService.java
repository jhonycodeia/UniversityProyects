package com.green.service;

import com.green.dto.TipoNotificacionDTO;

import com.green.modelo.TipoNotificacion;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoNotificacionService {
    public List<TipoNotificacion> getTipoNotificacion()
        throws Exception;

    /**
         * Save an new TipoNotificacion entity
         */
    public void saveTipoNotificacion(TipoNotificacion entity)
        throws Exception;

    /**
         * Delete an existing TipoNotificacion entity
         *
         */
    public void deleteTipoNotificacion(TipoNotificacion entity)
        throws Exception;

    /**
        * Update an existing TipoNotificacion entity
        *
        */
    public void updateTipoNotificacion(TipoNotificacion entity)
        throws Exception;

    /**
         * Load an existing TipoNotificacion entity
         *
         */
    public TipoNotificacion getTipoNotificacion(Long idTipoNotificacion)
        throws Exception;

    public List<TipoNotificacion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoNotificacion> findPageTipoNotificacion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoNotificacion() throws Exception;

    public List<TipoNotificacionDTO> getDataTipoNotificacion()
        throws Exception;

    public void validateTipoNotificacion(TipoNotificacion tipoNotificacion)
        throws Exception;
}
