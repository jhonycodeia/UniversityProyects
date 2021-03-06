package com.green.service;

import com.green.dto.CapsulaPalabrasClaveDTO;

import com.green.modelo.CapsulaPalabrasClave;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface CapsulaPalabrasClaveService {
    public List<CapsulaPalabrasClave> getCapsulaPalabrasClave()
        throws Exception;

    /**
         * Save an new CapsulaPalabrasClave entity
         */
    public void saveCapsulaPalabrasClave(CapsulaPalabrasClave entity)
        throws Exception;

    /**
         * Delete an existing CapsulaPalabrasClave entity
         *
         */
    public void deleteCapsulaPalabrasClave(CapsulaPalabrasClave entity)
        throws Exception;

    /**
        * Update an existing CapsulaPalabrasClave entity
        *
        */
    public void updateCapsulaPalabrasClave(CapsulaPalabrasClave entity)
        throws Exception;

    /**
         * Load an existing CapsulaPalabrasClave entity
         *
         */
    public CapsulaPalabrasClave getCapsulaPalabrasClave(
        Long idCapsulaPalabraClave) throws Exception;

    public List<CapsulaPalabrasClave> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<CapsulaPalabrasClave> findPageCapsulaPalabrasClave(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberCapsulaPalabrasClave() throws Exception;

    public List<CapsulaPalabrasClaveDTO> getDataCapsulaPalabrasClave()
        throws Exception;

    public void validateCapsulaPalabrasClave(
        CapsulaPalabrasClave capsulaPalabrasClave) throws Exception;
}
