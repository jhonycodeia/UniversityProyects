package com.green.service;

import com.green.dto.RecompensaDTO;

import com.green.modelo.Recompensa;
import com.green.modelo.Usuario;

import java.io.InputStream;
import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface RecompensaService {
    public List<Recompensa> getRecompensa() throws Exception;

    /**
         * Save an new Recompensa entity
         */
    public void saveRecompensa(Recompensa entity) throws Exception;
    public void reclamarRecompensa(Recompensa entity,Usuario usuario)throws Exception;

    /**
         * Delete an existing Recompensa entity
         *
         */
    public void deleteRecompensa(Recompensa entity) throws Exception;

    /**
        * Update an existing Recompensa entity
        *
        */
    public void updateRecompensa(Recompensa entity) throws Exception;

    /**
         * Load an existing Recompensa entity
         *
         */
    public Recompensa getRecompensa(Long idRecompensa)
        throws Exception;

    public List<Recompensa> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Recompensa> findPageRecompensa(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRecompensa() throws Exception;

    public List<RecompensaDTO> getDataRecompensa() throws Exception;

    public void validateRecompensa(Recompensa recompensa)
        throws Exception;
    
    public InputStream generarRecompensa(Long idRecompensa) throws Exception;
}
