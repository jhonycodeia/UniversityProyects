package co.edu.usbcali.arquitectura.modelo.control;

import co.edu.usbcali.arquitectura.modelo.Nombre;
import co.edu.usbcali.arquitectura.modelo.dto.NombreDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface INombreLogic {
    public List<Nombre> getNombre() throws Exception;

    /**
         * Save an new Nombre entity
         */
    public void saveNombre(Nombre entity) throws Exception;

    /**
         * Delete an existing Nombre entity
         *
         */
    public void deleteNombre(Nombre entity) throws Exception;

    /**
        * Update an existing Nombre entity
        *
        */
    public void updateNombre(Nombre entity) throws Exception;

    /**
         * Load an existing Nombre entity
         *
         */
    public Nombre getNombre(Integer idNombre) throws Exception;

    public List<Nombre> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Nombre> findPageNombre(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberNombre() throws Exception;

    public List<NombreDTO> getDataNombre() throws Exception;

    public void validateNombre(Nombre nombre) throws Exception;
}
