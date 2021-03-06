package com.green.service;

import com.green.dto.PalabrasClaveDTO;

import com.green.modelo.PalabrasClave;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface PalabrasClaveService {
    public List<PalabrasClave> getPalabrasClave() throws Exception;

    /**
         * Save an new PalabrasClave entity
         */
    public void savePalabrasClave(PalabrasClave entity)
        throws Exception;

    /**
         * Delete an existing PalabrasClave entity
         *
         */
    public void deletePalabrasClave(PalabrasClave entity)
        throws Exception;

    /**
        * Update an existing PalabrasClave entity
        *
        */
    public void updatePalabrasClave(PalabrasClave entity)
        throws Exception;

    /**
         * Load an existing PalabrasClave entity
         *
         */
    public PalabrasClave getPalabrasClave(Long idPalabraClave)
        throws Exception;

    public List<PalabrasClave> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PalabrasClave> findPagePalabrasClave(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPalabrasClave() throws Exception;

    public List<PalabrasClaveDTO> getDataPalabrasClave()
        throws Exception;

    public void validatePalabrasClave(PalabrasClave palabrasClave)
        throws Exception;
}
