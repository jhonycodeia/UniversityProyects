package com.saberpro.dto.mapper;

import com.saberpro.modelo.ResultadoReal;
import com.saberpro.modelo.dto.ResultadoRealDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IResultadoRealMapper {
    public ResultadoRealDTO resultadoRealToResultadoRealDTO(
        ResultadoReal resultadoReal) throws Exception;

    public ResultadoReal resultadoRealDTOToResultadoReal(
        ResultadoRealDTO resultadoRealDTO) throws Exception;

    public List<ResultadoRealDTO> listResultadoRealToListResultadoRealDTO(
        List<ResultadoReal> resultadoReals) throws Exception;

    public List<ResultadoReal> listResultadoRealDTOToListResultadoReal(
        List<ResultadoRealDTO> resultadoRealDTOs) throws Exception;
}
