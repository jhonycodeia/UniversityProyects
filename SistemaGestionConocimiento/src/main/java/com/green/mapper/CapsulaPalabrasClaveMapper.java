package com.green.mapper;

import com.green.dto.CapsulaPalabrasClaveDTO;

import com.green.modelo.CapsulaPalabrasClave;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface CapsulaPalabrasClaveMapper {
    public CapsulaPalabrasClaveDTO capsulaPalabrasClaveToCapsulaPalabrasClaveDTO(
        CapsulaPalabrasClave capsulaPalabrasClave) throws Exception;

    public CapsulaPalabrasClave capsulaPalabrasClaveDTOToCapsulaPalabrasClave(
        CapsulaPalabrasClaveDTO capsulaPalabrasClaveDTO)
        throws Exception;

    public List<CapsulaPalabrasClaveDTO> listCapsulaPalabrasClaveToListCapsulaPalabrasClaveDTO(
        List<CapsulaPalabrasClave> capsulaPalabrasClaves)
        throws Exception;

    public List<CapsulaPalabrasClave> listCapsulaPalabrasClaveDTOToListCapsulaPalabrasClave(
        List<CapsulaPalabrasClaveDTO> capsulaPalabrasClaveDTOs)
        throws Exception;
}
