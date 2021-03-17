package com.saberpro.modelo.control;

import com.saberpro.modelo.Pregunta;
import com.saberpro.modelo.Respuesta;
import com.saberpro.modelo.dto.PreguntaDTO;
import com.saberpro.modelo.dto.ResultadosPreguntaDTO;

import java.io.File;
import java.io.InputStream;
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
public interface IPreguntaLogic {
    public List<Pregunta> getPregunta() throws Exception;
    
    public List<Pregunta> getPregunta(String tipo) throws Exception;

    /**
         * Save an new Pregunta entity
         */
    public void savePregunta(Pregunta entity) throws Exception;
    public void savePregunta(Pregunta entity,List<Respuesta> listRespuesta) throws Exception;

    /**
         * Delete an existing Pregunta entity
         *
         */
    public void deletePregunta(Pregunta entity) throws Exception;

    /**
        * Update an existing Pregunta entity
        *
        */
    public void updatePregunta(Pregunta entity) throws Exception;

    /**
         * Load an existing Pregunta entity
         *
         */
    public Pregunta getPregunta(Long idPregunta) throws Exception;

    public List<Pregunta> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Pregunta> findPagePregunta(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPregunta() throws Exception;

    public List<PreguntaDTO> getDataPregunta() throws Exception;
    
    public List<PreguntaDTO> getDataPregunta(String tipo) throws Exception;

    public void validatePregunta(Pregunta pregunta) throws Exception;
    
    public void importFile(InputStream archivo,long user,String formato)throws Exception;  
    
    public void subirFile(InputStream origen, String destino) throws Exception;
    
    public List<Pregunta> findByRandom(long idModulo,long limit)throws Exception;
    
    public List<Pregunta> findByPruebaProgramaUsuario(long idPruebaProgramaUsuario)throws Exception;
    
    public List<ResultadosPreguntaDTO> findByTopPregunta(long idModulo)throws Exception;
}
