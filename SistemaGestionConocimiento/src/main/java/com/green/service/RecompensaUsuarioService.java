package com.green.service;

import com.green.dto.RecompensaUsuarioDTO;

import com.green.modelo.RecompensaUsuario;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface RecompensaUsuarioService {
    public List<RecompensaUsuario> getRecompensaUsuario()
        throws Exception;

    /**
         * Save an new RecompensaUsuario entity
         */
    public void saveRecompensaUsuario(RecompensaUsuario entity)
        throws Exception;

    /**
         * Delete an existing RecompensaUsuario entity
         *
         */
    public void deleteRecompensaUsuario(RecompensaUsuario entity)
        throws Exception;

    /**
        * Update an existing RecompensaUsuario entity
        *
        */
    public void updateRecompensaUsuario(RecompensaUsuario entity)
        throws Exception;

    /**
         * Load an existing RecompensaUsuario entity
         *
         */
    public RecompensaUsuario getRecompensaUsuario(Long idRecompensaUsuario)
        throws Exception;

    public List<RecompensaUsuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<RecompensaUsuario> findPageRecompensaUsuario(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberRecompensaUsuario() throws Exception;

    public List<RecompensaUsuarioDTO> getDataRecompensaUsuario()
        throws Exception;

    public void validateRecompensaUsuario(RecompensaUsuario recompensaUsuario)
        throws Exception;
}
