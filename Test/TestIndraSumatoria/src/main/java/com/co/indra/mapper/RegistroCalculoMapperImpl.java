package com.co.indra.mapper;

import com.co.indra.dto.RegistroCalculoDTO;
import com.co.indra.model.*;
import com.co.indra.model.RegistroCalculo;
import com.co.indra.service.*;

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
public class RegistroCalculoMapperImpl implements RegistroCalculoMapper {
    private static final Logger log = LoggerFactory.getLogger(RegistroCalculoMapperImpl.class);

    /**
    * Service injected by Spring that manages Usuarios entities
    *
    */
    @Autowired
    UsuariosService serviceUsuarios1;

    @Transactional(readOnly = true)
    public RegistroCalculoDTO registroCalculoToRegistroCalculoDTO(
        RegistroCalculo registroCalculo) throws Exception {
        try {
            RegistroCalculoDTO registroCalculoDTO = new RegistroCalculoDTO();

            registroCalculoDTO.setIdResultado(registroCalculo.getIdResultado());
            registroCalculoDTO.setFechaEjecucion(registroCalculo.getFechaEjecucion());
            registroCalculoDTO.setResultado((registroCalculo.getResultado() != null)
                ? registroCalculo.getResultado() : null);
            registroCalculoDTO.setIdUsuario_Usuarios((registroCalculo.getUsuarios()
                                                                     .getIdUsuario() != null)
                ? registroCalculo.getUsuarios().getIdUsuario() : null);
            registroCalculoDTO.setName(registroCalculo.getUsuarios().getName());
            return registroCalculoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public RegistroCalculo registroCalculoDTOToRegistroCalculo(
        RegistroCalculoDTO registroCalculoDTO) throws Exception {
        try {
            RegistroCalculo registroCalculo = new RegistroCalculo();

            registroCalculo.setIdResultado(registroCalculoDTO.getIdResultado());
            registroCalculo.setFechaEjecucion(registroCalculoDTO.getFechaEjecucion());
            registroCalculo.setResultado((registroCalculoDTO.getResultado() != null)
                ? registroCalculoDTO.getResultado() : null);

            Usuarios usuarios = new Usuarios();

            if (registroCalculoDTO.getIdUsuario_Usuarios() != null) {
                usuarios = serviceUsuarios1.getUsuarios(registroCalculoDTO.getIdUsuario_Usuarios());
            }

            if (usuarios != null) {
                registroCalculo.setUsuarios(usuarios);
            }

            return registroCalculo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RegistroCalculoDTO> listRegistroCalculoToListRegistroCalculoDTO(
        List<RegistroCalculo> listRegistroCalculo) throws Exception {
        try {
            List<RegistroCalculoDTO> registroCalculoDTOs = new ArrayList<RegistroCalculoDTO>();

            for (RegistroCalculo registroCalculo : listRegistroCalculo) {
                RegistroCalculoDTO registroCalculoDTO = registroCalculoToRegistroCalculoDTO(registroCalculo);

                registroCalculoDTOs.add(registroCalculoDTO);
            }

            return registroCalculoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RegistroCalculo> listRegistroCalculoDTOToListRegistroCalculo(
        List<RegistroCalculoDTO> listRegistroCalculoDTO)
        throws Exception {
        try {
            List<RegistroCalculo> listRegistroCalculo = new ArrayList<RegistroCalculo>();

            for (RegistroCalculoDTO registroCalculoDTO : listRegistroCalculoDTO) {
                RegistroCalculo registroCalculo = registroCalculoDTOToRegistroCalculo(registroCalculoDTO);

                listRegistroCalculo.add(registroCalculo);
            }

            return listRegistroCalculo;
        } catch (Exception e) {
            throw e;
        }
    }
}
