package com.saberpro.dto.mapper;

import com.saberpro.modelo.PruebaModulo;
import com.saberpro.modelo.dto.PruebaModuloDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IPruebaModuloMapper {
    public PruebaModuloDTO pruebaModuloToPruebaModuloDTO(
        PruebaModulo pruebaModulo) throws Exception;

    public PruebaModulo pruebaModuloDTOToPruebaModulo(
        PruebaModuloDTO pruebaModuloDTO) throws Exception;

    public List<PruebaModuloDTO> listPruebaModuloToListPruebaModuloDTO(
        List<PruebaModulo> pruebaModulos) throws Exception;

    public List<PruebaModulo> listPruebaModuloDTOToListPruebaModulo(
        List<PruebaModuloDTO> pruebaModuloDTOs) throws Exception;
}
