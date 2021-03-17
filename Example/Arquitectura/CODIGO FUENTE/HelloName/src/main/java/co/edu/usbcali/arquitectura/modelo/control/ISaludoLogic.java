package co.edu.usbcali.arquitectura.modelo.control;

import co.edu.usbcali.arquitectura.dataaccess.api.DaoException;
import co.edu.usbcali.arquitectura.modelo.Saludo;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoDTO;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoNombreDTO;

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
public interface ISaludoLogic {
    public List<Saludo> getSaludo() throws Exception;

    /**
         * Save an new Saludo entity
         */
    public void saveSaludo(Saludo entity) throws Exception;

    /**
         * Delete an existing Saludo entity
         *
         */
    public void deleteSaludo(Saludo entity) throws Exception;
    public SaludoNombreDTO SaludoNombre(String nombre) throws Exception ;

    /**
        * Update an existing Saludo entity
        *
        */
    public void updateSaludo(Saludo entity) throws Exception;

    /**
         * Load an existing Saludo entity
         *
         */
    public Saludo getSaludo(Integer idSaludo) throws Exception;

    public List<Saludo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Saludo> findPageSaludo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSaludo() throws Exception;

    public List<SaludoDTO> getDataSaludo() throws Exception;

    public void validateSaludo(Saludo saludo) throws Exception;
}
