package com.saberpro.dto.mapper;

import com.saberpro.modelo.PruebaProgramaUsuarioPregunta;
import com.saberpro.modelo.dto.PruebaProgramaUsuarioPreguntaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IPruebaProgramaUsuarioPreguntaMapper {
    public PruebaProgramaUsuarioPreguntaDTO pruebaProgramaUsuarioPreguntaToPruebaProgramaUsuarioPreguntaDTO(
        PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta)
        throws Exception;

    public PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPreguntaDTOToPruebaProgramaUsuarioPregunta(
        PruebaProgramaUsuarioPreguntaDTO pruebaProgramaUsuarioPreguntaDTO)
        throws Exception;

    public List<PruebaProgramaUsuarioPreguntaDTO> listPruebaProgramaUsuarioPreguntaToListPruebaProgramaUsuarioPreguntaDTO(
        List<PruebaProgramaUsuarioPregunta> pruebaProgramaUsuarioPreguntas)
        throws Exception;

    public List<PruebaProgramaUsuarioPregunta> listPruebaProgramaUsuarioPreguntaDTOToListPruebaProgramaUsuarioPregunta(
        List<PruebaProgramaUsuarioPreguntaDTO> pruebaProgramaUsuarioPreguntaDTOs)
        throws Exception;
}
