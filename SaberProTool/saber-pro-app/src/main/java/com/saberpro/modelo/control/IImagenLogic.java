package com.saberpro.modelo.control;

import com.saberpro.modelo.Imagen;
import com.saberpro.modelo.dto.ImagenDTO;

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
public interface IImagenLogic {
    public List<Imagen> getImagen() throws Exception;
    
    public List<Imagen> getImagen(String tipo) throws Exception;

    /**
         * Save an new Imagen entity
         */
    public void saveImagen(Imagen entity) throws Exception;

    /**
         * Delete an existing Imagen entity
         *
         */
    public void deleteImagen(Imagen entity) throws Exception;

    /**
        * Update an existing Imagen entity
        *
        */
    public void updateImagen(Imagen entity) throws Exception;

    /**
         * Load an existing Imagen entity
         *
         */
    public Imagen getImagen(Long idImagen) throws Exception;

    public List<Imagen> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Imagen> findPageImagen(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberImagen() throws Exception;

    public List<ImagenDTO> getDataImagen() throws Exception;
    
    public List<ImagenDTO> getDataImagen(String tipo) throws Exception;

    public void validateImagen(Imagen imagen) throws Exception;
}
