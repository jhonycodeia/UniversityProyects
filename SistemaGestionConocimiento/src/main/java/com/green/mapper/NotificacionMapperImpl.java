package com.green.mapper;

import com.green.dto.NotificacionDTO;

import com.green.modelo.*;
import com.green.modelo.Notificacion;

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
public class NotificacionMapperImpl implements NotificacionMapper {
    private static final Logger log = LoggerFactory.getLogger(NotificacionMapperImpl.class);

    /**
    * Service injected by Spring that manages Capsula entities
    *
    */
    @Autowired
    CapsulaService serviceCapsula1;

    /**
    * Service injected by Spring that manages TipoNotificacion entities
    *
    */
    @Autowired
    TipoNotificacionService serviceTipoNotificacion2;

    /**
    * Service injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    UsuarioService serviceUsuario3;

    @Transactional(readOnly = true)
    public NotificacionDTO notificacionToNotificacionDTO(
        Notificacion notificacion) throws Exception {
        try {
            NotificacionDTO notificacionDTO = new NotificacionDTO();

            notificacionDTO.setIdNotificacion(notificacion.getIdNotificacion());
            notificacionDTO.setActivo((notificacion.getActivo() != null)
                ? notificacion.getActivo() : null);
            notificacionDTO.setDescripcion((notificacion.getDescripcion() != null)
                ? notificacion.getDescripcion() : null);
            notificacionDTO.setFechaCreacion(notificacion.getFechaCreacion());
            notificacionDTO.setFechaModificacion(notificacion.getFechaModificacion());
            notificacionDTO.setNombre((notificacion.getNombre() != null)
                ? notificacion.getNombre() : null);
            notificacionDTO.setUsuCreador((notificacion.getUsuCreador() != null)
                ? notificacion.getUsuCreador() : null);
            notificacionDTO.setUsuModificador((notificacion.getUsuModificador() != null)
                ? notificacion.getUsuModificador() : null);
            notificacionDTO.setValor((notificacion.getValor() != null)
                ? notificacion.getValor() : null);
            notificacionDTO.setIdCapsula_Capsula((notificacion.getCapsula()
                                                              .getIdCapsula() != null)
                ? notificacion.getCapsula().getIdCapsula() : null);
            notificacionDTO.setIdTipoNotificacion_TipoNotificacion((notificacion.getTipoNotificacion()
                                                                                .getIdTipoNotificacion() != null)
                ? notificacion.getTipoNotificacion().getIdTipoNotificacion()
                : null);
            notificacionDTO.setIdUsuario_Usuario((notificacion.getUsuario()
                                                              .getIdUsuario() != null)
                ? notificacion.getUsuario().getIdUsuario() : null);

            return notificacionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Notificacion notificacionDTOToNotificacion(
        NotificacionDTO notificacionDTO) throws Exception {
        try {
            Notificacion notificacion = new Notificacion();

            notificacion.setIdNotificacion(notificacionDTO.getIdNotificacion());
            notificacion.setActivo((notificacionDTO.getActivo() != null)
                ? notificacionDTO.getActivo() : null);
            notificacion.setDescripcion((notificacionDTO.getDescripcion() != null)
                ? notificacionDTO.getDescripcion() : null);
            notificacion.setFechaCreacion(notificacionDTO.getFechaCreacion());
            notificacion.setFechaModificacion(notificacionDTO.getFechaModificacion());
            notificacion.setNombre((notificacionDTO.getNombre() != null)
                ? notificacionDTO.getNombre() : null);
            notificacion.setUsuCreador((notificacionDTO.getUsuCreador() != null)
                ? notificacionDTO.getUsuCreador() : null);
            notificacion.setUsuModificador((notificacionDTO.getUsuModificador() != null)
                ? notificacionDTO.getUsuModificador() : null);
            notificacion.setValor((notificacionDTO.getValor() != null)
                ? notificacionDTO.getValor() : null);

            Capsula capsula = new Capsula();

            if (notificacionDTO.getIdCapsula_Capsula() != null) {
                capsula = serviceCapsula1.getCapsula(notificacionDTO.getIdCapsula_Capsula());
            }

            if (capsula != null) {
                notificacion.setCapsula(capsula);
            }

            TipoNotificacion tipoNotificacion = new TipoNotificacion();

            if (notificacionDTO.getIdTipoNotificacion_TipoNotificacion() != null) {
                tipoNotificacion = serviceTipoNotificacion2.getTipoNotificacion(notificacionDTO.getIdTipoNotificacion_TipoNotificacion());
            }

            if (tipoNotificacion != null) {
                notificacion.setTipoNotificacion(tipoNotificacion);
            }

            Usuario usuario = new Usuario();

            if (notificacionDTO.getIdUsuario_Usuario() != null) {
                usuario = serviceUsuario3.getUsuario(notificacionDTO.getIdUsuario_Usuario());
            }

            if (usuario != null) {
                notificacion.setUsuario(usuario);
            }

            return notificacion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<NotificacionDTO> listNotificacionToListNotificacionDTO(
        List<Notificacion> listNotificacion) throws Exception {
        try {
            List<NotificacionDTO> notificacionDTOs = new ArrayList<NotificacionDTO>();

            for (Notificacion notificacion : listNotificacion) {
                NotificacionDTO notificacionDTO = notificacionToNotificacionDTO(notificacion);

                notificacionDTOs.add(notificacionDTO);
            }

            return notificacionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Notificacion> listNotificacionDTOToListNotificacion(
        List<NotificacionDTO> listNotificacionDTO) throws Exception {
        try {
            List<Notificacion> listNotificacion = new ArrayList<Notificacion>();

            for (NotificacionDTO notificacionDTO : listNotificacionDTO) {
                Notificacion notificacion = notificacionDTOToNotificacion(notificacionDTO);

                listNotificacion.add(notificacion);
            }

            return listNotificacion;
        } catch (Exception e) {
            throw e;
        }
    }
}
