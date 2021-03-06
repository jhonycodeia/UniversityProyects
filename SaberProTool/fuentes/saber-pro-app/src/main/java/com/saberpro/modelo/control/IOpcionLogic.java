package com.saberpro.modelo.control;

import com.saberpro.modelo.GrupoOpcion;
import com.saberpro.modelo.Opcion;
import com.saberpro.modelo.dto.GrupoOpcionDTO;
import com.saberpro.modelo.dto.OpcionDTO;

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
public interface IOpcionLogic {
    public List<Opcion> getOpcion() throws Exception;
    
    public List<Opcion> getOpcion(String tipo) throws Exception;

    /**
         * Save an new Opcion entity
         */
    public void saveOpcion(Opcion entity) throws Exception;

    /**
         * Delete an existing Opcion entity
         *
         */
    public void deleteOpcion(Opcion entity) throws Exception;

    /**
        * Update an existing Opcion entity
        *
        */
    public void updateOpcion(Opcion entity) throws Exception;

    /**
         * Load an existing Opcion entity
         *
         */
    public Opcion getOpcion(Long idOpcion) throws Exception;

    public List<Opcion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Opcion> findPageOpcion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberOpcion() throws Exception;

    public List<OpcionDTO> getDataOpcion() throws Exception;
    
    public List<OpcionDTO> getDataOpcion(String tipo) throws Exception;

    public void validateOpcion(Opcion opcion) throws Exception;
    
    public List<Opcion> findByGrupo(long grupo)throws Exception;
    
    public List<OpcionDTO> findByDataGrupo(long grupo)throws Exception;
    
    public List<Opcion> findByGrupo(long grupo,String activo)throws Exception;
    
    public List<OpcionDTO> findByDataGrupo(long grupo,String activo)throws Exception;
}
