package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.Pregunta;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.PreguntaDTO;

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
public class PreguntaMapper implements IPreguntaMapper {
    private static final Logger log = LoggerFactory.getLogger(PreguntaMapper.class);

    /**
    * Logic injected by Spring that manages Modulo entities
    *
    */
    @Autowired
    IModuloLogic logicModulo1;

    /**
    * Logic injected by Spring that manages TipoPregunta entities
    *
    */
    @Autowired
    ITipoPreguntaLogic logicTipoPregunta2;

    @Transactional(readOnly = true)
    public PreguntaDTO preguntaToPreguntaDTO(Pregunta pregunta)
        throws Exception {
        try {
            PreguntaDTO preguntaDTO = new PreguntaDTO();

            preguntaDTO.setIdPregunta(pregunta.getIdPregunta());
            preguntaDTO.setActivo((pregunta.getActivo() != null)
                ? pregunta.getActivo() : null);
            preguntaDTO.setDescripcionPregunta((pregunta.getDescripcionPregunta() != null)
                ? pregunta.getDescripcionPregunta() : null);
            preguntaDTO.setFechaCreacion(pregunta.getFechaCreacion());
            preguntaDTO.setFechaModificacion(pregunta.getFechaModificacion());
            preguntaDTO.setRetroalimentacion((pregunta.getRetroalimentacion() != null)
                ? pregunta.getRetroalimentacion() : null);
            preguntaDTO.setUsuCreador((pregunta.getUsuCreador() != null)
                ? pregunta.getUsuCreador() : null);
            preguntaDTO.setUsuModificador((pregunta.getUsuModificador() != null)
                ? pregunta.getUsuModificador() : null);
            preguntaDTO.setIdModulo_Modulo((pregunta.getModulo().getIdModulo() != null)
                ? pregunta.getModulo().getIdModulo() : null);
            preguntaDTO.setIdTipoPregunta_TipoPregunta((pregunta.getTipoPregunta()
                                                                .getIdTipoPregunta() != null)
                ? pregunta.getTipoPregunta().getIdTipoPregunta() : null);

            return preguntaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Pregunta preguntaDTOToPregunta(PreguntaDTO preguntaDTO)
        throws Exception {
        try {
            Pregunta pregunta = new Pregunta();

            pregunta.setIdPregunta(preguntaDTO.getIdPregunta());
            pregunta.setActivo((preguntaDTO.getActivo() != null)
                ? preguntaDTO.getActivo() : null);
            pregunta.setDescripcionPregunta((preguntaDTO.getDescripcionPregunta() != null)
                ? preguntaDTO.getDescripcionPregunta() : null);
            pregunta.setFechaCreacion(preguntaDTO.getFechaCreacion());
            pregunta.setFechaModificacion(preguntaDTO.getFechaModificacion());
            pregunta.setRetroalimentacion((preguntaDTO.getRetroalimentacion() != null)
                ? preguntaDTO.getRetroalimentacion() : null);
            pregunta.setUsuCreador((preguntaDTO.getUsuCreador() != null)
                ? preguntaDTO.getUsuCreador() : null);
            pregunta.setUsuModificador((preguntaDTO.getUsuModificador() != null)
                ? preguntaDTO.getUsuModificador() : null);

            Modulo modulo = new Modulo();

            if (preguntaDTO.getIdModulo_Modulo() != null) {
                modulo = logicModulo1.getModulo(preguntaDTO.getIdModulo_Modulo());
            }

            if (modulo != null) {
                pregunta.setModulo(modulo);
            }

            TipoPregunta tipoPregunta = new TipoPregunta();

            if (preguntaDTO.getIdTipoPregunta_TipoPregunta() != null) {
                tipoPregunta = logicTipoPregunta2.getTipoPregunta(preguntaDTO.getIdTipoPregunta_TipoPregunta());
            }

            if (tipoPregunta != null) {
                pregunta.setTipoPregunta(tipoPregunta);
            }

            return pregunta;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PreguntaDTO> listPreguntaToListPreguntaDTO(
        List<Pregunta> listPregunta) throws Exception {
        try {
            List<PreguntaDTO> preguntaDTOs = new ArrayList<PreguntaDTO>();

            for (Pregunta pregunta : listPregunta) {
                PreguntaDTO preguntaDTO = preguntaToPreguntaDTO(pregunta);

                preguntaDTOs.add(preguntaDTO);
            }

            return preguntaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Pregunta> listPreguntaDTOToListPregunta(
        List<PreguntaDTO> listPreguntaDTO) throws Exception {
        try {
            List<Pregunta> listPregunta = new ArrayList<Pregunta>();

            for (PreguntaDTO preguntaDTO : listPreguntaDTO) {
                Pregunta pregunta = preguntaDTOToPregunta(preguntaDTO);

                listPregunta.add(pregunta);
            }

            return listPregunta;
        } catch (Exception e) {
            throw e;
        }
    }
}
