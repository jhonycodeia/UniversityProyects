package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.Permiso;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.PermisoDTO;

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
public class PermisoMapper implements IPermisoMapper {
    private static final Logger log = LoggerFactory.getLogger(PermisoMapper.class);

    /**
    * Logic injected by Spring that manages GrupoOpcion entities
    *
    */
    @Autowired
    IGrupoOpcionLogic logicGrupoOpcion1;

    /**
    * Logic injected by Spring that manages TipoUsuario entities
    *
    */
    @Autowired
    ITipoUsuarioLogic logicTipoUsuario2;

    @Transactional(readOnly = true)
    public PermisoDTO permisoToPermisoDTO(Permiso permiso)
        throws Exception {
        try {
            PermisoDTO permisoDTO = new PermisoDTO();

            permisoDTO.setIdPermiso(permiso.getIdPermiso());
            permisoDTO.setActivo((permiso.getActivo() != null)
                ? permiso.getActivo() : null);
            permisoDTO.setFechaCreacion(permiso.getFechaCreacion());
            permisoDTO.setFechaModificacion(permiso.getFechaModificacion());
            permisoDTO.setUsuCreador((permiso.getUsuCreador() != null)
                ? permiso.getUsuCreador() : null);
            permisoDTO.setUsuModificador((permiso.getUsuModificador() != null)
                ? permiso.getUsuModificador() : null);
            permisoDTO.setIdGrupoOpcion_GrupoOpcion((permiso.getGrupoOpcion()
                                                            .getIdGrupoOpcion() != null)
                ? permiso.getGrupoOpcion().getIdGrupoOpcion() : null);
            permisoDTO.setIdTipoUsuario_TipoUsuario((permiso.getTipoUsuario()
                                                            .getIdTipoUsuario() != null)
                ? permiso.getTipoUsuario().getIdTipoUsuario() : null);

            return permisoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Permiso permisoDTOToPermiso(PermisoDTO permisoDTO)
        throws Exception {
        try {
            Permiso permiso = new Permiso();

            permiso.setIdPermiso(permisoDTO.getIdPermiso());
            permiso.setActivo((permisoDTO.getActivo() != null)
                ? permisoDTO.getActivo() : null);
            permiso.setFechaCreacion(permisoDTO.getFechaCreacion());
            permiso.setFechaModificacion(permisoDTO.getFechaModificacion());
            permiso.setUsuCreador((permisoDTO.getUsuCreador() != null)
                ? permisoDTO.getUsuCreador() : null);
            permiso.setUsuModificador((permisoDTO.getUsuModificador() != null)
                ? permisoDTO.getUsuModificador() : null);

            GrupoOpcion grupoOpcion = new GrupoOpcion();

            if (permisoDTO.getIdGrupoOpcion_GrupoOpcion() != null) {
                grupoOpcion = logicGrupoOpcion1.getGrupoOpcion(permisoDTO.getIdGrupoOpcion_GrupoOpcion());
            }

            if (grupoOpcion != null) {
                permiso.setGrupoOpcion(grupoOpcion);
            }

            TipoUsuario tipoUsuario = new TipoUsuario();

            if (permisoDTO.getIdTipoUsuario_TipoUsuario() != null) {
                tipoUsuario = logicTipoUsuario2.getTipoUsuario(permisoDTO.getIdTipoUsuario_TipoUsuario());
            }

            if (tipoUsuario != null) {
                permiso.setTipoUsuario(tipoUsuario);
            }

            return permiso;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PermisoDTO> listPermisoToListPermisoDTO(
        List<Permiso> listPermiso) throws Exception {
        try {
            List<PermisoDTO> permisoDTOs = new ArrayList<PermisoDTO>();

            for (Permiso permiso : listPermiso) {
                PermisoDTO permisoDTO = permisoToPermisoDTO(permiso);

                permisoDTOs.add(permisoDTO);
            }

            return permisoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Permiso> listPermisoDTOToListPermiso(
        List<PermisoDTO> listPermisoDTO) throws Exception {
        try {
            List<Permiso> listPermiso = new ArrayList<Permiso>();

            for (PermisoDTO permisoDTO : listPermisoDTO) {
                Permiso permiso = permisoDTOToPermiso(permisoDTO);

                listPermiso.add(permiso);
            }

            return listPermiso;
        } catch (Exception e) {
            throw e;
        }
    }
}
