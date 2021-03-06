package com.green.mapper;

import com.green.dto.CalificacionDTO;

import com.green.modelo.Calificacion;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface CalificacionMapper {
    public CalificacionDTO calificacionToCalificacionDTO(
        Calificacion calificacion) throws Exception;

    public Calificacion calificacionDTOToCalificacion(
        CalificacionDTO calificacionDTO) throws Exception;

    public List<CalificacionDTO> listCalificacionToListCalificacionDTO(
        List<Calificacion> calificacions) throws Exception;

    public List<Calificacion> listCalificacionDTOToListCalificacion(
        List<CalificacionDTO> calificacionDTOs) throws Exception;
}
