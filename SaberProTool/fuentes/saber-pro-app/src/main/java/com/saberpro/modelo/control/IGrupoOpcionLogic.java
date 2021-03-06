package com.saberpro.modelo.control;

import com.saberpro.dataaccess.api.DaoException;
import com.saberpro.modelo.GrupoOpcion;
import com.saberpro.modelo.dto.GrupoOpcionDTO;

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
public interface IGrupoOpcionLogic {
    public List<GrupoOpcion> getGrupoOpcion() throws Exception;
    
    public List<GrupoOpcion> getGrupoOpcion(String tipo) throws Exception;

    /**
         * Save an new GrupoOpcion entity
         */
    public void saveGrupoOpcion(GrupoOpcion entity) throws Exception;

    /**
         * Delete an existing GrupoOpcion entity
         *
         */
    public void deleteGrupoOpcion(GrupoOpcion entity) throws Exception;

    /**
        * Update an existing GrupoOpcion entity
        *
        */
    public void updateGrupoOpcion(GrupoOpcion entity) throws Exception;

    /**
         * Load an existing GrupoOpcion entity
         *
         */
    public GrupoOpcion getGrupoOpcion(Long idGrupoOpcion)
        throws Exception;

    public List<GrupoOpcion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GrupoOpcion> findPageGrupoOpcion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGrupoOpcion() throws Exception;

    public List<GrupoOpcionDTO> getDataGrupoOpcion() throws Exception;
    
    public List<GrupoOpcionDTO> getDataGrupoOpcion(String tipo) throws Exception;

    public void validateGrupoOpcion(GrupoOpcion grupoOpcion)
        throws Exception;
    
    public List<GrupoOpcion> findByTipoUsuario(long tipoUsuario,String activo)throws Exception;
    
    public List<GrupoOpcionDTO> findByDataTipoUsuario(long tipoUsuario,String activo)throws Exception;
    
    public List<GrupoOpcion> findByTipoUsuario(long tipoUsuario)throws Exception;
    
    public List<GrupoOpcionDTO> findByDataTipoUsuario(long tipoUsuario)throws Exception;
}
