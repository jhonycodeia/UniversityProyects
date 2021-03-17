package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.ProgramaUsuario;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.ProgramaUsuarioDTO;

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
public class ProgramaUsuarioMapper implements IProgramaUsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(ProgramaUsuarioMapper.class);

    /**
    * Logic injected by Spring that manages Programa entities
    *
    */
    @Autowired
    IProgramaLogic logicPrograma1;

    /**
    * Logic injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    IUsuarioLogic logicUsuario2;

    @Transactional(readOnly = true)
    public ProgramaUsuarioDTO programaUsuarioToProgramaUsuarioDTO(
        ProgramaUsuario programaUsuario) throws Exception {
        try {
            ProgramaUsuarioDTO programaUsuarioDTO = new ProgramaUsuarioDTO();

            programaUsuarioDTO.setIdProgramaUsuario(programaUsuario.getIdProgramaUsuario());
            programaUsuarioDTO.setActivo((programaUsuario.getActivo() != null)
                ? programaUsuario.getActivo() : null);
            programaUsuarioDTO.setFechaCreacion(programaUsuario.getFechaCreacion());
            programaUsuarioDTO.setFechaModificacion(programaUsuario.getFechaModificacion());
            programaUsuarioDTO.setUsuCreador((programaUsuario.getUsuCreador() != null)
                ? programaUsuario.getUsuCreador() : null);
            programaUsuarioDTO.setUsuModificador((programaUsuario.getUsuModificador() != null)
                ? programaUsuario.getUsuModificador() : null);
            programaUsuarioDTO.setIdPrograma_Programa((programaUsuario.getPrograma()
                                                                      .getIdPrograma() != null)
                ? programaUsuario.getPrograma().getIdPrograma() : null);
            programaUsuarioDTO.setIdUsuario_Usuario((programaUsuario.getUsuario()
                                                                    .getIdUsuario() != null)
                ? programaUsuario.getUsuario().getIdUsuario() : null);

            return programaUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public ProgramaUsuario programaUsuarioDTOToProgramaUsuario(
        ProgramaUsuarioDTO programaUsuarioDTO) throws Exception {
        try {
            ProgramaUsuario programaUsuario = new ProgramaUsuario();

            programaUsuario.setIdProgramaUsuario(programaUsuarioDTO.getIdProgramaUsuario());
            programaUsuario.setActivo((programaUsuarioDTO.getActivo() != null)
                ? programaUsuarioDTO.getActivo() : null);
            programaUsuario.setFechaCreacion(programaUsuarioDTO.getFechaCreacion());
            programaUsuario.setFechaModificacion(programaUsuarioDTO.getFechaModificacion());
            programaUsuario.setUsuCreador((programaUsuarioDTO.getUsuCreador() != null)
                ? programaUsuarioDTO.getUsuCreador() : null);
            programaUsuario.setUsuModificador((programaUsuarioDTO.getUsuModificador() != null)
                ? programaUsuarioDTO.getUsuModificador() : null);

            Programa programa = new Programa();

            if (programaUsuarioDTO.getIdPrograma_Programa() != null) {
                programa = logicPrograma1.getPrograma(programaUsuarioDTO.getIdPrograma_Programa());
            }

            if (programa != null) {
                programaUsuario.setPrograma(programa);
            }

            Usuario usuario = new Usuario();

            if (programaUsuarioDTO.getIdUsuario_Usuario() != null) {
                usuario = logicUsuario2.getUsuario(programaUsuarioDTO.getIdUsuario_Usuario());
            }

            if (usuario != null) {
                programaUsuario.setUsuario(usuario);
            }

            return programaUsuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProgramaUsuarioDTO> listProgramaUsuarioToListProgramaUsuarioDTO(
        List<ProgramaUsuario> listProgramaUsuario) throws Exception {
        try {
            List<ProgramaUsuarioDTO> programaUsuarioDTOs = new ArrayList<ProgramaUsuarioDTO>();

            for (ProgramaUsuario programaUsuario : listProgramaUsuario) {
                ProgramaUsuarioDTO programaUsuarioDTO = programaUsuarioToProgramaUsuarioDTO(programaUsuario);

                programaUsuarioDTOs.add(programaUsuarioDTO);
            }

            return programaUsuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProgramaUsuario> listProgramaUsuarioDTOToListProgramaUsuario(
        List<ProgramaUsuarioDTO> listProgramaUsuarioDTO)
        throws Exception {
        try {
            List<ProgramaUsuario> listProgramaUsuario = new ArrayList<ProgramaUsuario>();

            for (ProgramaUsuarioDTO programaUsuarioDTO : listProgramaUsuarioDTO) {
                ProgramaUsuario programaUsuario = programaUsuarioDTOToProgramaUsuario(programaUsuarioDTO);

                listProgramaUsuario.add(programaUsuario);
            }

            return listProgramaUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
