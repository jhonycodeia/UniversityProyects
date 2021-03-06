package com.green.mapper;

import com.green.dto.RecompensaUsuarioDTO;

import com.green.modelo.*;
import com.green.modelo.RecompensaUsuario;

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
public class RecompensaUsuarioMapperImpl implements RecompensaUsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(RecompensaUsuarioMapperImpl.class);

    /**
    * Service injected by Spring that manages Recompensa entities
    *
    */
    @Autowired
    RecompensaService serviceRecompensa1;

    /**
    * Service injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    UsuarioService serviceUsuario2;

    @Transactional(readOnly = true)
    public RecompensaUsuarioDTO recompensaUsuarioToRecompensaUsuarioDTO(
        RecompensaUsuario recompensaUsuario) throws Exception {
        try {
            RecompensaUsuarioDTO recompensaUsuarioDTO = new RecompensaUsuarioDTO();

            recompensaUsuarioDTO.setIdRecompensaUsuario(recompensaUsuario.getIdRecompensaUsuario());
            recompensaUsuarioDTO.setActivo((recompensaUsuario.getActivo() != null)
                ? recompensaUsuario.getActivo() : null);
            recompensaUsuarioDTO.setFechaCreacion(recompensaUsuario.getFechaCreacion());
            recompensaUsuarioDTO.setFechaModificacion(recompensaUsuario.getFechaModificacion());
            recompensaUsuarioDTO.setUsuCreador((recompensaUsuario.getUsuCreador() != null)
                ? recompensaUsuario.getUsuCreador() : null);
            recompensaUsuarioDTO.setUsuModificador((recompensaUsuario.getUsuModificador() != null)
                ? recompensaUsuario.getUsuModificador() : null);
            recompensaUsuarioDTO.setIdRecompensa_Recompensa((recompensaUsuario.getRecompensa()
                                                                              .getIdRecompensa() != null)
                ? recompensaUsuario.getRecompensa().getIdRecompensa() : null);
            recompensaUsuarioDTO.setIdUsuario_Usuario((recompensaUsuario.getUsuario()
                                                                        .getIdUsuario() != null)
                ? recompensaUsuario.getUsuario().getIdUsuario() : null);

            return recompensaUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public RecompensaUsuario recompensaUsuarioDTOToRecompensaUsuario(
        RecompensaUsuarioDTO recompensaUsuarioDTO) throws Exception {
        try {
            RecompensaUsuario recompensaUsuario = new RecompensaUsuario();

            recompensaUsuario.setIdRecompensaUsuario(recompensaUsuarioDTO.getIdRecompensaUsuario());
            recompensaUsuario.setActivo((recompensaUsuarioDTO.getActivo() != null)
                ? recompensaUsuarioDTO.getActivo() : null);
            recompensaUsuario.setFechaCreacion(recompensaUsuarioDTO.getFechaCreacion());
            recompensaUsuario.setFechaModificacion(recompensaUsuarioDTO.getFechaModificacion());
            recompensaUsuario.setUsuCreador((recompensaUsuarioDTO.getUsuCreador() != null)
                ? recompensaUsuarioDTO.getUsuCreador() : null);
            recompensaUsuario.setUsuModificador((recompensaUsuarioDTO.getUsuModificador() != null)
                ? recompensaUsuarioDTO.getUsuModificador() : null);

            Recompensa recompensa = new Recompensa();

            if (recompensaUsuarioDTO.getIdRecompensa_Recompensa() != null) {
                recompensa = serviceRecompensa1.getRecompensa(recompensaUsuarioDTO.getIdRecompensa_Recompensa());
            }

            if (recompensa != null) {
                recompensaUsuario.setRecompensa(recompensa);
            }

            Usuario usuario = new Usuario();

            if (recompensaUsuarioDTO.getIdUsuario_Usuario() != null) {
                usuario = serviceUsuario2.getUsuario(recompensaUsuarioDTO.getIdUsuario_Usuario());
            }

            if (usuario != null) {
                recompensaUsuario.setUsuario(usuario);
            }

            return recompensaUsuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RecompensaUsuarioDTO> listRecompensaUsuarioToListRecompensaUsuarioDTO(
        List<RecompensaUsuario> listRecompensaUsuario)
        throws Exception {
        try {
            List<RecompensaUsuarioDTO> recompensaUsuarioDTOs = new ArrayList<RecompensaUsuarioDTO>();

            for (RecompensaUsuario recompensaUsuario : listRecompensaUsuario) {
                RecompensaUsuarioDTO recompensaUsuarioDTO = recompensaUsuarioToRecompensaUsuarioDTO(recompensaUsuario);

                recompensaUsuarioDTOs.add(recompensaUsuarioDTO);
            }

            return recompensaUsuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RecompensaUsuario> listRecompensaUsuarioDTOToListRecompensaUsuario(
        List<RecompensaUsuarioDTO> listRecompensaUsuarioDTO)
        throws Exception {
        try {
            List<RecompensaUsuario> listRecompensaUsuario = new ArrayList<RecompensaUsuario>();

            for (RecompensaUsuarioDTO recompensaUsuarioDTO : listRecompensaUsuarioDTO) {
                RecompensaUsuario recompensaUsuario = recompensaUsuarioDTOToRecompensaUsuario(recompensaUsuarioDTO);

                listRecompensaUsuario.add(recompensaUsuario);
            }

            return listRecompensaUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
