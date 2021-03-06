package com.green.mapper;

import com.green.dto.ComentarioDTO;

import com.green.modelo.*;
import com.green.modelo.Comentario;

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
public class ComentarioMapperImpl implements ComentarioMapper {
    private static final Logger log = LoggerFactory.getLogger(ComentarioMapperImpl.class);

    /**
    * Service injected by Spring that manages Capsula entities
    *
    */
    @Autowired
    CapsulaService serviceCapsula1;

    /**
    * Service injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    UsuarioService serviceUsuario2;

    @Transactional(readOnly = true)
    public ComentarioDTO comentarioToComentarioDTO(Comentario comentario)
        throws Exception {
        try {
            ComentarioDTO comentarioDTO = new ComentarioDTO();

            comentarioDTO.setIdComentario(comentario.getIdComentario());
            comentarioDTO.setActivo((comentario.getActivo() != null)
                ? comentario.getActivo() : null);
            comentarioDTO.setCalificacion((comentario.getCalificacion() != null)
                ? comentario.getCalificacion() : null);
            comentarioDTO.setFechaCreacion(comentario.getFechaCreacion());
            comentarioDTO.setFechaModificacion(comentario.getFechaModificacion());
            comentarioDTO.setUsuCreador((comentario.getUsuCreador() != null)
                ? comentario.getUsuCreador() : null);
            comentarioDTO.setUsuModificador((comentario.getUsuModificador() != null)
                ? comentario.getUsuModificador() : null);
            comentarioDTO.setValor((comentario.getValor() != null)
                ? comentario.getValor() : null);
            comentarioDTO.setIdCapsula_Capsula((comentario.getCapsula()
                                                          .getIdCapsula() != null)
                ? comentario.getCapsula().getIdCapsula() : null);
            comentarioDTO.setIdUsuario_Usuario((comentario.getUsuario()
                                                          .getIdUsuario() != null)
                ? comentario.getUsuario().getIdUsuario() : null);

            return comentarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Comentario comentarioDTOToComentario(ComentarioDTO comentarioDTO)
        throws Exception {
        try {
            Comentario comentario = new Comentario();

            comentario.setIdComentario(comentarioDTO.getIdComentario());
            comentario.setActivo((comentarioDTO.getActivo() != null)
                ? comentarioDTO.getActivo() : null);
            comentario.setCalificacion((comentarioDTO.getCalificacion() != null)
                ? comentarioDTO.getCalificacion() : null);
            comentario.setFechaCreacion(comentarioDTO.getFechaCreacion());
            comentario.setFechaModificacion(comentarioDTO.getFechaModificacion());
            comentario.setUsuCreador((comentarioDTO.getUsuCreador() != null)
                ? comentarioDTO.getUsuCreador() : null);
            comentario.setUsuModificador((comentarioDTO.getUsuModificador() != null)
                ? comentarioDTO.getUsuModificador() : null);
            comentario.setValor((comentarioDTO.getValor() != null)
                ? comentarioDTO.getValor() : null);

            Capsula capsula = new Capsula();

            if (comentarioDTO.getIdCapsula_Capsula() != null) {
                capsula = serviceCapsula1.getCapsula(comentarioDTO.getIdCapsula_Capsula());
            }

            if (capsula != null) {
                comentario.setCapsula(capsula);
            }

            Usuario usuario = new Usuario();

            if (comentarioDTO.getIdUsuario_Usuario() != null) {
                usuario = serviceUsuario2.getUsuario(comentarioDTO.getIdUsuario_Usuario());
            }

            if (usuario != null) {
                comentario.setUsuario(usuario);
            }

            return comentario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ComentarioDTO> listComentarioToListComentarioDTO(
        List<Comentario> listComentario) throws Exception {
        try {
            List<ComentarioDTO> comentarioDTOs = new ArrayList<ComentarioDTO>();

            for (Comentario comentario : listComentario) {
                ComentarioDTO comentarioDTO = comentarioToComentarioDTO(comentario);

                comentarioDTOs.add(comentarioDTO);
            }

            return comentarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Comentario> listComentarioDTOToListComentario(
        List<ComentarioDTO> listComentarioDTO) throws Exception {
        try {
            List<Comentario> listComentario = new ArrayList<Comentario>();

            for (ComentarioDTO comentarioDTO : listComentarioDTO) {
                Comentario comentario = comentarioDTOToComentario(comentarioDTO);

                listComentario.add(comentario);
            }

            return listComentario;
        } catch (Exception e) {
            throw e;
        }
    }
}
