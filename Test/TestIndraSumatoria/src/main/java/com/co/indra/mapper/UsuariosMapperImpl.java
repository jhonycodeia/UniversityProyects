package com.co.indra.mapper;

import com.co.indra.dto.UsuariosDTO;
import com.co.indra.model.*;
import com.co.indra.model.Usuarios;
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
public class UsuariosMapperImpl implements UsuariosMapper {
    private static final Logger log = LoggerFactory.getLogger(UsuariosMapperImpl.class);

    @Transactional(readOnly = true)
    public UsuariosDTO usuariosToUsuariosDTO(Usuarios usuarios)
        throws Exception {
        try {
            UsuariosDTO usuariosDTO = new UsuariosDTO();

            usuariosDTO.setIdUsuario(usuarios.getIdUsuario());
            usuariosDTO.setName((usuarios.getName() != null)
                ? usuarios.getName() : null);

            return usuariosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Usuarios usuariosDTOToUsuarios(UsuariosDTO usuariosDTO)
        throws Exception {
        try {
            Usuarios usuarios = new Usuarios();

            usuarios.setIdUsuario(usuariosDTO.getIdUsuario());
            usuarios.setName((usuariosDTO.getName() != null)
                ? usuariosDTO.getName() : null);

            return usuarios;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<UsuariosDTO> listUsuariosToListUsuariosDTO(
        List<Usuarios> listUsuarios) throws Exception {
        try {
            List<UsuariosDTO> usuariosDTOs = new ArrayList<UsuariosDTO>();

            for (Usuarios usuarios : listUsuarios) {
                UsuariosDTO usuariosDTO = usuariosToUsuariosDTO(usuarios);

                usuariosDTOs.add(usuariosDTO);
            }

            return usuariosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Usuarios> listUsuariosDTOToListUsuarios(
        List<UsuariosDTO> listUsuariosDTO) throws Exception {
        try {
            List<Usuarios> listUsuarios = new ArrayList<Usuarios>();

            for (UsuariosDTO usuariosDTO : listUsuariosDTO) {
                Usuarios usuarios = usuariosDTOToUsuarios(usuariosDTO);

                listUsuarios.add(usuarios);
            }

            return listUsuarios;
        } catch (Exception e) {
            throw e;
        }
    }
}
