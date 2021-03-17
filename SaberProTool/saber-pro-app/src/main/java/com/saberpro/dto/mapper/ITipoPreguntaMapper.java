package com.saberpro.dto.mapper;

import com.saberpro.modelo.TipoPregunta;
import com.saberpro.modelo.dto.TipoPreguntaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ITipoPreguntaMapper {
    public TipoPreguntaDTO tipoPreguntaToTipoPreguntaDTO(
        TipoPregunta tipoPregunta) throws Exception;

    public TipoPregunta tipoPreguntaDTOToTipoPregunta(
        TipoPreguntaDTO tipoPreguntaDTO) throws Exception;

    public List<TipoPreguntaDTO> listTipoPreguntaToListTipoPreguntaDTO(
        List<TipoPregunta> tipoPreguntas) throws Exception;

    public List<TipoPregunta> listTipoPreguntaDTOToListTipoPregunta(
        List<TipoPreguntaDTO> tipoPreguntaDTOs) throws Exception;
}
