package com.green.mapper;

import com.green.dto.PuntosDTO;

import com.green.modelo.Puntos;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface PuntosMapper {
    public PuntosDTO puntosToPuntosDTO(Puntos puntos) throws Exception;

    public Puntos puntosDTOToPuntos(PuntosDTO puntosDTO)
        throws Exception;

    public List<PuntosDTO> listPuntosToListPuntosDTO(List<Puntos> puntoss)
        throws Exception;

    public List<Puntos> listPuntosDTOToListPuntos(List<PuntosDTO> puntosDTOs)
        throws Exception;
}
