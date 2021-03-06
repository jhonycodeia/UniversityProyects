package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.Programa;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.ProgramaDTO;

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
public class ProgramaMapper implements IProgramaMapper {
    private static final Logger log = LoggerFactory.getLogger(ProgramaMapper.class);

    /**
    * Logic injected by Spring that manages Facultad entities
    *
    */
    @Autowired
    IFacultadLogic logicFacultad1;

    @Transactional(readOnly = true)
    public ProgramaDTO programaToProgramaDTO(Programa programa)
        throws Exception {
        try {
            ProgramaDTO programaDTO = new ProgramaDTO();

            programaDTO.setIdPrograma(programa.getIdPrograma());
            programaDTO.setActivo((programa.getActivo() != null)
                ? programa.getActivo() : null);
            programaDTO.setDescripcion((programa.getDescripcion() != null)
                ? programa.getDescripcion() : null);
            programaDTO.setFechaCreacion(programa.getFechaCreacion());
            programaDTO.setFechaModificacion(programa.getFechaModificacion());
            programaDTO.setNombre((programa.getNombre() != null)
                ? programa.getNombre() : null);
            programaDTO.setUsuCreador((programa.getUsuCreador() != null)
                ? programa.getUsuCreador() : null);
            programaDTO.setUsuModificador((programa.getUsuModificador() != null)
                ? programa.getUsuModificador() : null);
            programaDTO.setIdFacultad_Facultad((programa.getFacultad()
                                                        .getIdFacultad() != null)
                ? programa.getFacultad().getIdFacultad() : null);

            return programaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Programa programaDTOToPrograma(ProgramaDTO programaDTO)
        throws Exception {
        try {
            Programa programa = new Programa();

            programa.setIdPrograma(programaDTO.getIdPrograma());
            programa.setActivo((programaDTO.getActivo() != null)
                ? programaDTO.getActivo() : null);
            programa.setDescripcion((programaDTO.getDescripcion() != null)
                ? programaDTO.getDescripcion() : null);
            programa.setFechaCreacion(programaDTO.getFechaCreacion());
            programa.setFechaModificacion(programaDTO.getFechaModificacion());
            programa.setNombre((programaDTO.getNombre() != null)
                ? programaDTO.getNombre() : null);
            programa.setUsuCreador((programaDTO.getUsuCreador() != null)
                ? programaDTO.getUsuCreador() : null);
            programa.setUsuModificador((programaDTO.getUsuModificador() != null)
                ? programaDTO.getUsuModificador() : null);

            Facultad facultad = new Facultad();

            if (programaDTO.getIdFacultad_Facultad() != null) {
                facultad = logicFacultad1.getFacultad(programaDTO.getIdFacultad_Facultad());
            }

            if (facultad != null) {
                programa.setFacultad(facultad);
            }

            return programa;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProgramaDTO> listProgramaToListProgramaDTO(
        List<Programa> listPrograma) throws Exception {
        try {
            List<ProgramaDTO> programaDTOs = new ArrayList<ProgramaDTO>();

            for (Programa programa : listPrograma) {
                ProgramaDTO programaDTO = programaToProgramaDTO(programa);

                programaDTOs.add(programaDTO);
            }

            return programaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Programa> listProgramaDTOToListPrograma(
        List<ProgramaDTO> listProgramaDTO) throws Exception {
        try {
            List<Programa> listPrograma = new ArrayList<Programa>();

            for (ProgramaDTO programaDTO : listProgramaDTO) {
                Programa programa = programaDTOToPrograma(programaDTO);

                listPrograma.add(programa);
            }

            return listPrograma;
        } catch (Exception e) {
            throw e;
        }
    }
}
