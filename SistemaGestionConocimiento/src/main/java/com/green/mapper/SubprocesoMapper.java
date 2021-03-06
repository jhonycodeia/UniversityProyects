package com.green.mapper;

import com.green.dto.SubprocesoDTO;

import com.green.modelo.Subproceso;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface SubprocesoMapper {
    public SubprocesoDTO subprocesoToSubprocesoDTO(Subproceso subproceso)
        throws Exception;

    public Subproceso subprocesoDTOToSubproceso(SubprocesoDTO subprocesoDTO)
        throws Exception;

    public List<SubprocesoDTO> listSubprocesoToListSubprocesoDTO(
        List<Subproceso> subprocesos) throws Exception;

    public List<Subproceso> listSubprocesoDTOToListSubproceso(
        List<SubprocesoDTO> subprocesoDTOs) throws Exception;
}
