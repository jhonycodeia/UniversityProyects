package com.green.mapper;

import com.green.dto.RecompensaUsuarioDTO;

import com.green.modelo.RecompensaUsuario;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface RecompensaUsuarioMapper {
    public RecompensaUsuarioDTO recompensaUsuarioToRecompensaUsuarioDTO(
        RecompensaUsuario recompensaUsuario) throws Exception;

    public RecompensaUsuario recompensaUsuarioDTOToRecompensaUsuario(
        RecompensaUsuarioDTO recompensaUsuarioDTO) throws Exception;

    public List<RecompensaUsuarioDTO> listRecompensaUsuarioToListRecompensaUsuarioDTO(
        List<RecompensaUsuario> recompensaUsuarios) throws Exception;

    public List<RecompensaUsuario> listRecompensaUsuarioDTOToListRecompensaUsuario(
        List<RecompensaUsuarioDTO> recompensaUsuarioDTOs)
        throws Exception;
}
