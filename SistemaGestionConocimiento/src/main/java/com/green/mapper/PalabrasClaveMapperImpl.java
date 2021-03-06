package com.green.mapper;

import com.green.dto.PalabrasClaveDTO;

import com.green.modelo.*;
import com.green.modelo.PalabrasClave;

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
public class PalabrasClaveMapperImpl implements PalabrasClaveMapper {
    private static final Logger log = LoggerFactory.getLogger(PalabrasClaveMapperImpl.class);

    @Transactional(readOnly = true)
    public PalabrasClaveDTO palabrasClaveToPalabrasClaveDTO(
        PalabrasClave palabrasClave) throws Exception {
        try {
            PalabrasClaveDTO palabrasClaveDTO = new PalabrasClaveDTO();

            palabrasClaveDTO.setIdPalabraClave(palabrasClave.getIdPalabraClave());
            palabrasClaveDTO.setActivo((palabrasClave.getActivo() != null)
                ? palabrasClave.getActivo() : null);
            palabrasClaveDTO.setDescripcion((palabrasClave.getDescripcion() != null)
                ? palabrasClave.getDescripcion() : null);
            palabrasClaveDTO.setFechaCreacion(palabrasClave.getFechaCreacion());
            palabrasClaveDTO.setFechaModificacion(palabrasClave.getFechaModificacion());
            palabrasClaveDTO.setNombre((palabrasClave.getNombre() != null)
                ? palabrasClave.getNombre() : null);
            palabrasClaveDTO.setUsuCreador((palabrasClave.getUsuCreador() != null)
                ? palabrasClave.getUsuCreador() : null);
            palabrasClaveDTO.setUsuModificador((palabrasClave.getUsuModificador() != null)
                ? palabrasClave.getUsuModificador() : null);

            return palabrasClaveDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public PalabrasClave palabrasClaveDTOToPalabrasClave(
        PalabrasClaveDTO palabrasClaveDTO) throws Exception {
        try {
            PalabrasClave palabrasClave = new PalabrasClave();

            palabrasClave.setIdPalabraClave(palabrasClaveDTO.getIdPalabraClave());
            palabrasClave.setActivo((palabrasClaveDTO.getActivo() != null)
                ? palabrasClaveDTO.getActivo() : null);
            palabrasClave.setDescripcion((palabrasClaveDTO.getDescripcion() != null)
                ? palabrasClaveDTO.getDescripcion() : null);
            palabrasClave.setFechaCreacion(palabrasClaveDTO.getFechaCreacion());
            palabrasClave.setFechaModificacion(palabrasClaveDTO.getFechaModificacion());
            palabrasClave.setNombre((palabrasClaveDTO.getNombre() != null)
                ? palabrasClaveDTO.getNombre() : null);
            palabrasClave.setUsuCreador((palabrasClaveDTO.getUsuCreador() != null)
                ? palabrasClaveDTO.getUsuCreador() : null);
            palabrasClave.setUsuModificador((palabrasClaveDTO.getUsuModificador() != null)
                ? palabrasClaveDTO.getUsuModificador() : null);

            return palabrasClave;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PalabrasClaveDTO> listPalabrasClaveToListPalabrasClaveDTO(
        List<PalabrasClave> listPalabrasClave) throws Exception {
        try {
            List<PalabrasClaveDTO> palabrasClaveDTOs = new ArrayList<PalabrasClaveDTO>();

            for (PalabrasClave palabrasClave : listPalabrasClave) {
                PalabrasClaveDTO palabrasClaveDTO = palabrasClaveToPalabrasClaveDTO(palabrasClave);

                palabrasClaveDTOs.add(palabrasClaveDTO);
            }

            return palabrasClaveDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PalabrasClave> listPalabrasClaveDTOToListPalabrasClave(
        List<PalabrasClaveDTO> listPalabrasClaveDTO) throws Exception {
        try {
            List<PalabrasClave> listPalabrasClave = new ArrayList<PalabrasClave>();

            for (PalabrasClaveDTO palabrasClaveDTO : listPalabrasClaveDTO) {
                PalabrasClave palabrasClave = palabrasClaveDTOToPalabrasClave(palabrasClaveDTO);

                listPalabrasClave.add(palabrasClave);
            }

            return listPalabrasClave;
        } catch (Exception e) {
            throw e;
        }
    }
}
