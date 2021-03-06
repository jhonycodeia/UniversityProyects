package com.saberpro.dto.mapper;

import com.saberpro.modelo.GrupoOpcion;
import com.saberpro.modelo.dto.GrupoOpcionDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IGrupoOpcionMapper {
    public GrupoOpcionDTO grupoOpcionToGrupoOpcionDTO(GrupoOpcion grupoOpcion)
        throws Exception;

    public GrupoOpcion grupoOpcionDTOToGrupoOpcion(
        GrupoOpcionDTO grupoOpcionDTO) throws Exception;

    public List<GrupoOpcionDTO> listGrupoOpcionToListGrupoOpcionDTO(
        List<GrupoOpcion> grupoOpcions) throws Exception;

    public List<GrupoOpcion> listGrupoOpcionDTOToListGrupoOpcion(
        List<GrupoOpcionDTO> grupoOpcionDTOs) throws Exception;
}
