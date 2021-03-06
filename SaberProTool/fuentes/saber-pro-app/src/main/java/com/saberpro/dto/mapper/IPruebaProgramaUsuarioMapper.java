package com.saberpro.dto.mapper;

import com.saberpro.modelo.PruebaProgramaUsuario;
import com.saberpro.modelo.dto.PruebaProgramaUsuarioDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IPruebaProgramaUsuarioMapper {
    public PruebaProgramaUsuarioDTO pruebaProgramaUsuarioToPruebaProgramaUsuarioDTO(
        PruebaProgramaUsuario pruebaProgramaUsuario) throws Exception;

    public PruebaProgramaUsuario pruebaProgramaUsuarioDTOToPruebaProgramaUsuario(
        PruebaProgramaUsuarioDTO pruebaProgramaUsuarioDTO)
        throws Exception;

    public List<PruebaProgramaUsuarioDTO> listPruebaProgramaUsuarioToListPruebaProgramaUsuarioDTO(
        List<PruebaProgramaUsuario> pruebaProgramaUsuarios)
        throws Exception;

    public List<PruebaProgramaUsuario> listPruebaProgramaUsuarioDTOToListPruebaProgramaUsuario(
        List<PruebaProgramaUsuarioDTO> pruebaProgramaUsuarioDTOs)
        throws Exception;
}
