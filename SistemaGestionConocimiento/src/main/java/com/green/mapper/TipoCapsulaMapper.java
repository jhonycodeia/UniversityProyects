package com.green.mapper;

import com.green.dto.TipoCapsulaDTO;

import com.green.modelo.TipoCapsula;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TipoCapsulaMapper {
    public TipoCapsulaDTO tipoCapsulaToTipoCapsulaDTO(TipoCapsula tipoCapsula)
        throws Exception;

    public TipoCapsula tipoCapsulaDTOToTipoCapsula(
        TipoCapsulaDTO tipoCapsulaDTO) throws Exception;

    public List<TipoCapsulaDTO> listTipoCapsulaToListTipoCapsulaDTO(
        List<TipoCapsula> tipoCapsulas) throws Exception;

    public List<TipoCapsula> listTipoCapsulaDTOToListTipoCapsula(
        List<TipoCapsulaDTO> tipoCapsulaDTOs) throws Exception;
}
