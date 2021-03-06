package com.green.mapper;

import com.green.dto.TipoPuntosDTO;

import com.green.modelo.*;
import com.green.modelo.TipoPuntos;

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
public class TipoPuntosMapperImpl implements TipoPuntosMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoPuntosMapperImpl.class);

    @Transactional(readOnly = true)
    public TipoPuntosDTO tipoPuntosToTipoPuntosDTO(TipoPuntos tipoPuntos)
        throws Exception {
        try {
            TipoPuntosDTO tipoPuntosDTO = new TipoPuntosDTO();

            tipoPuntosDTO.setIdTipoPuntos(tipoPuntos.getIdTipoPuntos());
            tipoPuntosDTO.setActivo((tipoPuntos.getActivo() != null)
                ? tipoPuntos.getActivo() : null);
            tipoPuntosDTO.setDescripcion((tipoPuntos.getDescripcion() != null)
                ? tipoPuntos.getDescripcion() : null);
            tipoPuntosDTO.setFechaCreacion(tipoPuntos.getFechaCreacion());
            tipoPuntosDTO.setFechaModificacion(tipoPuntos.getFechaModificacion());
            tipoPuntosDTO.setNombre((tipoPuntos.getNombre() != null)
                ? tipoPuntos.getNombre() : null);
            tipoPuntosDTO.setUsuCreador((tipoPuntos.getUsuCreador() != null)
                ? tipoPuntos.getUsuCreador() : null);
            tipoPuntosDTO.setUsuModificador((tipoPuntos.getUsuModificador() != null)
                ? tipoPuntos.getUsuModificador() : null);

            return tipoPuntosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoPuntos tipoPuntosDTOToTipoPuntos(TipoPuntosDTO tipoPuntosDTO)
        throws Exception {
        try {
            TipoPuntos tipoPuntos = new TipoPuntos();

            tipoPuntos.setIdTipoPuntos(tipoPuntosDTO.getIdTipoPuntos());
            tipoPuntos.setActivo((tipoPuntosDTO.getActivo() != null)
                ? tipoPuntosDTO.getActivo() : null);
            tipoPuntos.setDescripcion((tipoPuntosDTO.getDescripcion() != null)
                ? tipoPuntosDTO.getDescripcion() : null);
            tipoPuntos.setFechaCreacion(tipoPuntosDTO.getFechaCreacion());
            tipoPuntos.setFechaModificacion(tipoPuntosDTO.getFechaModificacion());
            tipoPuntos.setNombre((tipoPuntosDTO.getNombre() != null)
                ? tipoPuntosDTO.getNombre() : null);
            tipoPuntos.setUsuCreador((tipoPuntosDTO.getUsuCreador() != null)
                ? tipoPuntosDTO.getUsuCreador() : null);
            tipoPuntos.setUsuModificador((tipoPuntosDTO.getUsuModificador() != null)
                ? tipoPuntosDTO.getUsuModificador() : null);

            return tipoPuntos;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoPuntosDTO> listTipoPuntosToListTipoPuntosDTO(
        List<TipoPuntos> listTipoPuntos) throws Exception {
        try {
            List<TipoPuntosDTO> tipoPuntosDTOs = new ArrayList<TipoPuntosDTO>();

            for (TipoPuntos tipoPuntos : listTipoPuntos) {
                TipoPuntosDTO tipoPuntosDTO = tipoPuntosToTipoPuntosDTO(tipoPuntos);

                tipoPuntosDTOs.add(tipoPuntosDTO);
            }

            return tipoPuntosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoPuntos> listTipoPuntosDTOToListTipoPuntos(
        List<TipoPuntosDTO> listTipoPuntosDTO) throws Exception {
        try {
            List<TipoPuntos> listTipoPuntos = new ArrayList<TipoPuntos>();

            for (TipoPuntosDTO tipoPuntosDTO : listTipoPuntosDTO) {
                TipoPuntos tipoPuntos = tipoPuntosDTOToTipoPuntos(tipoPuntosDTO);

                listTipoPuntos.add(tipoPuntos);
            }

            return listTipoPuntos;
        } catch (Exception e) {
            throw e;
        }
    }
}
