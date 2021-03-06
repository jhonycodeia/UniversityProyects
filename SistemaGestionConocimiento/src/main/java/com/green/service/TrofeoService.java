package com.green.service;

import com.green.dto.TrofeoDTO;

import com.green.modelo.Trofeo;

import java.io.InputStream;
import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TrofeoService {
    public List<Trofeo> getTrofeo() throws Exception;

    /**
         * Save an new Trofeo entity
         */
    public void saveTrofeo(Trofeo entity) throws Exception;

    /**
         * Delete an existing Trofeo entity
         *
         */
    public void deleteTrofeo(Trofeo entity) throws Exception;

    /**
        * Update an existing Trofeo entity
        *
        */
    public void updateTrofeo(Trofeo entity) throws Exception;

    /**
         * Load an existing Trofeo entity
         *
         */
    public Trofeo getTrofeo(Long idTrofeo) throws Exception;

    public List<Trofeo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Trofeo> findPageTrofeo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTrofeo() throws Exception;

    public List<TrofeoDTO> getDataTrofeo() throws Exception;

    public void validateTrofeo(Trofeo trofeo) throws Exception;
    
    public InputStream generarTrofeo(Long idTrofeo) throws Exception;
}
