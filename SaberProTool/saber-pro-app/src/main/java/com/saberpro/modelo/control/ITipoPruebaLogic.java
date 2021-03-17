package com.saberpro.modelo.control;

import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.TipoPrueba;
import com.saberpro.modelo.dto.FacultadDTO;
import com.saberpro.modelo.dto.TipoPruebaDTO;

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
public interface ITipoPruebaLogic {
    public List<TipoPrueba> getTipoPrueba() throws Exception;
    
    public List<TipoPrueba> getTipoPrueba(String tipo) throws Exception;

    /**
         * Save an new TipoPrueba entity
         */
    public void saveTipoPrueba(TipoPrueba entity) throws Exception;

    /**
         * Delete an existing TipoPrueba entity
         *
         */
    public void deleteTipoPrueba(TipoPrueba entity) throws Exception;

    /**
        * Update an existing TipoPrueba entity
        *
        */
    public void updateTipoPrueba(TipoPrueba entity) throws Exception;

    /**
         * Load an existing TipoPrueba entity
         *
         */
    public TipoPrueba getTipoPrueba(Long idTipoPrueba)
        throws Exception;

    public List<TipoPrueba> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoPrueba> findPageTipoPrueba(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoPrueba() throws Exception;

    public List<TipoPruebaDTO> getDataTipoPrueba() throws Exception;
    
    public List<TipoPruebaDTO> getDataTipoPrueba(String tipo) throws Exception;
    
    public TipoPrueba findByNombre(String nombre)throws Exception;
    
    public TipoPruebaDTO findDataByNombre(String nombre)throws Exception;

    public void validateTipoPrueba(TipoPrueba tipoPrueba)
        throws Exception;
    
    
}
