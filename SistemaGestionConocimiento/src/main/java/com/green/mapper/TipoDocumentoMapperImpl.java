package com.green.mapper;

import com.green.dto.TipoDocumentoDTO;

import com.green.modelo.*;
import com.green.modelo.TipoDocumento;

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
public class TipoDocumentoMapperImpl implements TipoDocumentoMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoDocumentoMapperImpl.class);

    @Transactional(readOnly = true)
    public TipoDocumentoDTO tipoDocumentoToTipoDocumentoDTO(
        TipoDocumento tipoDocumento) throws Exception {
        try {
            TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();

            tipoDocumentoDTO.setIdTipoDocumento(tipoDocumento.getIdTipoDocumento());
            tipoDocumentoDTO.setActivo((tipoDocumento.getActivo() != null)
                ? tipoDocumento.getActivo() : null);
            tipoDocumentoDTO.setDescripcion((tipoDocumento.getDescripcion() != null)
                ? tipoDocumento.getDescripcion() : null);
            tipoDocumentoDTO.setFechaCreacion(tipoDocumento.getFechaCreacion());
            tipoDocumentoDTO.setFechaModificacion(tipoDocumento.getFechaModificacion());
            tipoDocumentoDTO.setNombre((tipoDocumento.getNombre() != null)
                ? tipoDocumento.getNombre() : null);
            tipoDocumentoDTO.setUsuCreador((tipoDocumento.getUsuCreador() != null)
                ? tipoDocumento.getUsuCreador() : null);
            tipoDocumentoDTO.setUsuModificador((tipoDocumento.getUsuModificador() != null)
                ? tipoDocumento.getUsuModificador() : null);

            return tipoDocumentoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoDocumento tipoDocumentoDTOToTipoDocumento(
        TipoDocumentoDTO tipoDocumentoDTO) throws Exception {
        try {
            TipoDocumento tipoDocumento = new TipoDocumento();

            tipoDocumento.setIdTipoDocumento(tipoDocumentoDTO.getIdTipoDocumento());
            tipoDocumento.setActivo((tipoDocumentoDTO.getActivo() != null)
                ? tipoDocumentoDTO.getActivo() : null);
            tipoDocumento.setDescripcion((tipoDocumentoDTO.getDescripcion() != null)
                ? tipoDocumentoDTO.getDescripcion() : null);
            tipoDocumento.setFechaCreacion(tipoDocumentoDTO.getFechaCreacion());
            tipoDocumento.setFechaModificacion(tipoDocumentoDTO.getFechaModificacion());
            tipoDocumento.setNombre((tipoDocumentoDTO.getNombre() != null)
                ? tipoDocumentoDTO.getNombre() : null);
            tipoDocumento.setUsuCreador((tipoDocumentoDTO.getUsuCreador() != null)
                ? tipoDocumentoDTO.getUsuCreador() : null);
            tipoDocumento.setUsuModificador((tipoDocumentoDTO.getUsuModificador() != null)
                ? tipoDocumentoDTO.getUsuModificador() : null);

            return tipoDocumento;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoDocumentoDTO> listTipoDocumentoToListTipoDocumentoDTO(
        List<TipoDocumento> listTipoDocumento) throws Exception {
        try {
            List<TipoDocumentoDTO> tipoDocumentoDTOs = new ArrayList<TipoDocumentoDTO>();

            for (TipoDocumento tipoDocumento : listTipoDocumento) {
                TipoDocumentoDTO tipoDocumentoDTO = tipoDocumentoToTipoDocumentoDTO(tipoDocumento);

                tipoDocumentoDTOs.add(tipoDocumentoDTO);
            }

            return tipoDocumentoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoDocumento> listTipoDocumentoDTOToListTipoDocumento(
        List<TipoDocumentoDTO> listTipoDocumentoDTO) throws Exception {
        try {
            List<TipoDocumento> listTipoDocumento = new ArrayList<TipoDocumento>();

            for (TipoDocumentoDTO tipoDocumentoDTO : listTipoDocumentoDTO) {
                TipoDocumento tipoDocumento = tipoDocumentoDTOToTipoDocumento(tipoDocumentoDTO);

                listTipoDocumento.add(tipoDocumento);
            }

            return listTipoDocumento;
        } catch (Exception e) {
            throw e;
        }
    }
}
