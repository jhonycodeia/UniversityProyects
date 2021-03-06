package com.saberpro.modelo.control;

import com.saberpro.modelo.PruebaReal;
import com.saberpro.modelo.dto.PruebaRealDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IPruebaRealLogic {
    public List<PruebaReal> getPruebaReal() throws Exception;
    
    public List<PruebaReal> getPruebaReal(String tipo) throws Exception;

    /**
         * Save an new PruebaReal entity
         */
    public void savePruebaReal(PruebaReal entity) throws Exception;

    /**
         * Delete an existing PruebaReal entity
         *
         */
    public void deletePruebaReal(PruebaReal entity) throws Exception;

    /**
        * Update an existing PruebaReal entity
        *
        */
    public void updatePruebaReal(PruebaReal entity) throws Exception;

    /**
         * Load an existing PruebaReal entity
         *
         */
    public PruebaReal getPruebaReal(Long idPruebaReal)
        throws Exception;

    public List<PruebaReal> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PruebaReal> findPagePruebaReal(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPruebaReal() throws Exception;

    public List<PruebaRealDTO> getDataPruebaReal() throws Exception;
    
    public List<PruebaRealDTO> getDataPruebaReal(String tipo) throws Exception;

    public void validatePruebaReal(PruebaReal pruebaReal)
        throws Exception;
    
    
}
