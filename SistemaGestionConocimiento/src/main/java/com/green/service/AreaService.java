package com.green.service;

import com.green.dto.AreaDTO;

import com.green.modelo.Area;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface AreaService {
    public List<Area> getArea() throws Exception;

    /**
         * Save an new Area entity
         */
    public void saveArea(Area entity) throws Exception;

    /**
         * Delete an existing Area entity
         *
         */
    public void deleteArea(Area entity) throws Exception;

    /**
        * Update an existing Area entity
        *
        */
    public void updateArea(Area entity) throws Exception;

    /**
         * Load an existing Area entity
         *
         */
    public Area getArea(Long idArea) throws Exception;

    public List<Area> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Area> findPageArea(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberArea() throws Exception;

    public List<AreaDTO> getDataArea() throws Exception;

    public void validateArea(Area area) throws Exception;
}
