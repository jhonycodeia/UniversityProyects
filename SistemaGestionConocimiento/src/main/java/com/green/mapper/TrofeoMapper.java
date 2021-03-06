package com.green.mapper;

import com.green.dto.TrofeoDTO;

import com.green.modelo.Trofeo;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface TrofeoMapper {
    public TrofeoDTO trofeoToTrofeoDTO(Trofeo trofeo) throws Exception;

    public Trofeo trofeoDTOToTrofeo(TrofeoDTO trofeoDTO)
        throws Exception;

    public List<TrofeoDTO> listTrofeoToListTrofeoDTO(List<Trofeo> trofeos)
        throws Exception;

    public List<Trofeo> listTrofeoDTOToListTrofeo(List<TrofeoDTO> trofeoDTOs)
        throws Exception;
}
