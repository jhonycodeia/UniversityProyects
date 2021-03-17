package co.edu.usbcali.arquitectura.modelo.control;

import co.edu.usbcali.arquitectura.modelo.Idioma;
import co.edu.usbcali.arquitectura.modelo.dto.IdiomaDTO;

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
public interface IIdiomaLogic {
    public List<Idioma> getIdioma() throws Exception;

    /**
         * Save an new Idioma entity
         */
    public void saveIdioma(Idioma entity) throws Exception;

    /**
         * Delete an existing Idioma entity
         *
         */
    public void deleteIdioma(Idioma entity) throws Exception;

    /**
        * Update an existing Idioma entity
        *
        */
    public void updateIdioma(Idioma entity) throws Exception;

    /**
         * Load an existing Idioma entity
         *
         */
    public Idioma getIdioma(Integer idIdioma) throws Exception;

    public List<Idioma> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Idioma> findPageIdioma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberIdioma() throws Exception;

    public List<IdiomaDTO> getDataIdioma() throws Exception;

    public void validateIdioma(Idioma idioma) throws Exception;
}
