package com.saberpro.modelo.control;

import com.saberpro.modelo.EstadoPrueba;
import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.dto.EstadoPruebaDTO;
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
public interface IEstadoPruebaLogic {
    public List<EstadoPrueba> getEstadoPrueba() throws Exception;
    
    public List<EstadoPrueba> getEstadoPrueba(String tipo) throws Exception;

    /**
         * Save an new EstadoPrueba entity
         */
    public void saveEstadoPrueba(EstadoPrueba entity) throws Exception;

    /**
         * Delete an existing EstadoPrueba entity
         *
         */
    public void deleteEstadoPrueba(EstadoPrueba entity)
        throws Exception;

    /**
        * Update an existing EstadoPrueba entity
        *
        */
    public void updateEstadoPrueba(EstadoPrueba entity)
        throws Exception;

    /**
         * Load an existing EstadoPrueba entity
         *
         */
    public EstadoPrueba getEstadoPrueba(Long idEstadoPrueba)
        throws Exception;

    public List<EstadoPrueba> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<EstadoPrueba> findPageEstadoPrueba(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEstadoPrueba() throws Exception;

    public List<EstadoPruebaDTO> getDataEstadoPrueba()
        throws Exception;
    
    public List<EstadoPruebaDTO> getDataEstadoPrueba(String tipo)
            throws Exception;
    
    public EstadoPrueba findByNombre(String nombre)throws Exception;
    
    public EstadoPruebaDTO findDataByNombre(String nombre)throws Exception;

    public void validateEstadoPrueba(EstadoPrueba estadoPrueba)
        throws Exception;
}
