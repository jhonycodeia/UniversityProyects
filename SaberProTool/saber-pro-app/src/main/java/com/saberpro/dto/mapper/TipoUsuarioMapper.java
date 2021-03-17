package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.TipoUsuario;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.TipoUsuarioDTO;

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
public class TipoUsuarioMapper implements ITipoUsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoUsuarioMapper.class);

    @Transactional(readOnly = true)
    public TipoUsuarioDTO tipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario)
        throws Exception {
        try {
            TipoUsuarioDTO tipoUsuarioDTO = new TipoUsuarioDTO();

            tipoUsuarioDTO.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
            tipoUsuarioDTO.setActivo((tipoUsuario.getActivo() != null)
                ? tipoUsuario.getActivo() : null);
            tipoUsuarioDTO.setDescripcion((tipoUsuario.getDescripcion() != null)
                ? tipoUsuario.getDescripcion() : null);
            tipoUsuarioDTO.setFechaCreacion(tipoUsuario.getFechaCreacion());
            tipoUsuarioDTO.setFechaModificacion(tipoUsuario.getFechaModificacion());
            tipoUsuarioDTO.setNombre((tipoUsuario.getNombre() != null)
                ? tipoUsuario.getNombre() : null);
            tipoUsuarioDTO.setUsuCreador((tipoUsuario.getUsuCreador() != null)
                ? tipoUsuario.getUsuCreador() : null);
            tipoUsuarioDTO.setUsuModificador((tipoUsuario.getUsuModificador() != null)
                ? tipoUsuario.getUsuModificador() : null);

            return tipoUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoUsuario tipoUsuarioDTOToTipoUsuario(
        TipoUsuarioDTO tipoUsuarioDTO) throws Exception {
        try {
            TipoUsuario tipoUsuario = new TipoUsuario();

            tipoUsuario.setIdTipoUsuario(tipoUsuarioDTO.getIdTipoUsuario());
            tipoUsuario.setActivo((tipoUsuarioDTO.getActivo() != null)
                ? tipoUsuarioDTO.getActivo() : null);
            tipoUsuario.setDescripcion((tipoUsuarioDTO.getDescripcion() != null)
                ? tipoUsuarioDTO.getDescripcion() : null);
            tipoUsuario.setFechaCreacion(tipoUsuarioDTO.getFechaCreacion());
            tipoUsuario.setFechaModificacion(tipoUsuarioDTO.getFechaModificacion());
            tipoUsuario.setNombre((tipoUsuarioDTO.getNombre() != null)
                ? tipoUsuarioDTO.getNombre() : null);
            tipoUsuario.setUsuCreador((tipoUsuarioDTO.getUsuCreador() != null)
                ? tipoUsuarioDTO.getUsuCreador() : null);
            tipoUsuario.setUsuModificador((tipoUsuarioDTO.getUsuModificador() != null)
                ? tipoUsuarioDTO.getUsuModificador() : null);

            return tipoUsuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoUsuarioDTO> listTipoUsuarioToListTipoUsuarioDTO(
        List<TipoUsuario> listTipoUsuario) throws Exception {
        try {
            List<TipoUsuarioDTO> tipoUsuarioDTOs = new ArrayList<TipoUsuarioDTO>();

            for (TipoUsuario tipoUsuario : listTipoUsuario) {
                TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioToTipoUsuarioDTO(tipoUsuario);

                tipoUsuarioDTOs.add(tipoUsuarioDTO);
            }

            return tipoUsuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoUsuario> listTipoUsuarioDTOToListTipoUsuario(
        List<TipoUsuarioDTO> listTipoUsuarioDTO) throws Exception {
        try {
            List<TipoUsuario> listTipoUsuario = new ArrayList<TipoUsuario>();

            for (TipoUsuarioDTO tipoUsuarioDTO : listTipoUsuarioDTO) {
                TipoUsuario tipoUsuario = tipoUsuarioDTOToTipoUsuario(tipoUsuarioDTO);

                listTipoUsuario.add(tipoUsuario);
            }

            return listTipoUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
