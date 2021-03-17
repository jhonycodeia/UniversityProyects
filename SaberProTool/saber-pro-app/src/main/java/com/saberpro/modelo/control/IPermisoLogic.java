package com.saberpro.modelo.control;

import com.saberpro.modelo.Permiso;
import com.saberpro.modelo.dto.PermisoDTO;

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
public interface IPermisoLogic {
    public List<Permiso> getPermiso() throws Exception;
    
    public List<Permiso> getPermiso(String tipo) throws Exception;

    /**
         * Save an new Permiso entity
         */
    public void savePermiso(Permiso entity) throws Exception;

    /**
         * Delete an existing Permiso entity
         *
         */
    public void deletePermiso(Permiso entity) throws Exception;

    /**
        * Update an existing Permiso entity
        *
        */
    public void updatePermiso(Permiso entity) throws Exception;

    /**
         * Load an existing Permiso entity
         *
         */
    public Permiso getPermiso(Long idPermiso) throws Exception;

    public List<Permiso> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Permiso> findPagePermiso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPermiso() throws Exception;

    public List<PermisoDTO> getDataPermiso() throws Exception;
    
    public List<PermisoDTO> getDataPermiso(String tipo) throws Exception;

    public void validatePermiso(Permiso permiso) throws Exception;
}
