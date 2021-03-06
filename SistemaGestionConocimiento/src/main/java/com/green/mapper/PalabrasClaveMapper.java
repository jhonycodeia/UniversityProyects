package com.green.mapper;

import com.green.dto.PalabrasClaveDTO;

import com.green.modelo.PalabrasClave;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface PalabrasClaveMapper {
    public PalabrasClaveDTO palabrasClaveToPalabrasClaveDTO(
        PalabrasClave palabrasClave) throws Exception;

    public PalabrasClave palabrasClaveDTOToPalabrasClave(
        PalabrasClaveDTO palabrasClaveDTO) throws Exception;

    public List<PalabrasClaveDTO> listPalabrasClaveToListPalabrasClaveDTO(
        List<PalabrasClave> palabrasClaves) throws Exception;

    public List<PalabrasClave> listPalabrasClaveDTOToListPalabrasClave(
        List<PalabrasClaveDTO> palabrasClaveDTOs) throws Exception;
}
