package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.Modulo;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.ModuloDTO;

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
public class ModuloMapper implements IModuloMapper {
    private static final Logger log = LoggerFactory.getLogger(ModuloMapper.class);

    /**
    * Logic injected by Spring that manages TipoModulo entities
    *
    */
    @Autowired
    ITipoModuloLogic logicTipoModulo1;

    @Transactional(readOnly = true)
    public ModuloDTO moduloToModuloDTO(Modulo modulo) throws Exception {
        try {
            ModuloDTO moduloDTO = new ModuloDTO();

            moduloDTO.setIdModulo(modulo.getIdModulo());
            moduloDTO.setActivo((modulo.getActivo() != null)
                ? modulo.getActivo() : null);
            moduloDTO.setCantidadPreguntas((modulo.getCantidadPreguntas() != null)
                ? modulo.getCantidadPreguntas() : null);
            moduloDTO.setDescripcion((modulo.getDescripcion() != null)
                ? modulo.getDescripcion() : null);
            moduloDTO.setFechaCreacion(modulo.getFechaCreacion());
            moduloDTO.setFechaModificacion(modulo.getFechaModificacion());
            moduloDTO.setNombre((modulo.getNombre() != null)
                ? modulo.getNombre() : null);
            moduloDTO.setPrioridad((modulo.getPrioridad() != null)
                ? modulo.getPrioridad() : null);
            moduloDTO.setUsuCreador((modulo.getUsuCreador() != null)
                ? modulo.getUsuCreador() : null);
            moduloDTO.setUsuModificador((modulo.getUsuModificador() != null)
                ? modulo.getUsuModificador() : null);
            moduloDTO.setIdTipoModulo_TipoModulo((modulo.getTipoModulo()
                                                        .getIdTipoModulo() != null)
                ? modulo.getTipoModulo().getIdTipoModulo() : null);

            return moduloDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Modulo moduloDTOToModulo(ModuloDTO moduloDTO)
        throws Exception {
        try {
            Modulo modulo = new Modulo();

            modulo.setIdModulo(moduloDTO.getIdModulo());
            modulo.setActivo((moduloDTO.getActivo() != null)
                ? moduloDTO.getActivo() : null);
            modulo.setCantidadPreguntas((moduloDTO.getCantidadPreguntas() != null)
                ? moduloDTO.getCantidadPreguntas() : null);
            modulo.setDescripcion((moduloDTO.getDescripcion() != null)
                ? moduloDTO.getDescripcion() : null);
            modulo.setFechaCreacion(moduloDTO.getFechaCreacion());
            modulo.setFechaModificacion(moduloDTO.getFechaModificacion());
            modulo.setNombre((moduloDTO.getNombre() != null)
                ? moduloDTO.getNombre() : null);
            modulo.setPrioridad((moduloDTO.getPrioridad() != null)
                ? moduloDTO.getPrioridad() : null);
            modulo.setUsuCreador((moduloDTO.getUsuCreador() != null)
                ? moduloDTO.getUsuCreador() : null);
            modulo.setUsuModificador((moduloDTO.getUsuModificador() != null)
                ? moduloDTO.getUsuModificador() : null);

            TipoModulo tipoModulo = new TipoModulo();

            if (moduloDTO.getIdTipoModulo_TipoModulo() != null) {
                tipoModulo = logicTipoModulo1.getTipoModulo(moduloDTO.getIdTipoModulo_TipoModulo());
            }

            if (tipoModulo != null) {
                modulo.setTipoModulo(tipoModulo);
            }

            return modulo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ModuloDTO> listModuloToListModuloDTO(List<Modulo> listModulo)
        throws Exception {
        try {
            List<ModuloDTO> moduloDTOs = new ArrayList<ModuloDTO>();

            for (Modulo modulo : listModulo) {
                ModuloDTO moduloDTO = moduloToModuloDTO(modulo);

                moduloDTOs.add(moduloDTO);
            }

            return moduloDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Modulo> listModuloDTOToListModulo(List<ModuloDTO> listModuloDTO)
        throws Exception {
        try {
            List<Modulo> listModulo = new ArrayList<Modulo>();

            for (ModuloDTO moduloDTO : listModuloDTO) {
                Modulo modulo = moduloDTOToModulo(moduloDTO);

                listModulo.add(modulo);
            }

            return listModulo;
        } catch (Exception e) {
            throw e;
        }
    }
}
