package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.TipoPregunta;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.TipoPreguntaDTO;

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
public class TipoPreguntaMapper implements ITipoPreguntaMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoPreguntaMapper.class);

    @Transactional(readOnly = true)
    public TipoPreguntaDTO tipoPreguntaToTipoPreguntaDTO(
        TipoPregunta tipoPregunta) throws Exception {
        try {
            TipoPreguntaDTO tipoPreguntaDTO = new TipoPreguntaDTO();

            tipoPreguntaDTO.setIdTipoPregunta(tipoPregunta.getIdTipoPregunta());
            tipoPreguntaDTO.setActivo((tipoPregunta.getActivo() != null)
                ? tipoPregunta.getActivo() : null);
            tipoPreguntaDTO.setDescripcion((tipoPregunta.getDescripcion() != null)
                ? tipoPregunta.getDescripcion() : null);
            tipoPreguntaDTO.setFechaCreacion(tipoPregunta.getFechaCreacion());
            tipoPreguntaDTO.setFechaModificacion(tipoPregunta.getFechaModificacion());
            tipoPreguntaDTO.setNombre((tipoPregunta.getNombre() != null)
                ? tipoPregunta.getNombre() : null);
            tipoPreguntaDTO.setUsuCreador((tipoPregunta.getUsuCreador() != null)
                ? tipoPregunta.getUsuCreador() : null);
            tipoPreguntaDTO.setUsuModificador((tipoPregunta.getUsuModificador() != null)
                ? tipoPregunta.getUsuModificador() : null);

            return tipoPreguntaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoPregunta tipoPreguntaDTOToTipoPregunta(
        TipoPreguntaDTO tipoPreguntaDTO) throws Exception {
        try {
            TipoPregunta tipoPregunta = new TipoPregunta();

            tipoPregunta.setIdTipoPregunta(tipoPreguntaDTO.getIdTipoPregunta());
            tipoPregunta.setActivo((tipoPreguntaDTO.getActivo() != null)
                ? tipoPreguntaDTO.getActivo() : null);
            tipoPregunta.setDescripcion((tipoPreguntaDTO.getDescripcion() != null)
                ? tipoPreguntaDTO.getDescripcion() : null);
            tipoPregunta.setFechaCreacion(tipoPreguntaDTO.getFechaCreacion());
            tipoPregunta.setFechaModificacion(tipoPreguntaDTO.getFechaModificacion());
            tipoPregunta.setNombre((tipoPreguntaDTO.getNombre() != null)
                ? tipoPreguntaDTO.getNombre() : null);
            tipoPregunta.setUsuCreador((tipoPreguntaDTO.getUsuCreador() != null)
                ? tipoPreguntaDTO.getUsuCreador() : null);
            tipoPregunta.setUsuModificador((tipoPreguntaDTO.getUsuModificador() != null)
                ? tipoPreguntaDTO.getUsuModificador() : null);

            return tipoPregunta;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoPreguntaDTO> listTipoPreguntaToListTipoPreguntaDTO(
        List<TipoPregunta> listTipoPregunta) throws Exception {
        try {
            List<TipoPreguntaDTO> tipoPreguntaDTOs = new ArrayList<TipoPreguntaDTO>();

            for (TipoPregunta tipoPregunta : listTipoPregunta) {
                TipoPreguntaDTO tipoPreguntaDTO = tipoPreguntaToTipoPreguntaDTO(tipoPregunta);

                tipoPreguntaDTOs.add(tipoPreguntaDTO);
            }

            return tipoPreguntaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoPregunta> listTipoPreguntaDTOToListTipoPregunta(
        List<TipoPreguntaDTO> listTipoPreguntaDTO) throws Exception {
        try {
            List<TipoPregunta> listTipoPregunta = new ArrayList<TipoPregunta>();

            for (TipoPreguntaDTO tipoPreguntaDTO : listTipoPreguntaDTO) {
                TipoPregunta tipoPregunta = tipoPreguntaDTOToTipoPregunta(tipoPreguntaDTO);

                listTipoPregunta.add(tipoPregunta);
            }

            return listTipoPregunta;
        } catch (Exception e) {
            throw e;
        }
    }
}
