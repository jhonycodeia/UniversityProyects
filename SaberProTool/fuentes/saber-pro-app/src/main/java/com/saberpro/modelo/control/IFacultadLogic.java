package com.saberpro.modelo.control;

import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.dto.FacultadDTO;

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
public interface IFacultadLogic {
    public List<Facultad> getFacultad() throws Exception;
    
    public List<Facultad> getFacultad(String tipo) throws Exception;

    /**
         * Save an new Facultad entity
         */
    public void saveFacultad(Facultad entity) throws Exception;

    /**
         * Delete an existing Facultad entity
         *
         */
    public void deleteFacultad(Facultad entity) throws Exception;

    /**
        * Update an existing Facultad entity
        *
        */
    public void updateFacultad(Facultad entity) throws Exception;

    /**
         * Load an existing Facultad entity
         *
         */
    public Facultad getFacultad(Long idFacultad) throws Exception;

    public List<Facultad> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Facultad> findPageFacultad(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberFacultad() throws Exception;

    public List<FacultadDTO> getDataFacultad() throws Exception;
    
    public List<FacultadDTO> getDataFacultad(String tipo) throws Exception;
    
    public Facultad findByNombre(String nombre)throws Exception;
    
    public FacultadDTO findDataByNombre(String nombre)throws Exception;

    public void validateFacultad(Facultad facultad) throws Exception;
}
