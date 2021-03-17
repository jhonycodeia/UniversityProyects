package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.Prueba;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.PruebaDTO;

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
public class PruebaMapper implements IPruebaMapper {
    private static final Logger log = LoggerFactory.getLogger(PruebaMapper.class);

    /**
    * Logic injected by Spring that manages TipoPrueba entities
    *
    */
    @Autowired
    ITipoPruebaLogic logicTipoPrueba1;

    @Transactional(readOnly = true)
    public PruebaDTO pruebaToPruebaDTO(Prueba prueba) throws Exception {
        try {
            PruebaDTO pruebaDTO = new PruebaDTO();

            pruebaDTO.setIdPrueba(prueba.getIdPrueba());
            pruebaDTO.setActivo((prueba.getActivo() != null)
                ? prueba.getActivo() : null);
            pruebaDTO.setFechaCreacion(prueba.getFechaCreacion());
            pruebaDTO.setFechaFinal(prueba.getFechaFinal());
            pruebaDTO.setFechaInicial(prueba.getFechaInicial());
            pruebaDTO.setFechaModificacion(prueba.getFechaModificacion());
            pruebaDTO.setTiempo((prueba.getTiempo() != null)
                ? prueba.getTiempo() : null);
            pruebaDTO.setUsuCreador((prueba.getUsuCreador() != null)
                ? prueba.getUsuCreador() : null);
            pruebaDTO.setUsuModificador((prueba.getUsuModificador() != null)
                ? prueba.getUsuModificador() : null);
            pruebaDTO.setIdTipoPrueba_TipoPrueba((prueba.getTipoPrueba()
                                                        .getIdTipoPrueba() != null)
                ? prueba.getTipoPrueba().getIdTipoPrueba() : null);

            return pruebaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Prueba pruebaDTOToPrueba(PruebaDTO pruebaDTO)
        throws Exception {
        try {
            Prueba prueba = new Prueba();

            prueba.setIdPrueba(pruebaDTO.getIdPrueba());
            prueba.setActivo((pruebaDTO.getActivo() != null)
                ? pruebaDTO.getActivo() : null);
            prueba.setFechaCreacion(pruebaDTO.getFechaCreacion());
            prueba.setFechaFinal(pruebaDTO.getFechaFinal());
            prueba.setFechaInicial(pruebaDTO.getFechaInicial());
            prueba.setFechaModificacion(pruebaDTO.getFechaModificacion());
            prueba.setTiempo((pruebaDTO.getTiempo() != null)
                ? pruebaDTO.getTiempo() : null);
            prueba.setUsuCreador((pruebaDTO.getUsuCreador() != null)
                ? pruebaDTO.getUsuCreador() : null);
            prueba.setUsuModificador((pruebaDTO.getUsuModificador() != null)
                ? pruebaDTO.getUsuModificador() : null);

            TipoPrueba tipoPrueba = new TipoPrueba();

            if (pruebaDTO.getIdTipoPrueba_TipoPrueba() != null) {
                tipoPrueba = logicTipoPrueba1.getTipoPrueba(pruebaDTO.getIdTipoPrueba_TipoPrueba());
            }

            if (tipoPrueba != null) {
                prueba.setTipoPrueba(tipoPrueba);
            }

            return prueba;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PruebaDTO> listPruebaToListPruebaDTO(List<Prueba> listPrueba)
        throws Exception {
        try {
            List<PruebaDTO> pruebaDTOs = new ArrayList<PruebaDTO>();

            for (Prueba prueba : listPrueba) {
                PruebaDTO pruebaDTO = pruebaToPruebaDTO(prueba);

                pruebaDTOs.add(pruebaDTO);
            }

            return pruebaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Prueba> listPruebaDTOToListPrueba(List<PruebaDTO> listPruebaDTO)
        throws Exception {
        try {
            List<Prueba> listPrueba = new ArrayList<Prueba>();

            for (PruebaDTO pruebaDTO : listPruebaDTO) {
                Prueba prueba = pruebaDTOToPrueba(pruebaDTO);

                listPrueba.add(prueba);
            }

            return listPrueba;
        } catch (Exception e) {
            throw e;
        }
    }
}
