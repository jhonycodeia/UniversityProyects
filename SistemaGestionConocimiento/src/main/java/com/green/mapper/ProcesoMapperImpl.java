package com.green.mapper;

import com.green.dto.ProcesoDTO;

import com.green.modelo.*;
import com.green.modelo.Proceso;

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
public class ProcesoMapperImpl implements ProcesoMapper {
    private static final Logger log = LoggerFactory.getLogger(ProcesoMapperImpl.class);

    @Transactional(readOnly = true)
    public ProcesoDTO procesoToProcesoDTO(Proceso proceso)
        throws Exception {
        try {
            ProcesoDTO procesoDTO = new ProcesoDTO();

            procesoDTO.setIdProceso(proceso.getIdProceso());
            procesoDTO.setActivo((proceso.getActivo() != null)
                ? proceso.getActivo() : null);
            procesoDTO.setDescripcion((proceso.getDescripcion() != null)
                ? proceso.getDescripcion() : null);
            procesoDTO.setFechaCreacion(proceso.getFechaCreacion());
            procesoDTO.setFechaModificacion(proceso.getFechaModificacion());
            procesoDTO.setNombre((proceso.getNombre() != null)
                ? proceso.getNombre() : null);
            procesoDTO.setUsuCreador((proceso.getUsuCreador() != null)
                ? proceso.getUsuCreador() : null);
            procesoDTO.setUsuModificador((proceso.getUsuModificador() != null)
                ? proceso.getUsuModificador() : null);

            return procesoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Proceso procesoDTOToProceso(ProcesoDTO procesoDTO)
        throws Exception {
        try {
            Proceso proceso = new Proceso();

            proceso.setIdProceso(procesoDTO.getIdProceso());
            proceso.setActivo((procesoDTO.getActivo() != null)
                ? procesoDTO.getActivo() : null);
            proceso.setDescripcion((procesoDTO.getDescripcion() != null)
                ? procesoDTO.getDescripcion() : null);
            proceso.setFechaCreacion(procesoDTO.getFechaCreacion());
            proceso.setFechaModificacion(procesoDTO.getFechaModificacion());
            proceso.setNombre((procesoDTO.getNombre() != null)
                ? procesoDTO.getNombre() : null);
            proceso.setUsuCreador((procesoDTO.getUsuCreador() != null)
                ? procesoDTO.getUsuCreador() : null);
            proceso.setUsuModificador((procesoDTO.getUsuModificador() != null)
                ? procesoDTO.getUsuModificador() : null);

            return proceso;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProcesoDTO> listProcesoToListProcesoDTO(
        List<Proceso> listProceso) throws Exception {
        try {
            List<ProcesoDTO> procesoDTOs = new ArrayList<ProcesoDTO>();

            for (Proceso proceso : listProceso) {
                ProcesoDTO procesoDTO = procesoToProcesoDTO(proceso);

                procesoDTOs.add(procesoDTO);
            }

            return procesoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Proceso> listProcesoDTOToListProceso(
        List<ProcesoDTO> listProcesoDTO) throws Exception {
        try {
            List<Proceso> listProceso = new ArrayList<Proceso>();

            for (ProcesoDTO procesoDTO : listProcesoDTO) {
                Proceso proceso = procesoDTOToProceso(procesoDTO);

                listProceso.add(proceso);
            }

            return listProceso;
        } catch (Exception e) {
            throw e;
        }
    }
}
