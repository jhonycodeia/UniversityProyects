package com.saberpro.dto.mapper;

import com.saberpro.modelo.Permiso;
import com.saberpro.modelo.dto.PermisoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IPermisoMapper {
    public PermisoDTO permisoToPermisoDTO(Permiso permiso)
        throws Exception;

    public Permiso permisoDTOToPermiso(PermisoDTO permisoDTO)
        throws Exception;

    public List<PermisoDTO> listPermisoToListPermisoDTO(List<Permiso> permisos)
        throws Exception;

    public List<Permiso> listPermisoDTOToListPermiso(
        List<PermisoDTO> permisoDTOs) throws Exception;
}
