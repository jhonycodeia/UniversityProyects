package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.PruebaProgramaUsuarioPregunta;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.PruebaProgramaUsuarioPreguntaDTO;

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
public class PruebaProgramaUsuarioPreguntaMapper
    implements IPruebaProgramaUsuarioPreguntaMapper {
    private static final Logger log = LoggerFactory.getLogger(PruebaProgramaUsuarioPreguntaMapper.class);

    /**
    * Logic injected by Spring that manages Pregunta entities
    *
    */
    @Autowired
    IPreguntaLogic logicPregunta1;

    /**
    * Logic injected by Spring that manages PruebaProgramaUsuario entities
    *
    */
    @Autowired
    IPruebaProgramaUsuarioLogic logicPruebaProgramaUsuario2;

    @Transactional(readOnly = true)
    public PruebaProgramaUsuarioPreguntaDTO pruebaProgramaUsuarioPreguntaToPruebaProgramaUsuarioPreguntaDTO(
        PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta)
        throws Exception {
        try {
            PruebaProgramaUsuarioPreguntaDTO pruebaProgramaUsuarioPreguntaDTO = new PruebaProgramaUsuarioPreguntaDTO();

            pruebaProgramaUsuarioPreguntaDTO.setIdPruebaProgramaUsuarioPregunta(pruebaProgramaUsuarioPregunta.getIdPruebaProgramaUsuarioPregunta());
            pruebaProgramaUsuarioPreguntaDTO.setActivo((pruebaProgramaUsuarioPregunta.getActivo() != null)
                ? pruebaProgramaUsuarioPregunta.getActivo() : null);
            pruebaProgramaUsuarioPreguntaDTO.setFechaCreacion(pruebaProgramaUsuarioPregunta.getFechaCreacion());
            pruebaProgramaUsuarioPreguntaDTO.setFechaModificacion(pruebaProgramaUsuarioPregunta.getFechaModificacion());
            pruebaProgramaUsuarioPreguntaDTO.setUsuCreador((pruebaProgramaUsuarioPregunta.getUsuCreador() != null)
                ? pruebaProgramaUsuarioPregunta.getUsuCreador() : null);
            pruebaProgramaUsuarioPreguntaDTO.setUsuModificador((pruebaProgramaUsuarioPregunta.getUsuModificador() != null)
                ? pruebaProgramaUsuarioPregunta.getUsuModificador() : null);
            pruebaProgramaUsuarioPreguntaDTO.setIdPregunta_Pregunta((pruebaProgramaUsuarioPregunta.getPregunta()
                                                                                                  .getIdPregunta() != null)
                ? pruebaProgramaUsuarioPregunta.getPregunta().getIdPregunta()
                : null);
            pruebaProgramaUsuarioPreguntaDTO.setIdPruebaProgramaUsuario_PruebaProgramaUsuario((pruebaProgramaUsuarioPregunta.getPruebaProgramaUsuario()
                                                                                                                            .getIdPruebaProgramaUsuario() != null)
                ? pruebaProgramaUsuarioPregunta.getPruebaProgramaUsuario()
                                               .getIdPruebaProgramaUsuario()
                : null);

            return pruebaProgramaUsuarioPreguntaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPreguntaDTOToPruebaProgramaUsuarioPregunta(
        PruebaProgramaUsuarioPreguntaDTO pruebaProgramaUsuarioPreguntaDTO)
        throws Exception {
        try {
            PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta = new PruebaProgramaUsuarioPregunta();

            pruebaProgramaUsuarioPregunta.setIdPruebaProgramaUsuarioPregunta(pruebaProgramaUsuarioPreguntaDTO.getIdPruebaProgramaUsuarioPregunta());
            pruebaProgramaUsuarioPregunta.setActivo((pruebaProgramaUsuarioPreguntaDTO.getActivo() != null)
                ? pruebaProgramaUsuarioPreguntaDTO.getActivo() : null);
            pruebaProgramaUsuarioPregunta.setFechaCreacion(pruebaProgramaUsuarioPreguntaDTO.getFechaCreacion());
            pruebaProgramaUsuarioPregunta.setFechaModificacion(pruebaProgramaUsuarioPreguntaDTO.getFechaModificacion());
            pruebaProgramaUsuarioPregunta.setUsuCreador((pruebaProgramaUsuarioPreguntaDTO.getUsuCreador() != null)
                ? pruebaProgramaUsuarioPreguntaDTO.getUsuCreador() : null);
            pruebaProgramaUsuarioPregunta.setUsuModificador((pruebaProgramaUsuarioPreguntaDTO.getUsuModificador() != null)
                ? pruebaProgramaUsuarioPreguntaDTO.getUsuModificador() : null);

            Pregunta pregunta = new Pregunta();

            if (pruebaProgramaUsuarioPreguntaDTO.getIdPregunta_Pregunta() != null) {
                pregunta = logicPregunta1.getPregunta(pruebaProgramaUsuarioPreguntaDTO.getIdPregunta_Pregunta());
            }

            if (pregunta != null) {
                pruebaProgramaUsuarioPregunta.setPregunta(pregunta);
            }

            PruebaProgramaUsuario pruebaProgramaUsuario = new PruebaProgramaUsuario();

            if (pruebaProgramaUsuarioPreguntaDTO.getIdPruebaProgramaUsuario_PruebaProgramaUsuario() != null) {
                pruebaProgramaUsuario = logicPruebaProgramaUsuario2.getPruebaProgramaUsuario(pruebaProgramaUsuarioPreguntaDTO.getIdPruebaProgramaUsuario_PruebaProgramaUsuario());
            }

            if (pruebaProgramaUsuario != null) {
                pruebaProgramaUsuarioPregunta.setPruebaProgramaUsuario(pruebaProgramaUsuario);
            }

            return pruebaProgramaUsuarioPregunta;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PruebaProgramaUsuarioPreguntaDTO> listPruebaProgramaUsuarioPreguntaToListPruebaProgramaUsuarioPreguntaDTO(
        List<PruebaProgramaUsuarioPregunta> listPruebaProgramaUsuarioPregunta)
        throws Exception {
        try {
            List<PruebaProgramaUsuarioPreguntaDTO> pruebaProgramaUsuarioPreguntaDTOs =
                new ArrayList<PruebaProgramaUsuarioPreguntaDTO>();

            for (PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta : listPruebaProgramaUsuarioPregunta) {
                PruebaProgramaUsuarioPreguntaDTO pruebaProgramaUsuarioPreguntaDTO =
                    pruebaProgramaUsuarioPreguntaToPruebaProgramaUsuarioPreguntaDTO(pruebaProgramaUsuarioPregunta);

                pruebaProgramaUsuarioPreguntaDTOs.add(pruebaProgramaUsuarioPreguntaDTO);
            }

            return pruebaProgramaUsuarioPreguntaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PruebaProgramaUsuarioPregunta> listPruebaProgramaUsuarioPreguntaDTOToListPruebaProgramaUsuarioPregunta(
        List<PruebaProgramaUsuarioPreguntaDTO> listPruebaProgramaUsuarioPreguntaDTO)
        throws Exception {
        try {
            List<PruebaProgramaUsuarioPregunta> listPruebaProgramaUsuarioPregunta =
                new ArrayList<PruebaProgramaUsuarioPregunta>();

            for (PruebaProgramaUsuarioPreguntaDTO pruebaProgramaUsuarioPreguntaDTO : listPruebaProgramaUsuarioPreguntaDTO) {
                PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta = pruebaProgramaUsuarioPreguntaDTOToPruebaProgramaUsuarioPregunta(pruebaProgramaUsuarioPreguntaDTO);

                listPruebaProgramaUsuarioPregunta.add(pruebaProgramaUsuarioPregunta);
            }

            return listPruebaProgramaUsuarioPregunta;
        } catch (Exception e) {
            throw e;
        }
    }
}
