package com.green.mapper;

import com.green.dto.CapsulaPalabrasClaveDTO;

import com.green.modelo.*;
import com.green.modelo.CapsulaPalabrasClave;

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
public class CapsulaPalabrasClaveMapperImpl
    implements CapsulaPalabrasClaveMapper {
    private static final Logger log = LoggerFactory.getLogger(CapsulaPalabrasClaveMapperImpl.class);

    /**
    * Service injected by Spring that manages Capsula entities
    *
    */
    @Autowired
    CapsulaService serviceCapsula1;

    /**
    * Service injected by Spring that manages PalabrasClave entities
    *
    */
    @Autowired
    PalabrasClaveService servicePalabrasClave2;

    @Transactional(readOnly = true)
    public CapsulaPalabrasClaveDTO capsulaPalabrasClaveToCapsulaPalabrasClaveDTO(
        CapsulaPalabrasClave capsulaPalabrasClave) throws Exception {
        try {
            CapsulaPalabrasClaveDTO capsulaPalabrasClaveDTO = new CapsulaPalabrasClaveDTO();

            capsulaPalabrasClaveDTO.setIdCapsulaPalabraClave(capsulaPalabrasClave.getIdCapsulaPalabraClave());
            capsulaPalabrasClaveDTO.setActivo((capsulaPalabrasClave.getActivo() != null)
                ? capsulaPalabrasClave.getActivo() : null);
            capsulaPalabrasClaveDTO.setDescripcion((capsulaPalabrasClave.getDescripcion() != null)
                ? capsulaPalabrasClave.getDescripcion() : null);
            capsulaPalabrasClaveDTO.setFechaCreacion(capsulaPalabrasClave.getFechaCreacion());
            capsulaPalabrasClaveDTO.setFechaModificacion(capsulaPalabrasClave.getFechaModificacion());
            capsulaPalabrasClaveDTO.setNombre((capsulaPalabrasClave.getNombre() != null)
                ? capsulaPalabrasClave.getNombre() : null);
            capsulaPalabrasClaveDTO.setUsuCreador((capsulaPalabrasClave.getUsuCreador() != null)
                ? capsulaPalabrasClave.getUsuCreador() : null);
            capsulaPalabrasClaveDTO.setUsuModificador((capsulaPalabrasClave.getUsuModificador() != null)
                ? capsulaPalabrasClave.getUsuModificador() : null);
            capsulaPalabrasClaveDTO.setIdCapsula_Capsula((capsulaPalabrasClave.getCapsula()
                                                                              .getIdCapsula() != null)
                ? capsulaPalabrasClave.getCapsula().getIdCapsula() : null);
            capsulaPalabrasClaveDTO.setIdPalabraClave_PalabrasClave((capsulaPalabrasClave.getPalabrasClave()
                                                                                         .getIdPalabraClave() != null)
                ? capsulaPalabrasClave.getPalabrasClave().getIdPalabraClave()
                : null);

            return capsulaPalabrasClaveDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public CapsulaPalabrasClave capsulaPalabrasClaveDTOToCapsulaPalabrasClave(
        CapsulaPalabrasClaveDTO capsulaPalabrasClaveDTO)
        throws Exception {
        try {
            CapsulaPalabrasClave capsulaPalabrasClave = new CapsulaPalabrasClave();

            capsulaPalabrasClave.setIdCapsulaPalabraClave(capsulaPalabrasClaveDTO.getIdCapsulaPalabraClave());
            capsulaPalabrasClave.setActivo((capsulaPalabrasClaveDTO.getActivo() != null)
                ? capsulaPalabrasClaveDTO.getActivo() : null);
            capsulaPalabrasClave.setDescripcion((capsulaPalabrasClaveDTO.getDescripcion() != null)
                ? capsulaPalabrasClaveDTO.getDescripcion() : null);
            capsulaPalabrasClave.setFechaCreacion(capsulaPalabrasClaveDTO.getFechaCreacion());
            capsulaPalabrasClave.setFechaModificacion(capsulaPalabrasClaveDTO.getFechaModificacion());
            capsulaPalabrasClave.setNombre((capsulaPalabrasClaveDTO.getNombre() != null)
                ? capsulaPalabrasClaveDTO.getNombre() : null);
            capsulaPalabrasClave.setUsuCreador((capsulaPalabrasClaveDTO.getUsuCreador() != null)
                ? capsulaPalabrasClaveDTO.getUsuCreador() : null);
            capsulaPalabrasClave.setUsuModificador((capsulaPalabrasClaveDTO.getUsuModificador() != null)
                ? capsulaPalabrasClaveDTO.getUsuModificador() : null);

            Capsula capsula = new Capsula();

            if (capsulaPalabrasClaveDTO.getIdCapsula_Capsula() != null) {
                capsula = serviceCapsula1.getCapsula(capsulaPalabrasClaveDTO.getIdCapsula_Capsula());
            }

            if (capsula != null) {
                capsulaPalabrasClave.setCapsula(capsula);
            }

            PalabrasClave palabrasClave = new PalabrasClave();

            if (capsulaPalabrasClaveDTO.getIdPalabraClave_PalabrasClave() != null) {
                palabrasClave = servicePalabrasClave2.getPalabrasClave(capsulaPalabrasClaveDTO.getIdPalabraClave_PalabrasClave());
            }

            if (palabrasClave != null) {
                capsulaPalabrasClave.setPalabrasClave(palabrasClave);
            }

            return capsulaPalabrasClave;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CapsulaPalabrasClaveDTO> listCapsulaPalabrasClaveToListCapsulaPalabrasClaveDTO(
        List<CapsulaPalabrasClave> listCapsulaPalabrasClave)
        throws Exception {
        try {
            List<CapsulaPalabrasClaveDTO> capsulaPalabrasClaveDTOs = new ArrayList<CapsulaPalabrasClaveDTO>();

            for (CapsulaPalabrasClave capsulaPalabrasClave : listCapsulaPalabrasClave) {
                CapsulaPalabrasClaveDTO capsulaPalabrasClaveDTO = capsulaPalabrasClaveToCapsulaPalabrasClaveDTO(capsulaPalabrasClave);

                capsulaPalabrasClaveDTOs.add(capsulaPalabrasClaveDTO);
            }

            return capsulaPalabrasClaveDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CapsulaPalabrasClave> listCapsulaPalabrasClaveDTOToListCapsulaPalabrasClave(
        List<CapsulaPalabrasClaveDTO> listCapsulaPalabrasClaveDTO)
        throws Exception {
        try {
            List<CapsulaPalabrasClave> listCapsulaPalabrasClave = new ArrayList<CapsulaPalabrasClave>();

            for (CapsulaPalabrasClaveDTO capsulaPalabrasClaveDTO : listCapsulaPalabrasClaveDTO) {
                CapsulaPalabrasClave capsulaPalabrasClave = capsulaPalabrasClaveDTOToCapsulaPalabrasClave(capsulaPalabrasClaveDTO);

                listCapsulaPalabrasClave.add(capsulaPalabrasClave);
            }

            return listCapsulaPalabrasClave;
        } catch (Exception e) {
            throw e;
        }
    }
}
