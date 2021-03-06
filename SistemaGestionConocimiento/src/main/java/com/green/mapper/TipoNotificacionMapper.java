package com.green.mapper;

import com.green.dto.TipoNotificacionDTO;

import com.green.modelo.TipoNotificacion;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoNotificacionMapper {
    public TipoNotificacionDTO tipoNotificacionToTipoNotificacionDTO(
        TipoNotificacion tipoNotificacion) throws Exception;

    public TipoNotificacion tipoNotificacionDTOToTipoNotificacion(
        TipoNotificacionDTO tipoNotificacionDTO) throws Exception;

    public List<TipoNotificacionDTO> listTipoNotificacionToListTipoNotificacionDTO(
        List<TipoNotificacion> tipoNotificacions) throws Exception;

    public List<TipoNotificacion> listTipoNotificacionDTOToListTipoNotificacion(
        List<TipoNotificacionDTO> tipoNotificacionDTOs)
        throws Exception;
}
