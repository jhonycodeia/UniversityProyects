package com.saberpro.dto.mapper;

import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.dto.FacultadDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IFacultadMapper {
    public FacultadDTO facultadToFacultadDTO(Facultad facultad)
        throws Exception;

    public Facultad facultadDTOToFacultad(FacultadDTO facultadDTO)
        throws Exception;

    public List<FacultadDTO> listFacultadToListFacultadDTO(
        List<Facultad> facultads) throws Exception;

    public List<Facultad> listFacultadDTOToListFacultad(
        List<FacultadDTO> facultadDTOs) throws Exception;
}
