package com.saberpro.modelo.control;

import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.TipoModulo;
import com.saberpro.modelo.dto.FacultadDTO;
import com.saberpro.modelo.dto.TipoModuloDTO;

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
public interface ITipoModuloLogic {
    public List<TipoModulo> getTipoModulo() throws Exception;
    
    public List<TipoModulo> getTipoModulo(String tipo) throws Exception;

    /**
         * Save an new TipoModulo entity
         */
    public void saveTipoModulo(TipoModulo entity) throws Exception;

    /**
         * Delete an existing TipoModulo entity
         *
         */
    public void deleteTipoModulo(TipoModulo entity) throws Exception;

    /**
        * Update an existing TipoModulo entity
        *
        */
    public void updateTipoModulo(TipoModulo entity) throws Exception;

    /**
         * Load an existing TipoModulo entity
         *
         */
    public TipoModulo getTipoModulo(Long idTipoModulo)
        throws Exception;

    public List<TipoModulo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoModulo> findPageTipoModulo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoModulo() throws Exception;

    public List<TipoModuloDTO> getDataTipoModulo() throws Exception;
    
    public List<TipoModuloDTO> getDataTipoModulo(String tipo) throws Exception;
    
    public TipoModulo findByNombre(String nombre)throws Exception;
    
    public TipoModuloDTO findDataByNombre(String nombre)throws Exception;

    public void validateTipoModulo(TipoModulo tipoModulo)
        throws Exception;
    
    
}
