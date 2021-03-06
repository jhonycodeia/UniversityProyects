package com.green.service;

import com.green.dto.UsuarioTrofeoDTO;

import com.green.modelo.UsuarioTrofeo;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface UsuarioTrofeoService {
    public List<UsuarioTrofeo> getUsuarioTrofeo() throws Exception;

    /**
         * Save an new UsuarioTrofeo entity
         */
    public void saveUsuarioTrofeo(UsuarioTrofeo entity)
        throws Exception;

    /**
         * Delete an existing UsuarioTrofeo entity
         *
         */
    public void deleteUsuarioTrofeo(UsuarioTrofeo entity)
        throws Exception;

    /**
        * Update an existing UsuarioTrofeo entity
        *
        */
    public void updateUsuarioTrofeo(UsuarioTrofeo entity)
        throws Exception;

    /**
         * Load an existing UsuarioTrofeo entity
         *
         */
    public UsuarioTrofeo getUsuarioTrofeo(Long idUsuarioTrofeo)
        throws Exception;

    public List<UsuarioTrofeo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<UsuarioTrofeo> findPageUsuarioTrofeo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuarioTrofeo() throws Exception;

    public List<UsuarioTrofeoDTO> getDataUsuarioTrofeo()
        throws Exception;

    public void validateUsuarioTrofeo(UsuarioTrofeo usuarioTrofeo)
        throws Exception;
}
