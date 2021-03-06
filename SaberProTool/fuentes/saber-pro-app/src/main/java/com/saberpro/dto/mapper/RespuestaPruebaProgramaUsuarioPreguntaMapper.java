package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.RespuestaPruebaProgramaUsuarioPregunta;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.RespuestaPruebaProgramaUsuarioPreguntaDTO;

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
public class RespuestaPruebaProgramaUsuarioPreguntaMapper
    implements IRespuestaPruebaProgramaUsuarioPreguntaMapper {
    private static final Logger log = LoggerFactory.getLogger(RespuestaPruebaProgramaUsuarioPreguntaMapper.class);

    /**
    * Logic injected by Spring that manages PruebaProgramaUsuarioPregunta entities
    *
    */
    @Autowired
    IPruebaProgramaUsuarioPreguntaLogic logicPruebaProgramaUsuarioPregunta1;

    /**
    * Logic injected by Spring that manages Respuesta entities
    *
    */
    @Autowired
    IRespuestaLogic logicRespuesta2;

    @Transactional(readOnly = true)
    public RespuestaPruebaProgramaUsuarioPreguntaDTO respuestaPruebaProgramaUsuarioPreguntaToRespuestaPruebaProgramaUsuarioPreguntaDTO(
        RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPregunta)
        throws Exception {
        try {
            RespuestaPruebaProgramaUsuarioPreguntaDTO respuestaPruebaProgramaUsuarioPreguntaDTO =
                new RespuestaPruebaProgramaUsuarioPreguntaDTO();

            respuestaPruebaProgramaUsuarioPreguntaDTO.setIdRespuestaPruebaProgramaUsuarioPregunta(respuestaPruebaProgramaUsuarioPregunta.getIdRespuestaPruebaProgramaUsuarioPregunta());
            respuestaPruebaProgramaUsuarioPreguntaDTO.setActivo((respuestaPruebaProgramaUsuarioPregunta.getActivo() != null)
                ? respuestaPruebaProgramaUsuarioPregunta.getActivo() : null);
            respuestaPruebaProgramaUsuarioPreguntaDTO.setFechaCreacion(respuestaPruebaProgramaUsuarioPregunta.getFechaCreacion());
            respuestaPruebaProgramaUsuarioPreguntaDTO.setFechaModificacion(respuestaPruebaProgramaUsuarioPregunta.getFechaModificacion());
            respuestaPruebaProgramaUsuarioPreguntaDTO.setPorcentajeAsignado((respuestaPruebaProgramaUsuarioPregunta.getPorcentajeAsignado() != null)
                ? respuestaPruebaProgramaUsuarioPregunta.getPorcentajeAsignado()
                : null);
            respuestaPruebaProgramaUsuarioPreguntaDTO.setUsuCreador((respuestaPruebaProgramaUsuarioPregunta.getUsuCreador() != null)
                ? respuestaPruebaProgramaUsuarioPregunta.getUsuCreador() : null);
            respuestaPruebaProgramaUsuarioPreguntaDTO.setUsuModificador((respuestaPruebaProgramaUsuarioPregunta.getUsuModificador() != null)
                ? respuestaPruebaProgramaUsuarioPregunta.getUsuModificador()
                : null);
            respuestaPruebaProgramaUsuarioPreguntaDTO.setIdPruebaProgramaUsuarioPregunta_PruebaProgramaUsuarioPregunta((respuestaPruebaProgramaUsuarioPregunta.getPruebaProgramaUsuarioPregunta()
                                                                                                                                                              .getIdPruebaProgramaUsuarioPregunta() != null)
                ? respuestaPruebaProgramaUsuarioPregunta.getPruebaProgramaUsuarioPregunta()
                                                        .getIdPruebaProgramaUsuarioPregunta()
                : null);
            respuestaPruebaProgramaUsuarioPreguntaDTO.setIdRespuesta_Respuesta((respuestaPruebaProgramaUsuarioPregunta.getRespuesta()
                                                                                                                      .getIdRespuesta() != null)
                ? respuestaPruebaProgramaUsuarioPregunta.getRespuesta()
                                                        .getIdRespuesta() : null);

            return respuestaPruebaProgramaUsuarioPreguntaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPreguntaDTOToRespuestaPruebaProgramaUsuarioPregunta(
        RespuestaPruebaProgramaUsuarioPreguntaDTO respuestaPruebaProgramaUsuarioPreguntaDTO)
        throws Exception {
        try {
            RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPregunta =
                new RespuestaPruebaProgramaUsuarioPregunta();

            respuestaPruebaProgramaUsuarioPregunta.setIdRespuestaPruebaProgramaUsuarioPregunta(respuestaPruebaProgramaUsuarioPreguntaDTO.getIdRespuestaPruebaProgramaUsuarioPregunta());
            respuestaPruebaProgramaUsuarioPregunta.setActivo((respuestaPruebaProgramaUsuarioPreguntaDTO.getActivo() != null)
                ? respuestaPruebaProgramaUsuarioPreguntaDTO.getActivo() : null);
            respuestaPruebaProgramaUsuarioPregunta.setFechaCreacion(respuestaPruebaProgramaUsuarioPreguntaDTO.getFechaCreacion());
            respuestaPruebaProgramaUsuarioPregunta.setFechaModificacion(respuestaPruebaProgramaUsuarioPreguntaDTO.getFechaModificacion());
            respuestaPruebaProgramaUsuarioPregunta.setPorcentajeAsignado((respuestaPruebaProgramaUsuarioPreguntaDTO.getPorcentajeAsignado() != null)
                ? respuestaPruebaProgramaUsuarioPreguntaDTO.getPorcentajeAsignado()
                : null);
            respuestaPruebaProgramaUsuarioPregunta.setUsuCreador((respuestaPruebaProgramaUsuarioPreguntaDTO.getUsuCreador() != null)
                ? respuestaPruebaProgramaUsuarioPreguntaDTO.getUsuCreador() : null);
            respuestaPruebaProgramaUsuarioPregunta.setUsuModificador((respuestaPruebaProgramaUsuarioPreguntaDTO.getUsuModificador() != null)
                ? respuestaPruebaProgramaUsuarioPreguntaDTO.getUsuModificador()
                : null);

            PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta = new PruebaProgramaUsuarioPregunta();

            if (respuestaPruebaProgramaUsuarioPreguntaDTO.getIdPruebaProgramaUsuarioPregunta_PruebaProgramaUsuarioPregunta() != null) {
                pruebaProgramaUsuarioPregunta = logicPruebaProgramaUsuarioPregunta1.getPruebaProgramaUsuarioPregunta(respuestaPruebaProgramaUsuarioPreguntaDTO.getIdPruebaProgramaUsuarioPregunta_PruebaProgramaUsuarioPregunta());
            }

            if (pruebaProgramaUsuarioPregunta != null) {
                respuestaPruebaProgramaUsuarioPregunta.setPruebaProgramaUsuarioPregunta(pruebaProgramaUsuarioPregunta);
            }

            Respuesta respuesta = new Respuesta();

            if (respuestaPruebaProgramaUsuarioPreguntaDTO.getIdRespuesta_Respuesta() != null) {
                respuesta = logicRespuesta2.getRespuesta(respuestaPruebaProgramaUsuarioPreguntaDTO.getIdRespuesta_Respuesta());
            }

            if (respuesta != null) {
                respuestaPruebaProgramaUsuarioPregunta.setRespuesta(respuesta);
            }

            return respuestaPruebaProgramaUsuarioPregunta;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RespuestaPruebaProgramaUsuarioPreguntaDTO> listRespuestaPruebaProgramaUsuarioPreguntaToListRespuestaPruebaProgramaUsuarioPreguntaDTO(
        List<RespuestaPruebaProgramaUsuarioPregunta> listRespuestaPruebaProgramaUsuarioPregunta)
        throws Exception {
        try {
            List<RespuestaPruebaProgramaUsuarioPreguntaDTO> respuestaPruebaProgramaUsuarioPreguntaDTOs =
                new ArrayList<RespuestaPruebaProgramaUsuarioPreguntaDTO>();

            for (RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPregunta : listRespuestaPruebaProgramaUsuarioPregunta) {
                RespuestaPruebaProgramaUsuarioPreguntaDTO respuestaPruebaProgramaUsuarioPreguntaDTO =
                    respuestaPruebaProgramaUsuarioPreguntaToRespuestaPruebaProgramaUsuarioPreguntaDTO(respuestaPruebaProgramaUsuarioPregunta);

                respuestaPruebaProgramaUsuarioPreguntaDTOs.add(respuestaPruebaProgramaUsuarioPreguntaDTO);
            }

            return respuestaPruebaProgramaUsuarioPreguntaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RespuestaPruebaProgramaUsuarioPregunta> listRespuestaPruebaProgramaUsuarioPreguntaDTOToListRespuestaPruebaProgramaUsuarioPregunta(
        List<RespuestaPruebaProgramaUsuarioPreguntaDTO> listRespuestaPruebaProgramaUsuarioPreguntaDTO)
        throws Exception {
        try {
            List<RespuestaPruebaProgramaUsuarioPregunta> listRespuestaPruebaProgramaUsuarioPregunta =
                new ArrayList<RespuestaPruebaProgramaUsuarioPregunta>();

            for (RespuestaPruebaProgramaUsuarioPreguntaDTO respuestaPruebaProgramaUsuarioPreguntaDTO : listRespuestaPruebaProgramaUsuarioPreguntaDTO) {
                RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPregunta =
                    respuestaPruebaProgramaUsuarioPreguntaDTOToRespuestaPruebaProgramaUsuarioPregunta(respuestaPruebaProgramaUsuarioPreguntaDTO);

                listRespuestaPruebaProgramaUsuarioPregunta.add(respuestaPruebaProgramaUsuarioPregunta);
            }

            return listRespuestaPruebaProgramaUsuarioPregunta;
        } catch (Exception e) {
            throw e;
        }
    }
}
