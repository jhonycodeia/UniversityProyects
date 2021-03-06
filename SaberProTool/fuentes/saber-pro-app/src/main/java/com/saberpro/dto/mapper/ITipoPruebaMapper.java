package com.saberpro.dto.mapper;

import com.saberpro.modelo.TipoPrueba;
import com.saberpro.modelo.dto.TipoPruebaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ITipoPruebaMapper {
    public TipoPruebaDTO tipoPruebaToTipoPruebaDTO(TipoPrueba tipoPrueba)
        throws Exception;

    public TipoPrueba tipoPruebaDTOToTipoPrueba(TipoPruebaDTO tipoPruebaDTO)
        throws Exception;

    public List<TipoPruebaDTO> listTipoPruebaToListTipoPruebaDTO(
        List<TipoPrueba> tipoPruebas) throws Exception;

    public List<TipoPrueba> listTipoPruebaDTOToListTipoPrueba(
        List<TipoPruebaDTO> tipoPruebaDTOs) throws Exception;
}
