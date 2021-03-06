package com.saberpro.dto.mapper;

import com.saberpro.modelo.EstadoPrueba;
import com.saberpro.modelo.dto.EstadoPruebaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IEstadoPruebaMapper {
    public EstadoPruebaDTO estadoPruebaToEstadoPruebaDTO(
        EstadoPrueba estadoPrueba) throws Exception;

    public EstadoPrueba estadoPruebaDTOToEstadoPrueba(
        EstadoPruebaDTO estadoPruebaDTO) throws Exception;

    public List<EstadoPruebaDTO> listEstadoPruebaToListEstadoPruebaDTO(
        List<EstadoPrueba> estadoPruebas) throws Exception;

    public List<EstadoPrueba> listEstadoPruebaDTOToListEstadoPrueba(
        List<EstadoPruebaDTO> estadoPruebaDTOs) throws Exception;
}
