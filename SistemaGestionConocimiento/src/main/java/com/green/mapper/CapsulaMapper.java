package com.green.mapper;

import com.green.dto.CapsulaDTO;

import com.green.modelo.Capsula;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface CapsulaMapper {
    public CapsulaDTO capsulaToCapsulaDTO(Capsula capsula)
        throws Exception;

    public Capsula capsulaDTOToCapsula(CapsulaDTO capsulaDTO)
        throws Exception;

    public List<CapsulaDTO> listCapsulaToListCapsulaDTO(List<Capsula> capsulas)
        throws Exception;

    public List<Capsula> listCapsulaDTOToListCapsula(
        List<CapsulaDTO> capsulaDTOs) throws Exception;
}
