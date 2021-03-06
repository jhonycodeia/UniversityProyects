package com.saberpro.dto.mapper;

import com.saberpro.modelo.Opcion;
import com.saberpro.modelo.dto.OpcionDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IOpcionMapper {
    public OpcionDTO opcionToOpcionDTO(Opcion opcion) throws Exception;

    public Opcion opcionDTOToOpcion(OpcionDTO opcionDTO)
        throws Exception;

    public List<OpcionDTO> listOpcionToListOpcionDTO(List<Opcion> opcions)
        throws Exception;

    public List<Opcion> listOpcionDTOToListOpcion(List<OpcionDTO> opcionDTOs)
        throws Exception;
}
