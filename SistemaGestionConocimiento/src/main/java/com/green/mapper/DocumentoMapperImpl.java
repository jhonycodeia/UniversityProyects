package com.green.mapper;

import com.green.dto.DocumentoDTO;

import com.green.modelo.*;
import com.green.modelo.Documento;

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
public class DocumentoMapperImpl implements DocumentoMapper {
    private static final Logger log = LoggerFactory.getLogger(DocumentoMapperImpl.class);

    /**
    * Service injected by Spring that manages Capsula entities
    *
    */
    @Autowired
    CapsulaService serviceCapsula1;

    /**
    * Service injected by Spring that manages TipoDocumento entities
    *
    */
    @Autowired
    TipoDocumentoService serviceTipoDocumento2;

    @Transactional(readOnly = true)
    public DocumentoDTO documentoToDocumentoDTO(Documento documento)
        throws Exception {
        try {
            DocumentoDTO documentoDTO = new DocumentoDTO();

            documentoDTO.setIdDocumento(documento.getIdDocumento());
            documentoDTO.setActivo((documento.getActivo() != null)
                ? documento.getActivo() : null);
            documentoDTO.setDescripcion((documento.getDescripcion() != null)
                ? documento.getDescripcion() : null);
            documentoDTO.setFechaCreacion(documento.getFechaCreacion());
            documentoDTO.setFechaModificacion(documento.getFechaModificacion());
            documentoDTO.setNombre((documento.getNombre() != null)
                ? documento.getNombre() : null);
            documentoDTO.setRuta((documento.getRuta() != null)
                ? documento.getRuta() : null);
            documentoDTO.setUsuCreador((documento.getUsuCreador() != null)
                ? documento.getUsuCreador() : null);
            documentoDTO.setUsuModificador((documento.getUsuModificador() != null)
                ? documento.getUsuModificador() : null);
            documentoDTO.setValor((documento.getValor() != null)
                ? documento.getValor() : null);
            documentoDTO.setIdCapsula_Capsula((documento.getCapsula()
                                                        .getIdCapsula() != null)
                ? documento.getCapsula().getIdCapsula() : null);
            documentoDTO.setIdTipoDocumento_TipoDocumento((documento.getTipoDocumento()
                                                                    .getIdTipoDocumento() != null)
                ? documento.getTipoDocumento().getIdTipoDocumento() : null);

            return documentoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Documento documentoDTOToDocumento(DocumentoDTO documentoDTO)
        throws Exception {
        try {
            Documento documento = new Documento();

            documento.setIdDocumento(documentoDTO.getIdDocumento());
            documento.setActivo((documentoDTO.getActivo() != null)
                ? documentoDTO.getActivo() : null);
            documento.setDescripcion((documentoDTO.getDescripcion() != null)
                ? documentoDTO.getDescripcion() : null);
            documento.setFechaCreacion(documentoDTO.getFechaCreacion());
            documento.setFechaModificacion(documentoDTO.getFechaModificacion());
            documento.setNombre((documentoDTO.getNombre() != null)
                ? documentoDTO.getNombre() : null);
            documento.setRuta((documentoDTO.getRuta() != null)
                ? documentoDTO.getRuta() : null);
            documento.setUsuCreador((documentoDTO.getUsuCreador() != null)
                ? documentoDTO.getUsuCreador() : null);
            documento.setUsuModificador((documentoDTO.getUsuModificador() != null)
                ? documentoDTO.getUsuModificador() : null);
            documento.setValor((documentoDTO.getValor() != null)
                ? documentoDTO.getValor() : null);

            Capsula capsula = new Capsula();

            if (documentoDTO.getIdCapsula_Capsula() != null) {
                capsula = serviceCapsula1.getCapsula(documentoDTO.getIdCapsula_Capsula());
            }

            if (capsula != null) {
                documento.setCapsula(capsula);
            }

            TipoDocumento tipoDocumento = new TipoDocumento();

            if (documentoDTO.getIdTipoDocumento_TipoDocumento() != null) {
                tipoDocumento = serviceTipoDocumento2.getTipoDocumento(documentoDTO.getIdTipoDocumento_TipoDocumento());
            }

            if (tipoDocumento != null) {
                documento.setTipoDocumento(tipoDocumento);
            }

            return documento;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<DocumentoDTO> listDocumentoToListDocumentoDTO(
        List<Documento> listDocumento) throws Exception {
        try {
            List<DocumentoDTO> documentoDTOs = new ArrayList<DocumentoDTO>();

            for (Documento documento : listDocumento) {
                DocumentoDTO documentoDTO = documentoToDocumentoDTO(documento);

                documentoDTOs.add(documentoDTO);
            }

            return documentoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Documento> listDocumentoDTOToListDocumento(
        List<DocumentoDTO> listDocumentoDTO) throws Exception {
        try {
            List<Documento> listDocumento = new ArrayList<Documento>();

            for (DocumentoDTO documentoDTO : listDocumentoDTO) {
                Documento documento = documentoDTOToDocumento(documentoDTO);

                listDocumento.add(documento);
            }

            return listDocumento;
        } catch (Exception e) {
            throw e;
        }
    }
}
