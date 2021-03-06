package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.PruebaReal;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.PruebaRealDTO;

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
public class PruebaRealMapper implements IPruebaRealMapper {
    private static final Logger log = LoggerFactory.getLogger(PruebaRealMapper.class);

    @Transactional(readOnly = true)
    public PruebaRealDTO pruebaRealToPruebaRealDTO(PruebaReal pruebaReal)
        throws Exception {
        try {
            PruebaRealDTO pruebaRealDTO = new PruebaRealDTO();

            pruebaRealDTO.setIdPruebaReal(pruebaReal.getIdPruebaReal());
            pruebaRealDTO.setActivo((pruebaReal.getActivo() != null)
                ? pruebaReal.getActivo() : null);
            pruebaRealDTO.setFecha(pruebaReal.getFecha());
            pruebaRealDTO.setFechaCreacion(pruebaReal.getFechaCreacion());
            pruebaRealDTO.setFechaModificacion(pruebaReal.getFechaModificacion());
            pruebaRealDTO.setUsuCreador((pruebaReal.getUsuCreador() != null)
                ? pruebaReal.getUsuCreador() : null);
            pruebaRealDTO.setUsuModificador((pruebaReal.getUsuModificador() != null)
                ? pruebaReal.getUsuModificador() : null);

            return pruebaRealDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public PruebaReal pruebaRealDTOToPruebaReal(PruebaRealDTO pruebaRealDTO)
        throws Exception {
        try {
            PruebaReal pruebaReal = new PruebaReal();

            pruebaReal.setIdPruebaReal(pruebaRealDTO.getIdPruebaReal());
            pruebaReal.setActivo((pruebaRealDTO.getActivo() != null)
                ? pruebaRealDTO.getActivo() : null);
            pruebaReal.setFecha(pruebaRealDTO.getFecha());
            pruebaReal.setFechaCreacion(pruebaRealDTO.getFechaCreacion());
            pruebaReal.setFechaModificacion(pruebaRealDTO.getFechaModificacion());
            pruebaReal.setUsuCreador((pruebaRealDTO.getUsuCreador() != null)
                ? pruebaRealDTO.getUsuCreador() : null);
            pruebaReal.setUsuModificador((pruebaRealDTO.getUsuModificador() != null)
                ? pruebaRealDTO.getUsuModificador() : null);

            return pruebaReal;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PruebaRealDTO> listPruebaRealToListPruebaRealDTO(
        List<PruebaReal> listPruebaReal) throws Exception {
        try {
            List<PruebaRealDTO> pruebaRealDTOs = new ArrayList<PruebaRealDTO>();

            for (PruebaReal pruebaReal : listPruebaReal) {
                PruebaRealDTO pruebaRealDTO = pruebaRealToPruebaRealDTO(pruebaReal);

                pruebaRealDTOs.add(pruebaRealDTO);
            }

            return pruebaRealDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PruebaReal> listPruebaRealDTOToListPruebaReal(
        List<PruebaRealDTO> listPruebaRealDTO) throws Exception {
        try {
            List<PruebaReal> listPruebaReal = new ArrayList<PruebaReal>();

            for (PruebaRealDTO pruebaRealDTO : listPruebaRealDTO) {
                PruebaReal pruebaReal = pruebaRealDTOToPruebaReal(pruebaRealDTO);

                listPruebaReal.add(pruebaReal);
            }

            return listPruebaReal;
        } catch (Exception e) {
            throw e;
        }
    }
}
