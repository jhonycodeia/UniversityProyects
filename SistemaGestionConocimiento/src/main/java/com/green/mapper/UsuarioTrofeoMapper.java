package com.green.mapper;

import com.green.dto.UsuarioTrofeoDTO;

import com.green.modelo.UsuarioTrofeo;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface UsuarioTrofeoMapper {
    public UsuarioTrofeoDTO usuarioTrofeoToUsuarioTrofeoDTO(
        UsuarioTrofeo usuarioTrofeo) throws Exception;

    public UsuarioTrofeo usuarioTrofeoDTOToUsuarioTrofeo(
        UsuarioTrofeoDTO usuarioTrofeoDTO) throws Exception;

    public List<UsuarioTrofeoDTO> listUsuarioTrofeoToListUsuarioTrofeoDTO(
        List<UsuarioTrofeo> usuarioTrofeos) throws Exception;

    public List<UsuarioTrofeo> listUsuarioTrofeoDTOToListUsuarioTrofeo(
        List<UsuarioTrofeoDTO> usuarioTrofeoDTOs) throws Exception;
}
