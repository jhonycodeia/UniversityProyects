package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.ProgramaModulo;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.ProgramaModuloDTO;

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
public class ProgramaModuloMapper implements IProgramaModuloMapper {
    private static final Logger log = LoggerFactory.getLogger(ProgramaModuloMapper.class);

    /**
    * Logic injected by Spring that manages Modulo entities
    *
    */
    @Autowired
    IModuloLogic logicModulo1;

    /**
    * Logic injected by Spring that manages Programa entities
    *
    */
    @Autowired
    IProgramaLogic logicPrograma2;

    @Transactional(readOnly = true)
    public ProgramaModuloDTO programaModuloToProgramaModuloDTO(
        ProgramaModulo programaModulo) throws Exception {
        try {
            ProgramaModuloDTO programaModuloDTO = new ProgramaModuloDTO();

            programaModuloDTO.setIdProgramaModulo(programaModulo.getIdProgramaModulo());
            programaModuloDTO.setActivo((programaModulo.getActivo() != null)
                ? programaModulo.getActivo() : null);
            programaModuloDTO.setFechaCreacion(programaModulo.getFechaCreacion());
            programaModuloDTO.setFechaModificacion(programaModulo.getFechaModificacion());
            programaModuloDTO.setUsuCreador((programaModulo.getUsuCreador() != null)
                ? programaModulo.getUsuCreador() : null);
            programaModuloDTO.setUsuModificador((programaModulo.getUsuModificador() != null)
                ? programaModulo.getUsuModificador() : null);
            programaModuloDTO.setIdModulo_Modulo((programaModulo.getModulo()
                                                                .getIdModulo() != null)
                ? programaModulo.getModulo().getIdModulo() : null);
            programaModuloDTO.setIdPrograma_Programa((programaModulo.getPrograma()
                                                                    .getIdPrograma() != null)
                ? programaModulo.getPrograma().getIdPrograma() : null);

            return programaModuloDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public ProgramaModulo programaModuloDTOToProgramaModulo(
        ProgramaModuloDTO programaModuloDTO) throws Exception {
        try {
            ProgramaModulo programaModulo = new ProgramaModulo();

            programaModulo.setIdProgramaModulo(programaModuloDTO.getIdProgramaModulo());
            programaModulo.setActivo((programaModuloDTO.getActivo() != null)
                ? programaModuloDTO.getActivo() : null);
            programaModulo.setFechaCreacion(programaModuloDTO.getFechaCreacion());
            programaModulo.setFechaModificacion(programaModuloDTO.getFechaModificacion());
            programaModulo.setUsuCreador((programaModuloDTO.getUsuCreador() != null)
                ? programaModuloDTO.getUsuCreador() : null);
            programaModulo.setUsuModificador((programaModuloDTO.getUsuModificador() != null)
                ? programaModuloDTO.getUsuModificador() : null);

            Modulo modulo = new Modulo();

            if (programaModuloDTO.getIdModulo_Modulo() != null) {
                modulo = logicModulo1.getModulo(programaModuloDTO.getIdModulo_Modulo());
            }

            if (modulo != null) {
                programaModulo.setModulo(modulo);
            }

            Programa programa = new Programa();

            if (programaModuloDTO.getIdPrograma_Programa() != null) {
                programa = logicPrograma2.getPrograma(programaModuloDTO.getIdPrograma_Programa());
            }

            if (programa != null) {
                programaModulo.setPrograma(programa);
            }

            return programaModulo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProgramaModuloDTO> listProgramaModuloToListProgramaModuloDTO(
        List<ProgramaModulo> listProgramaModulo) throws Exception {
        try {
            List<ProgramaModuloDTO> programaModuloDTOs = new ArrayList<ProgramaModuloDTO>();

            for (ProgramaModulo programaModulo : listProgramaModulo) {
                ProgramaModuloDTO programaModuloDTO = programaModuloToProgramaModuloDTO(programaModulo);

                programaModuloDTOs.add(programaModuloDTO);
            }

            return programaModuloDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProgramaModulo> listProgramaModuloDTOToListProgramaModulo(
        List<ProgramaModuloDTO> listProgramaModuloDTO)
        throws Exception {
        try {
            List<ProgramaModulo> listProgramaModulo = new ArrayList<ProgramaModulo>();

            for (ProgramaModuloDTO programaModuloDTO : listProgramaModuloDTO) {
                ProgramaModulo programaModulo = programaModuloDTOToProgramaModulo(programaModuloDTO);

                listProgramaModulo.add(programaModulo);
            }

            return listProgramaModulo;
        } catch (Exception e) {
            throw e;
        }
    }
}
