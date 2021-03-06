package com.green.mapper;

import com.green.dto.ParametroDTO;

import com.green.modelo.Parametro;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ParametroMapper {
    public ParametroDTO parametroToParametroDTO(Parametro parametro)
        throws Exception;

    public Parametro parametroDTOToParametro(ParametroDTO parametroDTO)
        throws Exception;

    public List<ParametroDTO> listParametroToListParametroDTO(
        List<Parametro> parametros) throws Exception;

    public List<Parametro> listParametroDTOToListParametro(
        List<ParametroDTO> parametroDTOs) throws Exception;
}
