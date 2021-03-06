package com.saberpro.dto.mapper;

import com.saberpro.modelo.Respuesta;
import com.saberpro.modelo.dto.RespuestaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IRespuestaMapper {
    public RespuestaDTO respuestaToRespuestaDTO(Respuesta respuesta)
        throws Exception;

    public Respuesta respuestaDTOToRespuesta(RespuestaDTO respuestaDTO)
        throws Exception;

    public List<RespuestaDTO> listRespuestaToListRespuestaDTO(
        List<Respuesta> respuestas) throws Exception;

    public List<Respuesta> listRespuestaDTOToListRespuesta(
        List<RespuestaDTO> respuestaDTOs) throws Exception;
}
