package com.saberpro.modelo.control;

import com.saberpro.modelo.Prueba;
import com.saberpro.modelo.dto.PruebaDTO;

import java.io.ByteArrayInputStream;
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
public interface IPruebaLogic {
    public List<Prueba> getPrueba() throws Exception;
    
    public List<Prueba> getPrueba(String tipo) throws Exception;

    /**
         * Save an new Prueba entity
         */
    public void savePrueba(Prueba entity) throws Exception;

    /**
         * Delete an existing Prueba entity
         *
         */
    public void deletePrueba(Prueba entity) throws Exception;

    /**
        * Update an existing Prueba entity
        *
        */
    public void updatePrueba(Prueba entity) throws Exception;

    /**
         * Load an existing Prueba entity
         *
         */
    public Prueba getPrueba(Long idPrueba) throws Exception;

    public List<Prueba> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Prueba> findPagePrueba(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPrueba() throws Exception;

    public List<PruebaDTO> getDataPrueba() throws Exception;
    
    public List<PruebaDTO> getDataPrueba(String tipo) throws Exception;

    public void validatePrueba(Prueba prueba) throws Exception;

	public ByteArrayInputStream generarInformeIndividual(Long idPrueba) throws Exception;
	
	public ByteArrayInputStream generarInformeGrupo(Long idTipoPrueba,Long idPrograma,Long idModulo,String periodo,List<String> correos) throws Exception;
    
   
}
