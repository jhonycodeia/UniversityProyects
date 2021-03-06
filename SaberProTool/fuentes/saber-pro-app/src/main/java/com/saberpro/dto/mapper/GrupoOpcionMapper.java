package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.GrupoOpcion;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.GrupoOpcionDTO;

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
public class GrupoOpcionMapper implements IGrupoOpcionMapper {
    private static final Logger log = LoggerFactory.getLogger(GrupoOpcionMapper.class);

    @Transactional(readOnly = true)
    public GrupoOpcionDTO grupoOpcionToGrupoOpcionDTO(GrupoOpcion grupoOpcion)
        throws Exception {
        try {
            GrupoOpcionDTO grupoOpcionDTO = new GrupoOpcionDTO();

            grupoOpcionDTO.setIdGrupoOpcion(grupoOpcion.getIdGrupoOpcion());
            grupoOpcionDTO.setActivo((grupoOpcion.getActivo() != null)
                ? grupoOpcion.getActivo() : null);
            grupoOpcionDTO.setDescripcion((grupoOpcion.getDescripcion() != null)
                ? grupoOpcion.getDescripcion() : null);
            grupoOpcionDTO.setFechaCreacion(grupoOpcion.getFechaCreacion());
            grupoOpcionDTO.setFechaModificacion(grupoOpcion.getFechaModificacion());
            grupoOpcionDTO.setIcon((grupoOpcion.getIcon() != null)
                ? grupoOpcion.getIcon() : null);
            grupoOpcionDTO.setNombre((grupoOpcion.getNombre() != null)
                ? grupoOpcion.getNombre() : null);
            grupoOpcionDTO.setUsuCreador((grupoOpcion.getUsuCreador() != null)
                ? grupoOpcion.getUsuCreador() : null);
            grupoOpcionDTO.setUsuModificador((grupoOpcion.getUsuModificador() != null)
                ? grupoOpcion.getUsuModificador() : null);

            return grupoOpcionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public GrupoOpcion grupoOpcionDTOToGrupoOpcion(
        GrupoOpcionDTO grupoOpcionDTO) throws Exception {
        try {
            GrupoOpcion grupoOpcion = new GrupoOpcion();

            grupoOpcion.setIdGrupoOpcion(grupoOpcionDTO.getIdGrupoOpcion());
            grupoOpcion.setActivo((grupoOpcionDTO.getActivo() != null)
                ? grupoOpcionDTO.getActivo() : null);
            grupoOpcion.setDescripcion((grupoOpcionDTO.getDescripcion() != null)
                ? grupoOpcionDTO.getDescripcion() : null);
            grupoOpcion.setFechaCreacion(grupoOpcionDTO.getFechaCreacion());
            grupoOpcion.setFechaModificacion(grupoOpcionDTO.getFechaModificacion());
            grupoOpcion.setIcon((grupoOpcionDTO.getIcon() != null)
                ? grupoOpcionDTO.getIcon() : null);
            grupoOpcion.setNombre((grupoOpcionDTO.getNombre() != null)
                ? grupoOpcionDTO.getNombre() : null);
            grupoOpcion.setUsuCreador((grupoOpcionDTO.getUsuCreador() != null)
                ? grupoOpcionDTO.getUsuCreador() : null);
            grupoOpcion.setUsuModificador((grupoOpcionDTO.getUsuModificador() != null)
                ? grupoOpcionDTO.getUsuModificador() : null);

            return grupoOpcion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GrupoOpcionDTO> listGrupoOpcionToListGrupoOpcionDTO(
        List<GrupoOpcion> listGrupoOpcion) throws Exception {
        try {
            List<GrupoOpcionDTO> grupoOpcionDTOs = new ArrayList<GrupoOpcionDTO>();

            for (GrupoOpcion grupoOpcion : listGrupoOpcion) {
                GrupoOpcionDTO grupoOpcionDTO = grupoOpcionToGrupoOpcionDTO(grupoOpcion);

                grupoOpcionDTOs.add(grupoOpcionDTO);
            }

            return grupoOpcionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<GrupoOpcion> listGrupoOpcionDTOToListGrupoOpcion(
        List<GrupoOpcionDTO> listGrupoOpcionDTO) throws Exception {
        try {
            List<GrupoOpcion> listGrupoOpcion = new ArrayList<GrupoOpcion>();

            for (GrupoOpcionDTO grupoOpcionDTO : listGrupoOpcionDTO) {
                GrupoOpcion grupoOpcion = grupoOpcionDTOToGrupoOpcion(grupoOpcionDTO);

                listGrupoOpcion.add(grupoOpcion);
            }

            return listGrupoOpcion;
        } catch (Exception e) {
            throw e;
        }
    }
}
