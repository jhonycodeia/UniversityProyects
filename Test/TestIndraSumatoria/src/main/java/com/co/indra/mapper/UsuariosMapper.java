package com.co.indra.mapper;

import com.co.indra.dto.UsuariosDTO;
import com.co.indra.model.Usuarios;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface UsuariosMapper {
    public UsuariosDTO usuariosToUsuariosDTO(Usuarios usuarios)
        throws Exception;

    public Usuarios usuariosDTOToUsuarios(UsuariosDTO usuariosDTO)
        throws Exception;

    public List<UsuariosDTO> listUsuariosToListUsuariosDTO(
        List<Usuarios> usuarioss) throws Exception;

    public List<Usuarios> listUsuariosDTOToListUsuarios(
        List<UsuariosDTO> usuariosDTOs) throws Exception;
}
