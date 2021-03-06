package com.green.service;

import com.green.dto.CapsulaDTO;
import com.green.dto.RankDTO;
import com.green.modelo.Capsula;
import com.green.modelo.Documento;
import com.green.modelo.Usuario;
import com.green.utility.FilesDocumento;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface CapsulaService {
    public List<Capsula> getCapsula() throws Exception;

    /**
         * Save an new Capsula entity
         */
    public void saveCapsula(Capsula entity) throws Exception;
    public void saveCapsula(Capsula entity,List<FilesDocumento> documentos,List<String> palabras)throws Exception;
    public void validarCapsula(Capsula entity,Usuario usuario,boolean pasa)throws Exception;

    /**
         * Delete an existing Capsula entity
         *
         */
    public void deleteCapsula(Capsula entity) throws Exception;

    /**
        * Update an existing Capsula entity
        *
        */
    public void updateCapsula(Capsula entity) throws Exception;
    public void updateCapsula(Capsula entity,List<FilesDocumento> documentos,List<String> palabras) throws Exception;

    /**
         * Load an existing Capsula entity
         *
         */
    public Capsula getCapsula(Long idCapsula) throws Exception;

    public List<Capsula> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Capsula> findPageCapsula(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCapsula() throws Exception;

    public List<CapsulaDTO> getDataCapsula() throws Exception;

    public void validateCapsula(Capsula capsula) throws Exception;
    
    public List<RankDTO> rankPuntos(long idTipoPuntos)throws Exception;
	public List<RankDTO> rankCapsulas()throws Exception;
	public List<RankDTO> rankComentarios()throws Exception;
}
