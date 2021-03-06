package com.green.service;

import com.green.dto.DocumentoDTO;

import com.green.modelo.Documento;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.*;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface DocumentoService {
    public List<Documento> getDocumento() throws Exception;

    /**
         * Save an new Documento entity
         */
    public void saveDocumento(Documento entity) throws Exception;

    /**
         * Delete an existing Documento entity
         *
         */
    public void deleteDocumento(Documento entity) throws Exception;

    /**
        * Update an existing Documento entity
        *
        */
    public void updateDocumento(Documento entity) throws Exception;

    /**
         * Load an existing Documento entity
         *
         */
    public Documento getDocumento(Long idDocumento) throws Exception;

    public List<Documento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Documento> findPageDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDocumento() throws Exception;

    public List<DocumentoDTO> getDataDocumento() throws Exception;

    public void validateDocumento(Documento documento)
        throws Exception;    
    
    public InputStream generarFiles(Long idDocumento) throws Exception;
}
