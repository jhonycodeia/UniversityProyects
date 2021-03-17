package com.saberpro.dto.mapper;

import com.saberpro.modelo.TipoModulo;
import com.saberpro.modelo.dto.TipoModuloDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ITipoModuloMapper {
    public TipoModuloDTO tipoModuloToTipoModuloDTO(TipoModulo tipoModulo)
        throws Exception;

    public TipoModulo tipoModuloDTOToTipoModulo(TipoModuloDTO tipoModuloDTO)
        throws Exception;

    public List<TipoModuloDTO> listTipoModuloToListTipoModuloDTO(
        List<TipoModulo> tipoModulos) throws Exception;

    public List<TipoModulo> listTipoModuloDTOToListTipoModulo(
        List<TipoModuloDTO> tipoModuloDTOs) throws Exception;
}
