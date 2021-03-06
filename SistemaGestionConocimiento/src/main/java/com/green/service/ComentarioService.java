package com.green.service;

import com.green.dto.ComentarioDTO;

import com.green.modelo.Comentario;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ComentarioService {
    public List<Comentario> getComentario() throws Exception;

    /**
         * Save an new Comentario entity
         */
    public void saveComentario(Comentario entity) throws Exception;

    /**
         * Delete an existing Comentario entity
         *
         */
    public void deleteComentario(Comentario entity) throws Exception;

    /**
        * Update an existing Comentario entity
        *
        */
    public void updateComentario(Comentario entity) throws Exception;

    /**
         * Load an existing Comentario entity
         *
         */
    public Comentario getComentario(Long idComentario)
        throws Exception;

    public List<Comentario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Comentario> findPageComentario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberComentario() throws Exception;

    public List<ComentarioDTO> getDataComentario() throws Exception;

    public void validateComentario(Comentario comentario)
        throws Exception;
}
