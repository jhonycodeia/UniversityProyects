package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.TipoModulo;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.TipoModuloDTO;

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
public class TipoModuloMapper implements ITipoModuloMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoModuloMapper.class);

    @Transactional(readOnly = true)
    public TipoModuloDTO tipoModuloToTipoModuloDTO(TipoModulo tipoModulo)
        throws Exception {
        try {
            TipoModuloDTO tipoModuloDTO = new TipoModuloDTO();

            tipoModuloDTO.setIdTipoModulo(tipoModulo.getIdTipoModulo());
            tipoModuloDTO.setActivo((tipoModulo.getActivo() != null)
                ? tipoModulo.getActivo() : null);
            tipoModuloDTO.setDescripcion((tipoModulo.getDescripcion() != null)
                ? tipoModulo.getDescripcion() : null);
            tipoModuloDTO.setFechaCreacion(tipoModulo.getFechaCreacion());
            tipoModuloDTO.setFechaModificacion(tipoModulo.getFechaModificacion());
            tipoModuloDTO.setNombre((tipoModulo.getNombre() != null)
                ? tipoModulo.getNombre() : null);
            tipoModuloDTO.setUsuCreador((tipoModulo.getUsuCreador() != null)
                ? tipoModulo.getUsuCreador() : null);
            tipoModuloDTO.setUsuModificador((tipoModulo.getUsuModificador() != null)
                ? tipoModulo.getUsuModificador() : null);

            return tipoModuloDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoModulo tipoModuloDTOToTipoModulo(TipoModuloDTO tipoModuloDTO)
        throws Exception {
        try {
            TipoModulo tipoModulo = new TipoModulo();

            tipoModulo.setIdTipoModulo(tipoModuloDTO.getIdTipoModulo());
            tipoModulo.setActivo((tipoModuloDTO.getActivo() != null)
                ? tipoModuloDTO.getActivo() : null);
            tipoModulo.setDescripcion((tipoModuloDTO.getDescripcion() != null)
                ? tipoModuloDTO.getDescripcion() : null);
            tipoModulo.setFechaCreacion(tipoModuloDTO.getFechaCreacion());
            tipoModulo.setFechaModificacion(tipoModuloDTO.getFechaModificacion());
            tipoModulo.setNombre((tipoModuloDTO.getNombre() != null)
                ? tipoModuloDTO.getNombre() : null);
            tipoModulo.setUsuCreador((tipoModuloDTO.getUsuCreador() != null)
                ? tipoModuloDTO.getUsuCreador() : null);
            tipoModulo.setUsuModificador((tipoModuloDTO.getUsuModificador() != null)
                ? tipoModuloDTO.getUsuModificador() : null);

            return tipoModulo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoModuloDTO> listTipoModuloToListTipoModuloDTO(
        List<TipoModulo> listTipoModulo) throws Exception {
        try {
            List<TipoModuloDTO> tipoModuloDTOs = new ArrayList<TipoModuloDTO>();

            for (TipoModulo tipoModulo : listTipoModulo) {
                TipoModuloDTO tipoModuloDTO = tipoModuloToTipoModuloDTO(tipoModulo);

                tipoModuloDTOs.add(tipoModuloDTO);
            }

            return tipoModuloDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoModulo> listTipoModuloDTOToListTipoModulo(
        List<TipoModuloDTO> listTipoModuloDTO) throws Exception {
        try {
            List<TipoModulo> listTipoModulo = new ArrayList<TipoModulo>();

            for (TipoModuloDTO tipoModuloDTO : listTipoModuloDTO) {
                TipoModulo tipoModulo = tipoModuloDTOToTipoModulo(tipoModuloDTO);

                listTipoModulo.add(tipoModulo);
            }

            return listTipoModulo;
        } catch (Exception e) {
            throw e;
        }
    }
}
