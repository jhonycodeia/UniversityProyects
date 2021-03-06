package com.saberpro.modelo.control;

import com.saberpro.modelo.EstadoPrueba;
import com.saberpro.modelo.Modulo;
import com.saberpro.modelo.dto.EstadoPruebaDTO;
import com.saberpro.modelo.dto.ModuloDTO;

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
public interface IModuloLogic {
    public List<Modulo> getModulo() throws Exception;
    
    public List<Modulo> getModulo(String tipo) throws Exception;

    /**
         * Save an new Modulo entity
         */
    public void saveModulo(Modulo entity) throws Exception;

    /**
         * Delete an existing Modulo entity
         *
         */
    public void deleteModulo(Modulo entity) throws Exception;

    /**
        * Update an existing Modulo entity
        *
        */
    public void updateModulo(Modulo entity) throws Exception;

    /**
         * Load an existing Modulo entity
         *
         */
    public Modulo getModulo(Long idModulo) throws Exception;

    public List<Modulo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Modulo> findPageModulo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberModulo() throws Exception;

    public List<ModuloDTO> getDataModulo() throws Exception;
    
    public List<ModuloDTO> getDataModulo(String tipo) throws Exception;
    
    public Modulo findByNombre(String nombre)throws Exception;
    
    public ModuloDTO findDataByNombre(String nombre)throws Exception;

    public void validateModulo(Modulo modulo) throws Exception;
    
    public List<Modulo> findByPrograma(long idPrograma)throws Exception;
}
