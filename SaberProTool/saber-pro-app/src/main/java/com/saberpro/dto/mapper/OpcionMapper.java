package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.Opcion;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.OpcionDTO;

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
public class OpcionMapper implements IOpcionMapper {
    private static final Logger log = LoggerFactory.getLogger(OpcionMapper.class);

    /**
    * Logic injected by Spring that manages GrupoOpcion entities
    *
    */
    @Autowired
    IGrupoOpcionLogic logicGrupoOpcion1;

    @Transactional(readOnly = true)
    public OpcionDTO opcionToOpcionDTO(Opcion opcion) throws Exception {
        try {
            OpcionDTO opcionDTO = new OpcionDTO();

            opcionDTO.setIdOpcion(opcion.getIdOpcion());
            opcionDTO.setActivo((opcion.getActivo() != null)
                ? opcion.getActivo() : null);
            opcionDTO.setDescripcion((opcion.getDescripcion() != null)
                ? opcion.getDescripcion() : null);
            opcionDTO.setFechaCreacion(opcion.getFechaCreacion());
            opcionDTO.setFechaModificacion(opcion.getFechaModificacion());
            opcionDTO.setNombre((opcion.getNombre() != null)
                ? opcion.getNombre() : null);
            opcionDTO.setRuta((opcion.getRuta() != null) ? opcion.getRuta() : null);
            opcionDTO.setUsuCreador((opcion.getUsuCreador() != null)
                ? opcion.getUsuCreador() : null);
            opcionDTO.setUsuModificador((opcion.getUsuModificador() != null)
                ? opcion.getUsuModificador() : null);
            opcionDTO.setIdGrupoOpcion_GrupoOpcion((opcion.getGrupoOpcion()
                                                          .getIdGrupoOpcion() != null)
                ? opcion.getGrupoOpcion().getIdGrupoOpcion() : null);

            return opcionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Opcion opcionDTOToOpcion(OpcionDTO opcionDTO)
        throws Exception {
        try {
            Opcion opcion = new Opcion();

            opcion.setIdOpcion(opcionDTO.getIdOpcion());
            opcion.setActivo((opcionDTO.getActivo() != null)
                ? opcionDTO.getActivo() : null);
            opcion.setDescripcion((opcionDTO.getDescripcion() != null)
                ? opcionDTO.getDescripcion() : null);
            opcion.setFechaCreacion(opcionDTO.getFechaCreacion());
            opcion.setFechaModificacion(opcionDTO.getFechaModificacion());
            opcion.setNombre((opcionDTO.getNombre() != null)
                ? opcionDTO.getNombre() : null);
            opcion.setRuta((opcionDTO.getRuta() != null) ? opcionDTO.getRuta()
                                                         : null);
            opcion.setUsuCreador((opcionDTO.getUsuCreador() != null)
                ? opcionDTO.getUsuCreador() : null);
            opcion.setUsuModificador((opcionDTO.getUsuModificador() != null)
                ? opcionDTO.getUsuModificador() : null);

            GrupoOpcion grupoOpcion = new GrupoOpcion();

            if (opcionDTO.getIdGrupoOpcion_GrupoOpcion() != null) {
                grupoOpcion = logicGrupoOpcion1.getGrupoOpcion(opcionDTO.getIdGrupoOpcion_GrupoOpcion());
            }

            if (grupoOpcion != null) {
                opcion.setGrupoOpcion(grupoOpcion);
            }

            return opcion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<OpcionDTO> listOpcionToListOpcionDTO(List<Opcion> listOpcion)
        throws Exception {
        try {
            List<OpcionDTO> opcionDTOs = new ArrayList<OpcionDTO>();

            for (Opcion opcion : listOpcion) {
                OpcionDTO opcionDTO = opcionToOpcionDTO(opcion);

                opcionDTOs.add(opcionDTO);
            }

            return opcionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Opcion> listOpcionDTOToListOpcion(List<OpcionDTO> listOpcionDTO)
        throws Exception {
        try {
            List<Opcion> listOpcion = new ArrayList<Opcion>();

            for (OpcionDTO opcionDTO : listOpcionDTO) {
                Opcion opcion = opcionDTOToOpcion(opcionDTO);

                listOpcion.add(opcion);
            }

            return listOpcion;
        } catch (Exception e) {
            throw e;
        }
    }
}
