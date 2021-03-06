package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.Respuesta;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.RespuestaDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class RespuestaMapper implements IRespuestaMapper {
    private static final Logger log = LoggerFactory.getLogger(RespuestaMapper.class);

    /**
    * Logic injected by Spring that manages Pregunta entities
    *
    */
    @Autowired
    IPreguntaLogic logicPregunta1;

    @Transactional(readOnly = true)
    public RespuestaDTO respuestaToRespuestaDTO(Respuesta respuesta)
        throws Exception {
        try {
            RespuestaDTO respuestaDTO = new RespuestaDTO();

            respuestaDTO.setIdRespuesta(respuesta.getIdRespuesta());
            respuestaDTO.setActivo((respuesta.getActivo() != null)
                ? respuesta.getActivo() : null);
            respuestaDTO.setDescripcionRespuesta((respuesta.getDescripcionRespuesta() != null)
                ? respuesta.getDescripcionRespuesta() : null);
            respuestaDTO.setFechaCreacion(respuesta.getFechaCreacion());
            respuestaDTO.setFechaModificacion(respuesta.getFechaModificacion());
            respuestaDTO.setPorcentajeAcierto((respuesta.getPorcentajeAcierto() != null)
                ? respuesta.getPorcentajeAcierto() : null);
            respuestaDTO.setRutaImagen((respuesta.getRutaImagen() != null)
                ? respuesta.getRutaImagen() : null);
            respuestaDTO.setUsuCreador((respuesta.getUsuCreador() != null)
                ? respuesta.getUsuCreador() : null);
            respuestaDTO.setUsuModificador((respuesta.getUsuModificador() != null)
                ? respuesta.getUsuModificador() : null);
            respuestaDTO.setIdPregunta_Pregunta((respuesta.getPregunta()
                                                          .getIdPregunta() != null)
                ? respuesta.getPregunta().getIdPregunta() : null);

            return respuestaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Respuesta respuestaDTOToRespuesta(RespuestaDTO respuestaDTO)
        throws Exception {
        try {
            Respuesta respuesta = new Respuesta();

            respuesta.setIdRespuesta(respuestaDTO.getIdRespuesta());
            respuesta.setActivo((respuestaDTO.getActivo() != null)
                ? respuestaDTO.getActivo() : null);
            respuesta.setDescripcionRespuesta((respuestaDTO.getDescripcionRespuesta() != null)
                ? respuestaDTO.getDescripcionRespuesta() : null);
            respuesta.setFechaCreacion(respuestaDTO.getFechaCreacion());
            respuesta.setFechaModificacion(respuestaDTO.getFechaModificacion());
            respuesta.setPorcentajeAcierto((respuestaDTO.getPorcentajeAcierto() != null)
                ? respuestaDTO.getPorcentajeAcierto() : null);
            respuesta.setRutaImagen((respuestaDTO.getRutaImagen() != null)
                ? respuestaDTO.getRutaImagen() : null);
            respuesta.setUsuCreador((respuestaDTO.getUsuCreador() != null)
                ? respuestaDTO.getUsuCreador() : null);
            respuesta.setUsuModificador((respuestaDTO.getUsuModificador() != null)
                ? respuestaDTO.getUsuModificador() : null);

            Pregunta pregunta = new Pregunta();

            if (respuestaDTO.getIdPregunta_Pregunta() != null) {
                pregunta = logicPregunta1.getPregunta(respuestaDTO.getIdPregunta_Pregunta());
            }

            if (pregunta != null) {
                respuesta.setPregunta(pregunta);
            }

            return respuesta;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RespuestaDTO> listRespuestaToListRespuestaDTO(
        List<Respuesta> listRespuesta) throws Exception {
        try {
            List<RespuestaDTO> respuestaDTOs = new ArrayList<RespuestaDTO>();

            for (Respuesta respuesta : listRespuesta) {
                RespuestaDTO respuestaDTO = respuestaToRespuestaDTO(respuesta);

                respuestaDTOs.add(respuestaDTO);
            }

            return respuestaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Respuesta> listRespuestaDTOToListRespuesta(
        List<RespuestaDTO> listRespuestaDTO) throws Exception {
        try {
            List<Respuesta> listRespuesta = new ArrayList<Respuesta>();

            for (RespuestaDTO respuestaDTO : listRespuestaDTO) {
                Respuesta respuesta = respuestaDTOToRespuesta(respuestaDTO);

                listRespuesta.add(respuesta);
            }

            return listRespuesta;
        } catch (Exception e) {
            throw e;
        }
    }
}
