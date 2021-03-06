package com.green.mapper;

import com.green.dto.TipoPuntosDTO;

import com.green.modelo.TipoPuntos;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoPuntosMapper {
    public TipoPuntosDTO tipoPuntosToTipoPuntosDTO(TipoPuntos tipoPuntos)
        throws Exception;

    public TipoPuntos tipoPuntosDTOToTipoPuntos(TipoPuntosDTO tipoPuntosDTO)
        throws Exception;

    public List<TipoPuntosDTO> listTipoPuntosToListTipoPuntosDTO(
        List<TipoPuntos> tipoPuntoss) throws Exception;

    public List<TipoPuntos> listTipoPuntosDTOToListTipoPuntos(
        List<TipoPuntosDTO> tipoPuntosDTOs) throws Exception;
}
