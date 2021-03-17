package com.saberpro.modelo.control;

import com.saberpro.modelo.ResultadoReal;
import com.saberpro.modelo.dto.ResultadoRealDTO;

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
public interface IResultadoRealLogic {
    public List<ResultadoReal> getResultadoReal() throws Exception;
    
    public List<ResultadoReal> getResultadoReal(String tipo) throws Exception;

    /**
         * Save an new ResultadoReal entity
         */
    public void saveResultadoReal(ResultadoReal entity)
        throws Exception;

    /**
         * Delete an existing ResultadoReal entity
         *
         */
    public void deleteResultadoReal(ResultadoReal entity)
        throws Exception;

    /**
        * Update an existing ResultadoReal entity
        *
        */
    public void updateResultadoReal(ResultadoReal entity)
        throws Exception;

    /**
         * Load an existing ResultadoReal entity
         *
         */
    public ResultadoReal getResultadoReal(Long idResultadoReal)
        throws Exception;

    public List<ResultadoReal> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ResultadoReal> findPageResultadoReal(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberResultadoReal() throws Exception;

    public List<ResultadoRealDTO> getDataResultadoReal()
        throws Exception;
    
    public List<ResultadoRealDTO> getDataResultadoReal(String tipo)
            throws Exception;

    public void validateResultadoReal(ResultadoReal resultadoReal)
        throws Exception;
 
}
