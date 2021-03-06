package com.saberpro.modelo.control;

import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.TipoPregunta;
import com.saberpro.modelo.dto.FacultadDTO;
import com.saberpro.modelo.dto.TipoPreguntaDTO;

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
public interface ITipoPreguntaLogic {
    public List<TipoPregunta> getTipoPregunta() throws Exception;
    
    public List<TipoPregunta> getTipoPregunta(String tipo) throws Exception;

    /**
         * Save an new TipoPregunta entity
         */
    public void saveTipoPregunta(TipoPregunta entity) throws Exception;

    /**
         * Delete an existing TipoPregunta entity
         *
         */
    public void deleteTipoPregunta(TipoPregunta entity)
        throws Exception;

    /**
        * Update an existing TipoPregunta entity
        *
        */
    public void updateTipoPregunta(TipoPregunta entity)
        throws Exception;

    /**
         * Load an existing TipoPregunta entity
         *
         */
    public TipoPregunta getTipoPregunta(Long idTipoPregunta)
        throws Exception;

    public List<TipoPregunta> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoPregunta> findPageTipoPregunta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoPregunta() throws Exception;

    public List<TipoPreguntaDTO> getDataTipoPregunta()
        throws Exception;
    
    public List<TipoPreguntaDTO> getDataTipoPregunta(String tipo)
            throws Exception;
    
    public TipoPregunta findByNombre(String nombre)throws Exception;
    
    public TipoPreguntaDTO findDataByNombre(String nombre)throws Exception;

    public void validateTipoPregunta(TipoPregunta tipoPregunta)
        throws Exception;
    
    
}
