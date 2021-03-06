package com.saberpro.modelo.control;

import com.saberpro.modelo.ProgramaUsuario;
import com.saberpro.modelo.dto.ProgramaUsuarioDTO;

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
public interface IProgramaUsuarioLogic {
    public List<ProgramaUsuario> getProgramaUsuario() throws Exception;
    
    public List<ProgramaUsuario> getProgramaUsuario(String tipo) throws Exception;

    /**
         * Save an new ProgramaUsuario entity
         */
    public void saveProgramaUsuario(ProgramaUsuario entity)
        throws Exception;

    /**
         * Delete an existing ProgramaUsuario entity
         *
         */
    public void deleteProgramaUsuario(ProgramaUsuario entity)
        throws Exception;

    /**
        * Update an existing ProgramaUsuario entity
        *
        */
    public void updateProgramaUsuario(ProgramaUsuario entity)
        throws Exception;

    /**
         * Load an existing ProgramaUsuario entity
         *
         */
    public ProgramaUsuario getProgramaUsuario(Long idProgramaUsuario)
        throws Exception;
    
    public ProgramaUsuarioDTO getDataProgramaUsuario(Long idProgramaUsuario)
            throws Exception;
    
    public List<ProgramaUsuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ProgramaUsuario> findPageProgramaUsuario(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberProgramaUsuario() throws Exception;

    public List<ProgramaUsuarioDTO> getDataProgramaUsuario()
        throws Exception;
    
    public List<ProgramaUsuarioDTO> getDataProgramaUsuario(String tipo)
            throws Exception;

    public void validateProgramaUsuario(ProgramaUsuario programaUsuario)
        throws Exception;
    
    
}
