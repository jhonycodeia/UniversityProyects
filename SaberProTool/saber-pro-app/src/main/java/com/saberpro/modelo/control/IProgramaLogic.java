package com.saberpro.modelo.control;

import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.Programa;
import com.saberpro.modelo.dto.FacultadDTO;
import com.saberpro.modelo.dto.ProgramaDTO;

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
public interface IProgramaLogic {
    public List<Programa> getPrograma() throws Exception;
    
    public List<Programa> getPrograma(String tipo) throws Exception;

    /**
         * Save an new Programa entity
         */
    public void savePrograma(Programa entity) throws Exception;

    /**
         * Delete an existing Programa entity
         *
         */
    public void deletePrograma(Programa entity) throws Exception;

    /**
        * Update an existing Programa entity
        *
        */
    public void updatePrograma(Programa entity) throws Exception;

    /**
         * Load an existing Programa entity
         *
         */
    public Programa getPrograma(Long idPrograma) throws Exception;

    public List<Programa> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Programa> findPagePrograma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPrograma() throws Exception;

    public List<ProgramaDTO> getDataPrograma() throws Exception;
    
    public List<ProgramaDTO> getDataPrograma(String tipo) throws Exception;
    
    public Programa findByNombre(String nombre)throws Exception;
    
    public ProgramaDTO findDataByNombre(String nombre)throws Exception;

    public void validatePrograma(Programa programa) throws Exception;
    
    
}
