package com.green.mapper;

import com.green.dto.ComentarioDTO;

import com.green.modelo.Comentario;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ComentarioMapper {
    public ComentarioDTO comentarioToComentarioDTO(Comentario comentario)
        throws Exception;

    public Comentario comentarioDTOToComentario(ComentarioDTO comentarioDTO)
        throws Exception;

    public List<ComentarioDTO> listComentarioToListComentarioDTO(
        List<Comentario> comentarios) throws Exception;

    public List<Comentario> listComentarioDTOToListComentario(
        List<ComentarioDTO> comentarioDTOs) throws Exception;
}
