package com.saberpro.dto.mapper;

import com.saberpro.modelo.Parametro;
import com.saberpro.modelo.dto.ParametroDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IParametroMapper {
    public ParametroDTO parametroToParametroDTO(Parametro parametro)
        throws Exception;

    public Parametro parametroDTOToParametro(ParametroDTO parametroDTO)
        throws Exception;

    public List<ParametroDTO> listParametroToListParametroDTO(
        List<Parametro> parametros) throws Exception;

    public List<Parametro> listParametroDTOToListParametro(
        List<ParametroDTO> parametroDTOs) throws Exception;
}
