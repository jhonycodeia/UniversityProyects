package com.saberpro.dto.mapper;

import com.saberpro.modelo.TipoUsuario;
import com.saberpro.modelo.dto.TipoUsuarioDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ITipoUsuarioMapper {
    public TipoUsuarioDTO tipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario)
        throws Exception;

    public TipoUsuario tipoUsuarioDTOToTipoUsuario(
        TipoUsuarioDTO tipoUsuarioDTO) throws Exception;

    public List<TipoUsuarioDTO> listTipoUsuarioToListTipoUsuarioDTO(
        List<TipoUsuario> tipoUsuarios) throws Exception;

    public List<TipoUsuario> listTipoUsuarioDTOToListTipoUsuario(
        List<TipoUsuarioDTO> tipoUsuarioDTOs) throws Exception;
}
