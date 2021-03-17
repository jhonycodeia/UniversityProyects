package com.saberpro.modelo.control;

import com.saberpro.modelo.ProgramaModulo;
import com.saberpro.modelo.dto.ProgramaModuloDTO;

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
public interface IProgramaModuloLogic {
    public List<ProgramaModulo> getProgramaModulo() throws Exception;
    
    public List<ProgramaModulo> getProgramaModulo(String tipo) throws Exception;

    /**
         * Save an new ProgramaModulo entity
         */
    public void saveProgramaModulo(ProgramaModulo entity)
        throws Exception;

    /**
         * Delete an existing ProgramaModulo entity
         *
         */
    public void deleteProgramaModulo(ProgramaModulo entity)
        throws Exception;

    /**
        * Update an existing ProgramaModulo entity
        *
        */
    public void updateProgramaModulo(ProgramaModulo entity)
        throws Exception;

    /**
         * Load an existing ProgramaModulo entity
         *
         */
    public ProgramaModulo getProgramaModulo(Long idProgramaModulo)
        throws Exception;

    public List<ProgramaModulo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ProgramaModulo> findPageProgramaModulo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberProgramaModulo() throws Exception;

    public List<ProgramaModuloDTO> getDataProgramaModulo()
        throws Exception;
    
    public List<ProgramaModuloDTO> getDataProgramaModulo(String tipo)
            throws Exception;

    public void validateProgramaModulo(ProgramaModulo programaModulo)
        throws Exception;
    
    
}
