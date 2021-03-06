package com.green.mapper;

import com.green.dto.TipoNotificacionDTO;

import com.green.modelo.*;
import com.green.modelo.TipoNotificacion;

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
public class TipoNotificacionMapperImpl implements TipoNotificacionMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoNotificacionMapperImpl.class);

    @Transactional(readOnly = true)
    public TipoNotificacionDTO tipoNotificacionToTipoNotificacionDTO(
        TipoNotificacion tipoNotificacion) throws Exception {
        try {
            TipoNotificacionDTO tipoNotificacionDTO = new TipoNotificacionDTO();

            tipoNotificacionDTO.setIdTipoNotificacion(tipoNotificacion.getIdTipoNotificacion());
            tipoNotificacionDTO.setActivo((tipoNotificacion.getActivo() != null)
                ? tipoNotificacion.getActivo() : null);
            tipoNotificacionDTO.setDescripcion((tipoNotificacion.getDescripcion() != null)
                ? tipoNotificacion.getDescripcion() : null);
            tipoNotificacionDTO.setFechaCreacion(tipoNotificacion.getFechaCreacion());
            tipoNotificacionDTO.setFechaModificacion(tipoNotificacion.getFechaModificacion());
            tipoNotificacionDTO.setNombre((tipoNotificacion.getNombre() != null)
                ? tipoNotificacion.getNombre() : null);
            tipoNotificacionDTO.setUsuCreador((tipoNotificacion.getUsuCreador() != null)
                ? tipoNotificacion.getUsuCreador() : null);
            tipoNotificacionDTO.setUsuModificador((tipoNotificacion.getUsuModificador() != null)
                ? tipoNotificacion.getUsuModificador() : null);

            return tipoNotificacionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoNotificacion tipoNotificacionDTOToTipoNotificacion(
        TipoNotificacionDTO tipoNotificacionDTO) throws Exception {
        try {
            TipoNotificacion tipoNotificacion = new TipoNotificacion();

            tipoNotificacion.setIdTipoNotificacion(tipoNotificacionDTO.getIdTipoNotificacion());
            tipoNotificacion.setActivo((tipoNotificacionDTO.getActivo() != null)
                ? tipoNotificacionDTO.getActivo() : null);
            tipoNotificacion.setDescripcion((tipoNotificacionDTO.getDescripcion() != null)
                ? tipoNotificacionDTO.getDescripcion() : null);
            tipoNotificacion.setFechaCreacion(tipoNotificacionDTO.getFechaCreacion());
            tipoNotificacion.setFechaModificacion(tipoNotificacionDTO.getFechaModificacion());
            tipoNotificacion.setNombre((tipoNotificacionDTO.getNombre() != null)
                ? tipoNotificacionDTO.getNombre() : null);
            tipoNotificacion.setUsuCreador((tipoNotificacionDTO.getUsuCreador() != null)
                ? tipoNotificacionDTO.getUsuCreador() : null);
            tipoNotificacion.setUsuModificador((tipoNotificacionDTO.getUsuModificador() != null)
                ? tipoNotificacionDTO.getUsuModificador() : null);

            return tipoNotificacion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoNotificacionDTO> listTipoNotificacionToListTipoNotificacionDTO(
        List<TipoNotificacion> listTipoNotificacion) throws Exception {
        try {
            List<TipoNotificacionDTO> tipoNotificacionDTOs = new ArrayList<TipoNotificacionDTO>();

            for (TipoNotificacion tipoNotificacion : listTipoNotificacion) {
                TipoNotificacionDTO tipoNotificacionDTO = tipoNotificacionToTipoNotificacionDTO(tipoNotificacion);

                tipoNotificacionDTOs.add(tipoNotificacionDTO);
            }

            return tipoNotificacionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoNotificacion> listTipoNotificacionDTOToListTipoNotificacion(
        List<TipoNotificacionDTO> listTipoNotificacionDTO)
        throws Exception {
        try {
            List<TipoNotificacion> listTipoNotificacion = new ArrayList<TipoNotificacion>();

            for (TipoNotificacionDTO tipoNotificacionDTO : listTipoNotificacionDTO) {
                TipoNotificacion tipoNotificacion = tipoNotificacionDTOToTipoNotificacion(tipoNotificacionDTO);

                listTipoNotificacion.add(tipoNotificacion);
            }

            return listTipoNotificacion;
        } catch (Exception e) {
            throw e;
        }
    }
}
