package com.saberpro.dto.mapper;

import com.saberpro.modelo.RespuestaPruebaProgramaUsuarioPregunta;
import com.saberpro.modelo.dto.RespuestaPruebaProgramaUsuarioPreguntaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IRespuestaPruebaProgramaUsuarioPreguntaMapper {
    public RespuestaPruebaProgramaUsuarioPreguntaDTO respuestaPruebaProgramaUsuarioPreguntaToRespuestaPruebaProgramaUsuarioPreguntaDTO(
        RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPregunta)
        throws Exception;

    public RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPreguntaDTOToRespuestaPruebaProgramaUsuarioPregunta(
        RespuestaPruebaProgramaUsuarioPreguntaDTO respuestaPruebaProgramaUsuarioPreguntaDTO)
        throws Exception;

    public List<RespuestaPruebaProgramaUsuarioPreguntaDTO> listRespuestaPruebaProgramaUsuarioPreguntaToListRespuestaPruebaProgramaUsuarioPreguntaDTO(
        List<RespuestaPruebaProgramaUsuarioPregunta> respuestaPruebaProgramaUsuarioPreguntas)
        throws Exception;

    public List<RespuestaPruebaProgramaUsuarioPregunta> listRespuestaPruebaProgramaUsuarioPreguntaDTOToListRespuestaPruebaProgramaUsuarioPregunta(
        List<RespuestaPruebaProgramaUsuarioPreguntaDTO> respuestaPruebaProgramaUsuarioPreguntaDTOs)
        throws Exception;
}
