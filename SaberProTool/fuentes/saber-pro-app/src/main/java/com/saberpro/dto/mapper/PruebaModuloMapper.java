package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.PruebaModulo;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.PruebaModuloDTO;

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
public class PruebaModuloMapper implements IPruebaModuloMapper {
    private static final Logger log = LoggerFactory.getLogger(PruebaModuloMapper.class);

    /**
    * Logic injected by Spring that manages Modulo entities
    *
    */
    @Autowired
    IModuloLogic logicModulo1;

    /**
    * Logic injected by Spring that manages Prueba entities
    *
    */
    @Autowired
    IPruebaLogic logicPrueba2;

    @Transactional(readOnly = true)
    public PruebaModuloDTO pruebaModuloToPruebaModuloDTO(
        PruebaModulo pruebaModulo) throws Exception {
        try {
            PruebaModuloDTO pruebaModuloDTO = new PruebaModuloDTO();

            pruebaModuloDTO.setIdPruebaModulo(pruebaModulo.getIdPruebaModulo());
            pruebaModuloDTO.setActivo((pruebaModulo.getActivo() != null)
                ? pruebaModulo.getActivo() : null);
            pruebaModuloDTO.setFechaCreacion(pruebaModulo.getFechaCreacion());
            pruebaModuloDTO.setFechaModificacion(pruebaModulo.getFechaModificacion());
            pruebaModuloDTO.setNumeroPreguntas((pruebaModulo.getNumeroPreguntas() != null)
                ? pruebaModulo.getNumeroPreguntas() : null);
            pruebaModuloDTO.setUsuCreador((pruebaModulo.getUsuCreador() != null)
                ? pruebaModulo.getUsuCreador() : null);
            pruebaModuloDTO.setUsuModificador((pruebaModulo.getUsuModificador() != null)
                ? pruebaModulo.getUsuModificador() : null);
            pruebaModuloDTO.setIdModulo_Modulo((pruebaModulo.getModulo()
                                                            .getIdModulo() != null)
                ? pruebaModulo.getModulo().getIdModulo() : null);
            pruebaModuloDTO.setIdPrueba_Prueba((pruebaModulo.getPrueba()
                                                            .getIdPrueba() != null)
                ? pruebaModulo.getPrueba().getIdPrueba() : null);

            return pruebaModuloDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public PruebaModulo pruebaModuloDTOToPruebaModulo(
        PruebaModuloDTO pruebaModuloDTO) throws Exception {
        try {
            PruebaModulo pruebaModulo = new PruebaModulo();

            pruebaModulo.setIdPruebaModulo(pruebaModuloDTO.getIdPruebaModulo());
            pruebaModulo.setActivo((pruebaModuloDTO.getActivo() != null)
                ? pruebaModuloDTO.getActivo() : null);
            pruebaModulo.setFechaCreacion(pruebaModuloDTO.getFechaCreacion());
            pruebaModulo.setFechaModificacion(pruebaModuloDTO.getFechaModificacion());
            pruebaModulo.setNumeroPreguntas((pruebaModuloDTO.getNumeroPreguntas() != null)
                ? pruebaModuloDTO.getNumeroPreguntas() : null);
            pruebaModulo.setUsuCreador((pruebaModuloDTO.getUsuCreador() != null)
                ? pruebaModuloDTO.getUsuCreador() : null);
            pruebaModulo.setUsuModificador((pruebaModuloDTO.getUsuModificador() != null)
                ? pruebaModuloDTO.getUsuModificador() : null);

            Modulo modulo = new Modulo();

            if (pruebaModuloDTO.getIdModulo_Modulo() != null) {
                modulo = logicModulo1.getModulo(pruebaModuloDTO.getIdModulo_Modulo());
            }

            if (modulo != null) {
                pruebaModulo.setModulo(modulo);
            }

            Prueba prueba = new Prueba();

            if (pruebaModuloDTO.getIdPrueba_Prueba() != null) {
                prueba = logicPrueba2.getPrueba(pruebaModuloDTO.getIdPrueba_Prueba());
            }

            if (prueba != null) {
                pruebaModulo.setPrueba(prueba);
            }

            return pruebaModulo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PruebaModuloDTO> listPruebaModuloToListPruebaModuloDTO(
        List<PruebaModulo> listPruebaModulo) throws Exception {
        try {
            List<PruebaModuloDTO> pruebaModuloDTOs = new ArrayList<PruebaModuloDTO>();

            for (PruebaModulo pruebaModulo : listPruebaModulo) {
                PruebaModuloDTO pruebaModuloDTO = pruebaModuloToPruebaModuloDTO(pruebaModulo);

                pruebaModuloDTOs.add(pruebaModuloDTO);
            }

            return pruebaModuloDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PruebaModulo> listPruebaModuloDTOToListPruebaModulo(
        List<PruebaModuloDTO> listPruebaModuloDTO) throws Exception {
        try {
            List<PruebaModulo> listPruebaModulo = new ArrayList<PruebaModulo>();

            for (PruebaModuloDTO pruebaModuloDTO : listPruebaModuloDTO) {
                PruebaModulo pruebaModulo = pruebaModuloDTOToPruebaModulo(pruebaModuloDTO);

                listPruebaModulo.add(pruebaModulo);
            }

            return listPruebaModulo;
        } catch (Exception e) {
            throw e;
        }
    }
}
