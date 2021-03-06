package com.green.mapper;

import com.green.dto.SubprocesoDTO;

import com.green.modelo.*;
import com.green.modelo.Subproceso;

import com.green.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class SubprocesoMapperImpl implements SubprocesoMapper {
    private static final Logger log = LoggerFactory.getLogger(SubprocesoMapperImpl.class);

    /**
    * Service injected by Spring that manages Proceso entities
    *
    */
    @Autowired
    ProcesoService serviceProceso1;

    @Transactional(readOnly = true)
    public SubprocesoDTO subprocesoToSubprocesoDTO(Subproceso subproceso)
        throws Exception {
        try {
            SubprocesoDTO subprocesoDTO = new SubprocesoDTO();

            subprocesoDTO.setIdSubproceso(subproceso.getIdSubproceso());
            subprocesoDTO.setActivo((subproceso.getActivo() != null)
                ? subproceso.getActivo() : null);
            subprocesoDTO.setDescripcion((subproceso.getDescripcion() != null)
                ? subproceso.getDescripcion() : null);
            subprocesoDTO.setFechaCreacion(subproceso.getFechaCreacion());
            subprocesoDTO.setFechaModificacion(subproceso.getFechaModificacion());
            subprocesoDTO.setNombre((subproceso.getNombre() != null)
                ? subproceso.getNombre() : null);
            subprocesoDTO.setUsuCreador((subproceso.getUsuCreador() != null)
                ? subproceso.getUsuCreador() : null);
            subprocesoDTO.setUsuModificador((subproceso.getUsuModificador() != null)
                ? subproceso.getUsuModificador() : null);
            subprocesoDTO.setIdProceso_Proceso((subproceso.getProceso()
                                                          .getIdProceso() != null)
                ? subproceso.getProceso().getIdProceso() : null);

            return subprocesoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Subproceso subprocesoDTOToSubproceso(SubprocesoDTO subprocesoDTO)
        throws Exception {
        try {
            Subproceso subproceso = new Subproceso();

            subproceso.setIdSubproceso(subprocesoDTO.getIdSubproceso());
            subproceso.setActivo((subprocesoDTO.getActivo() != null)
                ? subprocesoDTO.getActivo() : null);
            subproceso.setDescripcion((subprocesoDTO.getDescripcion() != null)
                ? subprocesoDTO.getDescripcion() : null);
            subproceso.setFechaCreacion(subprocesoDTO.getFechaCreacion());
            subproceso.setFechaModificacion(subprocesoDTO.getFechaModificacion());
            subproceso.setNombre((subprocesoDTO.getNombre() != null)
                ? subprocesoDTO.getNombre() : null);
            subproceso.setUsuCreador((subprocesoDTO.getUsuCreador() != null)
                ? subprocesoDTO.getUsuCreador() : null);
            subproceso.setUsuModificador((subprocesoDTO.getUsuModificador() != null)
                ? subprocesoDTO.getUsuModificador() : null);

            Proceso proceso = new Proceso();

            if (subprocesoDTO.getIdProceso_Proceso() != null) {
                proceso = serviceProceso1.getProceso(subprocesoDTO.getIdProceso_Proceso());
            }

            if (proceso != null) {
                subproceso.setProceso(proceso);
            }

            return subproceso;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SubprocesoDTO> listSubprocesoToListSubprocesoDTO(
        List<Subproceso> listSubproceso) throws Exception {
        try {
            List<SubprocesoDTO> subprocesoDTOs = new ArrayList<SubprocesoDTO>();

            for (Subproceso subproceso : listSubproceso) {
                SubprocesoDTO subprocesoDTO = subprocesoToSubprocesoDTO(subproceso);

                subprocesoDTOs.add(subprocesoDTO);
            }

            return subprocesoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Subproceso> listSubprocesoDTOToListSubproceso(
        List<SubprocesoDTO> listSubprocesoDTO) throws Exception {
        try {
            List<Subproceso> listSubproceso = new ArrayList<Subproceso>();

            for (SubprocesoDTO subprocesoDTO : listSubprocesoDTO) {
                Subproceso subproceso = subprocesoDTOToSubproceso(subprocesoDTO);

                listSubproceso.add(subproceso);
            }

            return listSubproceso;
        } catch (Exception e) {
            throw e;
        }
    }
}
