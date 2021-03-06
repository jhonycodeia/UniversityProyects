package com.green.mapper;

import com.green.dto.TipoCapsulaDTO;

import com.green.modelo.*;
import com.green.modelo.TipoCapsula;

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
public class TipoCapsulaMapperImpl implements TipoCapsulaMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoCapsulaMapperImpl.class);

    @Transactional(readOnly = true)
    public TipoCapsulaDTO tipoCapsulaToTipoCapsulaDTO(TipoCapsula tipoCapsula)
        throws Exception {
        try {
            TipoCapsulaDTO tipoCapsulaDTO = new TipoCapsulaDTO();

            tipoCapsulaDTO.setIdTipoCapsula(tipoCapsula.getIdTipoCapsula());
            tipoCapsulaDTO.setActivo((tipoCapsula.getActivo() != null)
                ? tipoCapsula.getActivo() : null);
            tipoCapsulaDTO.setDescripcion((tipoCapsula.getDescripcion() != null)
                ? tipoCapsula.getDescripcion() : null);
            tipoCapsulaDTO.setFechaCreacion(tipoCapsula.getFechaCreacion());
            tipoCapsulaDTO.setFechaModificacion(tipoCapsula.getFechaModificacion());
            tipoCapsulaDTO.setNombre((tipoCapsula.getNombre() != null)
                ? tipoCapsula.getNombre() : null);
            tipoCapsulaDTO.setUsuCreador((tipoCapsula.getUsuCreador() != null)
                ? tipoCapsula.getUsuCreador() : null);
            tipoCapsulaDTO.setUsuModificador((tipoCapsula.getUsuModificador() != null)
                ? tipoCapsula.getUsuModificador() : null);

            return tipoCapsulaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoCapsula tipoCapsulaDTOToTipoCapsula(
        TipoCapsulaDTO tipoCapsulaDTO) throws Exception {
        try {
            TipoCapsula tipoCapsula = new TipoCapsula();

            tipoCapsula.setIdTipoCapsula(tipoCapsulaDTO.getIdTipoCapsula());
            tipoCapsula.setActivo((tipoCapsulaDTO.getActivo() != null)
                ? tipoCapsulaDTO.getActivo() : null);
            tipoCapsula.setDescripcion((tipoCapsulaDTO.getDescripcion() != null)
                ? tipoCapsulaDTO.getDescripcion() : null);
            tipoCapsula.setFechaCreacion(tipoCapsulaDTO.getFechaCreacion());
            tipoCapsula.setFechaModificacion(tipoCapsulaDTO.getFechaModificacion());
            tipoCapsula.setNombre((tipoCapsulaDTO.getNombre() != null)
                ? tipoCapsulaDTO.getNombre() : null);
            tipoCapsula.setUsuCreador((tipoCapsulaDTO.getUsuCreador() != null)
                ? tipoCapsulaDTO.getUsuCreador() : null);
            tipoCapsula.setUsuModificador((tipoCapsulaDTO.getUsuModificador() != null)
                ? tipoCapsulaDTO.getUsuModificador() : null);

            return tipoCapsula;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoCapsulaDTO> listTipoCapsulaToListTipoCapsulaDTO(
        List<TipoCapsula> listTipoCapsula) throws Exception {
        try {
            List<TipoCapsulaDTO> tipoCapsulaDTOs = new ArrayList<TipoCapsulaDTO>();

            for (TipoCapsula tipoCapsula : listTipoCapsula) {
                TipoCapsulaDTO tipoCapsulaDTO = tipoCapsulaToTipoCapsulaDTO(tipoCapsula);

                tipoCapsulaDTOs.add(tipoCapsulaDTO);
            }

            return tipoCapsulaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoCapsula> listTipoCapsulaDTOToListTipoCapsula(
        List<TipoCapsulaDTO> listTipoCapsulaDTO) throws Exception {
        try {
            List<TipoCapsula> listTipoCapsula = new ArrayList<TipoCapsula>();

            for (TipoCapsulaDTO tipoCapsulaDTO : listTipoCapsulaDTO) {
                TipoCapsula tipoCapsula = tipoCapsulaDTOToTipoCapsula(tipoCapsulaDTO);

                listTipoCapsula.add(tipoCapsula);
            }

            return listTipoCapsula;
        } catch (Exception e) {
            throw e;
        }
    }
}
