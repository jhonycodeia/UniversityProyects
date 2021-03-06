package com.saberpro.dto.mapper;

import com.saberpro.modelo.Prueba;
import com.saberpro.modelo.dto.PruebaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IPruebaMapper {
    public PruebaDTO pruebaToPruebaDTO(Prueba prueba) throws Exception;

    public Prueba pruebaDTOToPrueba(PruebaDTO pruebaDTO)
        throws Exception;

    public List<PruebaDTO> listPruebaToListPruebaDTO(List<Prueba> pruebas)
        throws Exception;

    public List<Prueba> listPruebaDTOToListPrueba(List<PruebaDTO> pruebaDTOs)
        throws Exception;
}
