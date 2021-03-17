package com.saberpro.modelo.control;

import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.TipoUsuario;
import com.saberpro.modelo.dto.FacultadDTO;
import com.saberpro.modelo.dto.TipoUsuarioDTO;

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
public interface ITipoUsuarioLogic {
    public List<TipoUsuario> getTipoUsuario() throws Exception;
    
    public List<TipoUsuario> getTipoUsuario(String tipo) throws Exception;

    /**
         * Save an new TipoUsuario entity
         */
    public void saveTipoUsuario(TipoUsuario entity) throws Exception;

    /**
         * Delete an existing TipoUsuario entity
         *
         */
    public void deleteTipoUsuario(TipoUsuario entity) throws Exception;

    /**
        * Update an existing TipoUsuario entity
        *
        */
    public void updateTipoUsuario(TipoUsuario entity) throws Exception;

    /**
         * Load an existing TipoUsuario entity
         *
         */
    public TipoUsuario getTipoUsuario(Long idTipoUsuario)
        throws Exception;

    public List<TipoUsuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoUsuario> findPageTipoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoUsuario() throws Exception;

    public List<TipoUsuarioDTO> getDataTipoUsuario() throws Exception;
    
    public List<TipoUsuarioDTO> getDataTipoUsuario(String tipo) throws Exception;
    
    public TipoUsuario findByNombre(String nombre)throws Exception;
    
    public TipoUsuarioDTO findDataByNombre(String nombre)throws Exception;

    public void validateTipoUsuario(TipoUsuario tipoUsuario)
        throws Exception;
    
    
}
