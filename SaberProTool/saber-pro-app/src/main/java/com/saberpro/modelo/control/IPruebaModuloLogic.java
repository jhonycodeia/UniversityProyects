package com.saberpro.modelo.control;

import com.saberpro.modelo.PruebaModulo;
import com.saberpro.modelo.dto.PruebaModuloDTO;

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
public interface IPruebaModuloLogic {
    public List<PruebaModulo> getPruebaModulo() throws Exception;
    
    public List<PruebaModulo> getPruebaModulo(String tipo) throws Exception;

    /**
         * Save an new PruebaModulo entity
         */
    public void savePruebaModulo(PruebaModulo entity) throws Exception;

    /**
         * Delete an existing PruebaModulo entity
         *
         */
    public void deletePruebaModulo(PruebaModulo entity)
        throws Exception;

    /**
        * Update an existing PruebaModulo entity
        *
        */
    public void updatePruebaModulo(PruebaModulo entity)
        throws Exception;

    /**
         * Load an existing PruebaModulo entity
         *
         */
    public PruebaModulo getPruebaModulo(Long idPruebaModulo)
        throws Exception;

    public List<PruebaModulo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PruebaModulo> findPagePruebaModulo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPruebaModulo() throws Exception;

    public List<PruebaModuloDTO> getDataPruebaModulo()
        throws Exception;
    
    public List<PruebaModuloDTO> getDataPruebaModulo(String tipo)
            throws Exception;

    public void validatePruebaModulo(PruebaModulo pruebaModulo)
        throws Exception;
    
    
}
