package com.green.mapper;

import com.green.dto.NotificacionDTO;

import com.green.modelo.Notificacion;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface NotificacionMapper {
    public NotificacionDTO notificacionToNotificacionDTO(
        Notificacion notificacion) throws Exception;

    public Notificacion notificacionDTOToNotificacion(
        NotificacionDTO notificacionDTO) throws Exception;

    public List<NotificacionDTO> listNotificacionToListNotificacionDTO(
        List<Notificacion> notificacions) throws Exception;

    public List<Notificacion> listNotificacionDTOToListNotificacion(
        List<NotificacionDTO> notificacionDTOs) throws Exception;
}
