package com.green.mapper;

import com.green.dto.UsuarioTrofeoDTO;

import com.green.modelo.*;
import com.green.modelo.UsuarioTrofeo;

import com.green.service.*;

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
public class UsuarioTrofeoMapperImpl implements UsuarioTrofeoMapper {
    private static final Logger log = LoggerFactory.getLogger(UsuarioTrofeoMapperImpl.class);

    /**
    * Service injected by Spring that manages Trofeo entities
    *
    */
    @Autowired
    TrofeoService serviceTrofeo1;

    /**
    * Service injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    UsuarioService serviceUsuario2;

    @Transactional(readOnly = true)
    public UsuarioTrofeoDTO usuarioTrofeoToUsuarioTrofeoDTO(
        UsuarioTrofeo usuarioTrofeo) throws Exception {
        try {
            UsuarioTrofeoDTO usuarioTrofeoDTO = new UsuarioTrofeoDTO();

            usuarioTrofeoDTO.setIdUsuarioTrofeo(usuarioTrofeo.getIdUsuarioTrofeo());
            usuarioTrofeoDTO.setActivo((usuarioTrofeo.getActivo() != null)
                ? usuarioTrofeo.getActivo() : null);
            usuarioTrofeoDTO.setFechaCreacion(usuarioTrofeo.getFechaCreacion());
            usuarioTrofeoDTO.setFechaModificacion(usuarioTrofeo.getFechaModificacion());
            usuarioTrofeoDTO.setUsuCreador((usuarioTrofeo.getUsuCreador() != null)
                ? usuarioTrofeo.getUsuCreador() : null);
            usuarioTrofeoDTO.setUsuModificador((usuarioTrofeo.getUsuModificador() != null)
                ? usuarioTrofeo.getUsuModificador() : null);
            usuarioTrofeoDTO.setIdTrofeo_Trofeo((usuarioTrofeo.getTrofeo()
                                                              .getIdTrofeo() != null)
                ? usuarioTrofeo.getTrofeo().getIdTrofeo() : null);
            usuarioTrofeoDTO.setIdUsuario_Usuario((usuarioTrofeo.getUsuario()
                                                                .getIdUsuario() != null)
                ? usuarioTrofeo.getUsuario().getIdUsuario() : null);

            return usuarioTrofeoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public UsuarioTrofeo usuarioTrofeoDTOToUsuarioTrofeo(
        UsuarioTrofeoDTO usuarioTrofeoDTO) throws Exception {
        try {
            UsuarioTrofeo usuarioTrofeo = new UsuarioTrofeo();

            usuarioTrofeo.setIdUsuarioTrofeo(usuarioTrofeoDTO.getIdUsuarioTrofeo());
            usuarioTrofeo.setActivo((usuarioTrofeoDTO.getActivo() != null)
                ? usuarioTrofeoDTO.getActivo() : null);
            usuarioTrofeo.setFechaCreacion(usuarioTrofeoDTO.getFechaCreacion());
            usuarioTrofeo.setFechaModificacion(usuarioTrofeoDTO.getFechaModificacion());
            usuarioTrofeo.setUsuCreador((usuarioTrofeoDTO.getUsuCreador() != null)
                ? usuarioTrofeoDTO.getUsuCreador() : null);
            usuarioTrofeo.setUsuModificador((usuarioTrofeoDTO.getUsuModificador() != null)
                ? usuarioTrofeoDTO.getUsuModificador() : null);

            Trofeo trofeo = new Trofeo();

            if (usuarioTrofeoDTO.getIdTrofeo_Trofeo() != null) {
                trofeo = serviceTrofeo1.getTrofeo(usuarioTrofeoDTO.getIdTrofeo_Trofeo());
            }

            if (trofeo != null) {
                usuarioTrofeo.setTrofeo(trofeo);
            }

            Usuario usuario = new Usuario();

            if (usuarioTrofeoDTO.getIdUsuario_Usuario() != null) {
                usuario = serviceUsuario2.getUsuario(usuarioTrofeoDTO.getIdUsuario_Usuario());
            }

            if (usuario != null) {
                usuarioTrofeo.setUsuario(usuario);
            }

            return usuarioTrofeo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<UsuarioTrofeoDTO> listUsuarioTrofeoToListUsuarioTrofeoDTO(
        List<UsuarioTrofeo> listUsuarioTrofeo) throws Exception {
        try {
            List<UsuarioTrofeoDTO> usuarioTrofeoDTOs = new ArrayList<UsuarioTrofeoDTO>();

            for (UsuarioTrofeo usuarioTrofeo : listUsuarioTrofeo) {
                UsuarioTrofeoDTO usuarioTrofeoDTO = usuarioTrofeoToUsuarioTrofeoDTO(usuarioTrofeo);

                usuarioTrofeoDTOs.add(usuarioTrofeoDTO);
            }

            return usuarioTrofeoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<UsuarioTrofeo> listUsuarioTrofeoDTOToListUsuarioTrofeo(
        List<UsuarioTrofeoDTO> listUsuarioTrofeoDTO) throws Exception {
        try {
            List<UsuarioTrofeo> listUsuarioTrofeo = new ArrayList<UsuarioTrofeo>();

            for (UsuarioTrofeoDTO usuarioTrofeoDTO : listUsuarioTrofeoDTO) {
                UsuarioTrofeo usuarioTrofeo = usuarioTrofeoDTOToUsuarioTrofeo(usuarioTrofeoDTO);

                listUsuarioTrofeo.add(usuarioTrofeo);
            }

            return listUsuarioTrofeo;
        } catch (Exception e) {
            throw e;
        }
    }
}
