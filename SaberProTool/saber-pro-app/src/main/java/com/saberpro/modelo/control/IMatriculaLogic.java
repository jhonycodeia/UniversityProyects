package com.saberpro.modelo.control;

import com.saberpro.modelo.Matricula;
import com.saberpro.modelo.dto.MatriculaDTO;

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
public interface IMatriculaLogic {
    public List<Matricula> getMatricula() throws Exception;
    
    public List<Matricula> getMatricula(String tipo) throws Exception;

    /**
         * Save an new Matricula entity
         */
    public void saveMatricula(Matricula entity) throws Exception;

    /**
         * Delete an existing Matricula entity
         *
         */
    public void deleteMatricula(Matricula entity) throws Exception;

    /**
        * Update an existing Matricula entity
        *
        */
    public void updateMatricula(Matricula entity) throws Exception;

    /**
         * Load an existing Matricula entity
         *
         */
    public Matricula getMatricula(Long idMatricula) throws Exception;

    public List<Matricula> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Matricula> findPageMatricula(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMatricula() throws Exception;

    public List<MatriculaDTO> getDataMatricula() throws Exception;
    
    public List<MatriculaDTO> getDataMatricula(String tipo) throws Exception;

    public void validateMatricula(Matricula matricula)
        throws Exception;
}
