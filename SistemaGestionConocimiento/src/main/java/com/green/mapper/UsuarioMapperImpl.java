package com.green.mapper;

import com.green.dto.UsuarioDTO;

import com.green.modelo.*;
import com.green.modelo.Usuario;

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
public class UsuarioMapperImpl implements UsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(UsuarioMapperImpl.class);

    /**
    * Service injected by Spring that manages Area entities
    *
    */
    @Autowired
    AreaService serviceArea1;

    /**
    * Service injected by Spring that manages TipoUsuario entities
    *
    */
    @Autowired
    TipoUsuarioService serviceTipoUsuario2;

    @Transactional(readOnly = true)
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario)
        throws Exception {
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();

            usuarioDTO.setIdUsuario(usuario.getIdUsuario());
            usuarioDTO.setActivo((usuario.getActivo() != null)
                ? usuario.getActivo() : null);
            usuarioDTO.setApellido((usuario.getApellido() != null)
                ? usuario.getApellido() : null);
            usuarioDTO.setClave((usuario.getClave() != null)
                ? usuario.getClave() : null);
            usuarioDTO.setCorreo((usuario.getCorreo() != null)
                ? usuario.getCorreo() : null);
            usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
            usuarioDTO.setFechaModificacion(usuario.getFechaModificacion());
            usuarioDTO.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioDTO.setGenero((usuario.getGenero() != null)
                ? usuario.getGenero() : null);
            usuarioDTO.setNombre((usuario.getNombre() != null)
                ? usuario.getNombre() : null);
            usuarioDTO.setPuntos((usuario.getPuntos() != null)
                ? usuario.getPuntos() : null);
            usuarioDTO.setUsuCreador((usuario.getUsuCreador() != null)
                ? usuario.getUsuCreador() : null);
            usuarioDTO.setUsuModificador((usuario.getUsuModificador() != null)
                ? usuario.getUsuModificador() : null);
            usuarioDTO.setIdArea_Area((usuario.getArea().getIdArea() != null)
                ? usuario.getArea().getIdArea() : null);
            usuarioDTO.setIdTipoUsuario_TipoUsuario((usuario.getTipoUsuario()
                                                            .getIdTipoUsuario() != null)
                ? usuario.getTipoUsuario().getIdTipoUsuario() : null);

            return usuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO)
        throws Exception {
        try {
            Usuario usuario = new Usuario();

            usuario.setIdUsuario(usuarioDTO.getIdUsuario());
            usuario.setActivo((usuarioDTO.getActivo() != null)
                ? usuarioDTO.getActivo() : null);
            usuario.setApellido((usuarioDTO.getApellido() != null)
                ? usuarioDTO.getApellido() : null);
            usuario.setClave((usuarioDTO.getClave() != null)
                ? usuarioDTO.getClave() : null);
            usuario.setCorreo((usuarioDTO.getCorreo() != null)
                ? usuarioDTO.getCorreo() : null);
            usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
            usuario.setFechaModificacion(usuarioDTO.getFechaModificacion());
            usuario.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
            usuario.setGenero((usuarioDTO.getGenero() != null)
                ? usuarioDTO.getGenero() : null);
            usuario.setNombre((usuarioDTO.getNombre() != null)
                ? usuarioDTO.getNombre() : null);
            usuario.setPuntos((usuarioDTO.getPuntos() != null)
                ? usuarioDTO.getPuntos() : null);
            usuario.setUsuCreador((usuarioDTO.getUsuCreador() != null)
                ? usuarioDTO.getUsuCreador() : null);
            usuario.setUsuModificador((usuarioDTO.getUsuModificador() != null)
                ? usuarioDTO.getUsuModificador() : null);

            Area area = new Area();

            if (usuarioDTO.getIdArea_Area() != null) {
                area = serviceArea1.getArea(usuarioDTO.getIdArea_Area());
            }

            if (area != null) {
                usuario.setArea(area);
            }

            TipoUsuario tipoUsuario = new TipoUsuario();

            if (usuarioDTO.getIdTipoUsuario_TipoUsuario() != null) {
                tipoUsuario = serviceTipoUsuario2.getTipoUsuario(usuarioDTO.getIdTipoUsuario_TipoUsuario());
            }

            if (tipoUsuario != null) {
                usuario.setTipoUsuario(tipoUsuario);
            }

            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> listUsuarioToListUsuarioDTO(
        List<Usuario> listUsuario) throws Exception {
        try {
            List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();

            for (Usuario usuario : listUsuario) {
                UsuarioDTO usuarioDTO = usuarioToUsuarioDTO(usuario);

                usuarioDTOs.add(usuarioDTO);
            }

            return usuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Usuario> listUsuarioDTOToListUsuario(
        List<UsuarioDTO> listUsuarioDTO) throws Exception {
        try {
            List<Usuario> listUsuario = new ArrayList<Usuario>();

            for (UsuarioDTO usuarioDTO : listUsuarioDTO) {
                Usuario usuario = usuarioDTOToUsuario(usuarioDTO);

                listUsuario.add(usuario);
            }

            return listUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
