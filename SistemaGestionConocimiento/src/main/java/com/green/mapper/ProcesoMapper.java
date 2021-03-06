package com.green.mapper;

import com.green.dto.ProcesoDTO;

import com.green.modelo.Proceso;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ProcesoMapper {
    public ProcesoDTO procesoToProcesoDTO(Proceso proceso)
        throws Exception;

    public Proceso procesoDTOToProceso(ProcesoDTO procesoDTO)
        throws Exception;

    public List<ProcesoDTO> listProcesoToListProcesoDTO(List<Proceso> procesos)
        throws Exception;

    public List<Proceso> listProcesoDTOToListProceso(
        List<ProcesoDTO> procesoDTOs) throws Exception;
}
