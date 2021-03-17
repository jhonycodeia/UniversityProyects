package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.FacultadDTO;

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
public class FacultadMapper implements IFacultadMapper {
    private static final Logger log = LoggerFactory.getLogger(FacultadMapper.class);

    @Transactional(readOnly = true)
    public FacultadDTO facultadToFacultadDTO(Facultad facultad)
        throws Exception {
        try {
            FacultadDTO facultadDTO = new FacultadDTO();

            facultadDTO.setIdFacultad(facultad.getIdFacultad());
            facultadDTO.setActivo((facultad.getActivo() != null)
                ? facultad.getActivo() : null);
            facultadDTO.setDescripcion((facultad.getDescripcion() != null)
                ? facultad.getDescripcion() : null);
            facultadDTO.setFechaCreacion(facultad.getFechaCreacion());
            facultadDTO.setFechaModificacion(facultad.getFechaModificacion());
            facultadDTO.setNombre((facultad.getNombre() != null)
                ? facultad.getNombre() : null);
            facultadDTO.setUsuCreador((facultad.getUsuCreador() != null)
                ? facultad.getUsuCreador() : null);
            facultadDTO.setUsuModificador((facultad.getUsuModificador() != null)
                ? facultad.getUsuModificador() : null);

            return facultadDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Facultad facultadDTOToFacultad(FacultadDTO facultadDTO)
        throws Exception {
        try {
            Facultad facultad = new Facultad();

            facultad.setIdFacultad(facultadDTO.getIdFacultad());
            facultad.setActivo((facultadDTO.getActivo() != null)
                ? facultadDTO.getActivo() : null);
            facultad.setDescripcion((facultadDTO.getDescripcion() != null)
                ? facultadDTO.getDescripcion() : null);
            facultad.setFechaCreacion(facultadDTO.getFechaCreacion());
            facultad.setFechaModificacion(facultadDTO.getFechaModificacion());
            facultad.setNombre((facultadDTO.getNombre() != null)
                ? facultadDTO.getNombre() : null);
            facultad.setUsuCreador((facultadDTO.getUsuCreador() != null)
                ? facultadDTO.getUsuCreador() : null);
            facultad.setUsuModificador((facultadDTO.getUsuModificador() != null)
                ? facultadDTO.getUsuModificador() : null);

            return facultad;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<FacultadDTO> listFacultadToListFacultadDTO(
        List<Facultad> listFacultad) throws Exception {
        try {
            List<FacultadDTO> facultadDTOs = new ArrayList<FacultadDTO>();

            for (Facultad facultad : listFacultad) {
                FacultadDTO facultadDTO = facultadToFacultadDTO(facultad);

                facultadDTOs.add(facultadDTO);
            }

            return facultadDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Facultad> listFacultadDTOToListFacultad(
        List<FacultadDTO> listFacultadDTO) throws Exception {
        try {
            List<Facultad> listFacultad = new ArrayList<Facultad>();

            for (FacultadDTO facultadDTO : listFacultadDTO) {
                Facultad facultad = facultadDTOToFacultad(facultadDTO);

                listFacultad.add(facultad);
            }

            return listFacultad;
        } catch (Exception e) {
            throw e;
        }
    }
}
