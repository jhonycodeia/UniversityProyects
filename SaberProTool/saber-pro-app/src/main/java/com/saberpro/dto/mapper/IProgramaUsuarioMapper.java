package com.saberpro.dto.mapper;

import com.saberpro.modelo.ProgramaUsuario;
import com.saberpro.modelo.dto.ProgramaUsuarioDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IProgramaUsuarioMapper {
    public ProgramaUsuarioDTO programaUsuarioToProgramaUsuarioDTO(
        ProgramaUsuario programaUsuario) throws Exception;

    public ProgramaUsuario programaUsuarioDTOToProgramaUsuario(
        ProgramaUsuarioDTO programaUsuarioDTO) throws Exception;

    public List<ProgramaUsuarioDTO> listProgramaUsuarioToListProgramaUsuarioDTO(
        List<ProgramaUsuario> programaUsuarios) throws Exception;

    public List<ProgramaUsuario> listProgramaUsuarioDTOToListProgramaUsuario(
        List<ProgramaUsuarioDTO> programaUsuarioDTOs) throws Exception;
}
