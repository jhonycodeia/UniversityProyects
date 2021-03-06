package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.PruebaProgramaUsuario;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.PruebaProgramaUsuarioDTO;

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
public class PruebaProgramaUsuarioMapper implements IPruebaProgramaUsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(PruebaProgramaUsuarioMapper.class);

    /**
    * Logic injected by Spring that manages EstadoPrueba entities
    *
    */
    @Autowired
    IEstadoPruebaLogic logicEstadoPrueba1;

    /**
    * Logic injected by Spring that manages ProgramaUsuario entities
    *
    */
    @Autowired
    IProgramaUsuarioLogic logicProgramaUsuario2;

    /**
    * Logic injected by Spring that manages Prueba entities
    *
    */
    @Autowired
    IPruebaLogic logicPrueba3;

    @Transactional(readOnly = true)
    public PruebaProgramaUsuarioDTO pruebaProgramaUsuarioToPruebaProgramaUsuarioDTO(
        PruebaProgramaUsuario pruebaProgramaUsuario) throws Exception {
        try {
            PruebaProgramaUsuarioDTO pruebaProgramaUsuarioDTO = new PruebaProgramaUsuarioDTO();

            pruebaProgramaUsuarioDTO.setIdPruebaProgramaUsuario(pruebaProgramaUsuario.getIdPruebaProgramaUsuario());
            pruebaProgramaUsuarioDTO.setActivo((pruebaProgramaUsuario.getActivo() != null)
                ? pruebaProgramaUsuario.getActivo() : null);
            pruebaProgramaUsuarioDTO.setFechaCreacion(pruebaProgramaUsuario.getFechaCreacion());
            pruebaProgramaUsuarioDTO.setFechaModificacion(pruebaProgramaUsuario.getFechaModificacion());
            pruebaProgramaUsuarioDTO.setUsuCreador((pruebaProgramaUsuario.getUsuCreador() != null)
                ? pruebaProgramaUsuario.getUsuCreador() : null);
            pruebaProgramaUsuarioDTO.setUsuModificador((pruebaProgramaUsuario.getUsuModificador() != null)
                ? pruebaProgramaUsuario.getUsuModificador() : null);
            pruebaProgramaUsuarioDTO.setIdEstadoPrueba_EstadoPrueba((pruebaProgramaUsuario.getEstadoPrueba()
                                                                                          .getIdEstadoPrueba() != null)
                ? pruebaProgramaUsuario.getEstadoPrueba().getIdEstadoPrueba()
                : null);
            pruebaProgramaUsuarioDTO.setIdProgramaUsuario_ProgramaUsuario((pruebaProgramaUsuario.getProgramaUsuario()
                                                                                                .getIdProgramaUsuario() != null)
                ? pruebaProgramaUsuario.getProgramaUsuario()
                                       .getIdProgramaUsuario() : null);
            pruebaProgramaUsuarioDTO.setIdPrueba_Prueba((pruebaProgramaUsuario.getPrueba()
                                                                              .getIdPrueba() != null)
                ? pruebaProgramaUsuario.getPrueba().getIdPrueba() : null);

            return pruebaProgramaUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public PruebaProgramaUsuario pruebaProgramaUsuarioDTOToPruebaProgramaUsuario(
        PruebaProgramaUsuarioDTO pruebaProgramaUsuarioDTO)
        throws Exception {
        try {
            PruebaProgramaUsuario pruebaProgramaUsuario = new PruebaProgramaUsuario();

            pruebaProgramaUsuario.setIdPruebaProgramaUsuario(pruebaProgramaUsuarioDTO.getIdPruebaProgramaUsuario());
            pruebaProgramaUsuario.setActivo((pruebaProgramaUsuarioDTO.getActivo() != null)
                ? pruebaProgramaUsuarioDTO.getActivo() : null);
            pruebaProgramaUsuario.setFechaCreacion(pruebaProgramaUsuarioDTO.getFechaCreacion());
            pruebaProgramaUsuario.setFechaModificacion(pruebaProgramaUsuarioDTO.getFechaModificacion());
            pruebaProgramaUsuario.setUsuCreador((pruebaProgramaUsuarioDTO.getUsuCreador() != null)
                ? pruebaProgramaUsuarioDTO.getUsuCreador() : null);
            pruebaProgramaUsuario.setUsuModificador((pruebaProgramaUsuarioDTO.getUsuModificador() != null)
                ? pruebaProgramaUsuarioDTO.getUsuModificador() : null);

            EstadoPrueba estadoPrueba = new EstadoPrueba();

            if (pruebaProgramaUsuarioDTO.getIdEstadoPrueba_EstadoPrueba() != null) {
                estadoPrueba = logicEstadoPrueba1.getEstadoPrueba(pruebaProgramaUsuarioDTO.getIdEstadoPrueba_EstadoPrueba());
            }

            if (estadoPrueba != null) {
                pruebaProgramaUsuario.setEstadoPrueba(estadoPrueba);
            }

            ProgramaUsuario programaUsuario = new ProgramaUsuario();

            if (pruebaProgramaUsuarioDTO.getIdProgramaUsuario_ProgramaUsuario() != null) {
                programaUsuario = logicProgramaUsuario2.getProgramaUsuario(pruebaProgramaUsuarioDTO.getIdProgramaUsuario_ProgramaUsuario());
            }

            if (programaUsuario != null) {
                pruebaProgramaUsuario.setProgramaUsuario(programaUsuario);
            }

            Prueba prueba = new Prueba();

            if (pruebaProgramaUsuarioDTO.getIdPrueba_Prueba() != null) {
                prueba = logicPrueba3.getPrueba(pruebaProgramaUsuarioDTO.getIdPrueba_Prueba());
            }

            if (prueba != null) {
                pruebaProgramaUsuario.setPrueba(prueba);
            }

            return pruebaProgramaUsuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PruebaProgramaUsuarioDTO> listPruebaProgramaUsuarioToListPruebaProgramaUsuarioDTO(
        List<PruebaProgramaUsuario> listPruebaProgramaUsuario)
        throws Exception {
        try {
            List<PruebaProgramaUsuarioDTO> pruebaProgramaUsuarioDTOs = new ArrayList<PruebaProgramaUsuarioDTO>();

            for (PruebaProgramaUsuario pruebaProgramaUsuario : listPruebaProgramaUsuario) {
                PruebaProgramaUsuarioDTO pruebaProgramaUsuarioDTO = pruebaProgramaUsuarioToPruebaProgramaUsuarioDTO(pruebaProgramaUsuario);

                pruebaProgramaUsuarioDTOs.add(pruebaProgramaUsuarioDTO);
            }

            return pruebaProgramaUsuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PruebaProgramaUsuario> listPruebaProgramaUsuarioDTOToListPruebaProgramaUsuario(
        List<PruebaProgramaUsuarioDTO> listPruebaProgramaUsuarioDTO)
        throws Exception {
        try {
            List<PruebaProgramaUsuario> listPruebaProgramaUsuario = new ArrayList<PruebaProgramaUsuario>();

            for (PruebaProgramaUsuarioDTO pruebaProgramaUsuarioDTO : listPruebaProgramaUsuarioDTO) {
                PruebaProgramaUsuario pruebaProgramaUsuario = pruebaProgramaUsuarioDTOToPruebaProgramaUsuario(pruebaProgramaUsuarioDTO);

                listPruebaProgramaUsuario.add(pruebaProgramaUsuario);
            }

            return listPruebaProgramaUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
