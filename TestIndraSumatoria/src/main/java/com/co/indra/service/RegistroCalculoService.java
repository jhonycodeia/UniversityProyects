package com.co.indra.service;

import com.co.indra.dto.CalculoDTO;
import com.co.indra.dto.RegistroCalculoDTO;
import com.co.indra.model.RegistroCalculo;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface RegistroCalculoService {
    public List<RegistroCalculo> getRegistroCalculo() throws Exception;

    /**
         * Save an new RegistroCalculo entity
         */
    public void saveRegistroCalculo(RegistroCalculo entity)
        throws Exception;
    
    public RegistroCalculo saveRegistroCalculo(CalculoDTO entity)
            throws Exception;

    /**
         * Delete an existing RegistroCalculo entity
         *
         */
    public void deleteRegistroCalculo(RegistroCalculo entity)
        throws Exception;

    /**
        * Update an existing RegistroCalculo entity
        *
        */
    public void updateRegistroCalculo(RegistroCalculo entity)
        throws Exception;

    /**
         * Load an existing RegistroCalculo entity
         *
         */
    public RegistroCalculo getRegistroCalculo(Integer idResultado)
        throws Exception;

    public List<RegistroCalculo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<RegistroCalculo> findPageRegistroCalculo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberRegistroCalculo() throws Exception;

    public List<RegistroCalculoDTO> getDataRegistroCalculo()
        throws Exception;

    public void validateRegistroCalculo(RegistroCalculo registroCalculo)
        throws Exception;
}
