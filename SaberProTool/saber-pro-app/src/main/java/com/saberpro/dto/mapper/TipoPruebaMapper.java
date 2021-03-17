package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.TipoPrueba;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.TipoPruebaDTO;

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
public class TipoPruebaMapper implements ITipoPruebaMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoPruebaMapper.class);

    @Transactional(readOnly = true)
    public TipoPruebaDTO tipoPruebaToTipoPruebaDTO(TipoPrueba tipoPrueba)
        throws Exception {
        try {
            TipoPruebaDTO tipoPruebaDTO = new TipoPruebaDTO();

            tipoPruebaDTO.setIdTipoPrueba(tipoPrueba.getIdTipoPrueba());
            tipoPruebaDTO.setActivo((tipoPrueba.getActivo() != null)
                ? tipoPrueba.getActivo() : null);
            tipoPruebaDTO.setDescripcion((tipoPrueba.getDescripcion() != null)
                ? tipoPrueba.getDescripcion() : null);
            tipoPruebaDTO.setFechaCreacion(tipoPrueba.getFechaCreacion());
            tipoPruebaDTO.setFechaModificacion(tipoPrueba.getFechaModificacion());
            tipoPruebaDTO.setNombre((tipoPrueba.getNombre() != null)
                ? tipoPrueba.getNombre() : null);
            tipoPruebaDTO.setUsuCreador((tipoPrueba.getUsuCreador() != null)
                ? tipoPrueba.getUsuCreador() : null);
            tipoPruebaDTO.setUsuModificador((tipoPrueba.getUsuModificador() != null)
                ? tipoPrueba.getUsuModificador() : null);

            return tipoPruebaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoPrueba tipoPruebaDTOToTipoPrueba(TipoPruebaDTO tipoPruebaDTO)
        throws Exception {
        try {
            TipoPrueba tipoPrueba = new TipoPrueba();

            tipoPrueba.setIdTipoPrueba(tipoPruebaDTO.getIdTipoPrueba());
            tipoPrueba.setActivo((tipoPruebaDTO.getActivo() != null)
                ? tipoPruebaDTO.getActivo() : null);
            tipoPrueba.setDescripcion((tipoPruebaDTO.getDescripcion() != null)
                ? tipoPruebaDTO.getDescripcion() : null);
            tipoPrueba.setFechaCreacion(tipoPruebaDTO.getFechaCreacion());
            tipoPrueba.setFechaModificacion(tipoPruebaDTO.getFechaModificacion());
            tipoPrueba.setNombre((tipoPruebaDTO.getNombre() != null)
                ? tipoPruebaDTO.getNombre() : null);
            tipoPrueba.setUsuCreador((tipoPruebaDTO.getUsuCreador() != null)
                ? tipoPruebaDTO.getUsuCreador() : null);
            tipoPrueba.setUsuModificador((tipoPruebaDTO.getUsuModificador() != null)
                ? tipoPruebaDTO.getUsuModificador() : null);

            return tipoPrueba;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoPruebaDTO> listTipoPruebaToListTipoPruebaDTO(
        List<TipoPrueba> listTipoPrueba) throws Exception {
        try {
            List<TipoPruebaDTO> tipoPruebaDTOs = new ArrayList<TipoPruebaDTO>();

            for (TipoPrueba tipoPrueba : listTipoPrueba) {
                TipoPruebaDTO tipoPruebaDTO = tipoPruebaToTipoPruebaDTO(tipoPrueba);

                tipoPruebaDTOs.add(tipoPruebaDTO);
            }

            return tipoPruebaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoPrueba> listTipoPruebaDTOToListTipoPrueba(
        List<TipoPruebaDTO> listTipoPruebaDTO) throws Exception {
        try {
            List<TipoPrueba> listTipoPrueba = new ArrayList<TipoPrueba>();

            for (TipoPruebaDTO tipoPruebaDTO : listTipoPruebaDTO) {
                TipoPrueba tipoPrueba = tipoPruebaDTOToTipoPrueba(tipoPruebaDTO);

                listTipoPrueba.add(tipoPrueba);
            }

            return listTipoPrueba;
        } catch (Exception e) {
            throw e;
        }
    }
}
