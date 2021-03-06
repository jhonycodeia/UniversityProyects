package com.green.service;

import com.green.dto.NotificacionDTO;

import com.green.modelo.Notificacion;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface NotificacionService {
    public List<Notificacion> getNotificacion() throws Exception;

    /**
         * Save an new Notificacion entity
         */
    public void saveNotificacion(Notificacion entity) throws Exception;

    /**
         * Delete an existing Notificacion entity
         *
         */
    public void deleteNotificacion(Notificacion entity)
        throws Exception;

    /**
        * Update an existing Notificacion entity
        *
        */
    public void updateNotificacion(Notificacion entity)
        throws Exception;

    /**
         * Load an existing Notificacion entity
         *
         */
    public Notificacion getNotificacion(Long idNotificacion)
        throws Exception;

    public List<Notificacion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Notificacion> findPageNotificacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberNotificacion() throws Exception;

    public List<NotificacionDTO> getDataNotificacion()
        throws Exception;

    public void validateNotificacion(Notificacion notificacion)
        throws Exception;
}
