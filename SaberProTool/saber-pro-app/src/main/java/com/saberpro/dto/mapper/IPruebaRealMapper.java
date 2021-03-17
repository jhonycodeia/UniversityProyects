package com.saberpro.dto.mapper;

import com.saberpro.modelo.PruebaReal;
import com.saberpro.modelo.dto.PruebaRealDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IPruebaRealMapper {
    public PruebaRealDTO pruebaRealToPruebaRealDTO(PruebaReal pruebaReal)
        throws Exception;

    public PruebaReal pruebaRealDTOToPruebaReal(PruebaRealDTO pruebaRealDTO)
        throws Exception;

    public List<PruebaRealDTO> listPruebaRealToListPruebaRealDTO(
        List<PruebaReal> pruebaReals) throws Exception;

    public List<PruebaReal> listPruebaRealDTOToListPruebaReal(
        List<PruebaRealDTO> pruebaRealDTOs) throws Exception;
}
