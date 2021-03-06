package com.green.mapper;

import com.green.dto.DocumentoDTO;

import com.green.modelo.Documento;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface DocumentoMapper {
    public DocumentoDTO documentoToDocumentoDTO(Documento documento)
        throws Exception;

    public Documento documentoDTOToDocumento(DocumentoDTO documentoDTO)
        throws Exception;

    public List<DocumentoDTO> listDocumentoToListDocumentoDTO(
        List<Documento> documentos) throws Exception;

    public List<Documento> listDocumentoDTOToListDocumento(
        List<DocumentoDTO> documentoDTOs) throws Exception;
}
