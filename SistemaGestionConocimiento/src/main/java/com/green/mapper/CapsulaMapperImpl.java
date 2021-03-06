package com.green.mapper;

import com.green.dto.CapsulaDTO;

import com.green.modelo.*;
import com.green.modelo.Capsula;

import com.green.service.*;

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
public class CapsulaMapperImpl implements CapsulaMapper {
    private static final Logger log = LoggerFactory.getLogger(CapsulaMapperImpl.class);

    /**
    * Service injected by Spring that manages Categoria entities
    *
    */
    @Autowired
    CategoriaService serviceCategoria1;

    /**
    * Service injected by Spring that manages Proceso entities
    *
    */
    @Autowired
    ProcesoService serviceProceso2;

    /**
    * Service injected by Spring that manages Subproceso entities
    *
    */
    @Autowired
    SubprocesoService serviceSubproceso3;

    /**
    * Service injected by Spring that manages TipoCapsula entities
    *
    */
    @Autowired
    TipoCapsulaService serviceTipoCapsula4;

    /**
    * Service injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    UsuarioService serviceUsuario5;

    @Transactional(readOnly = true)
    public CapsulaDTO capsulaToCapsulaDTO(Capsula capsula)
        throws Exception {
        try {
            CapsulaDTO capsulaDTO = new CapsulaDTO();

            capsulaDTO.setIdCapsula(capsula.getIdCapsula());
            capsulaDTO.setActivo((capsula.getActivo() != null)
                ? capsula.getActivo() : null);
            capsulaDTO.setDescripcion((capsula.getDescripcion() != null)
                ? capsula.getDescripcion() : null);
            capsulaDTO.setDisparador((capsula.getDisparador() != null)
                ? capsula.getDisparador() : null);
            capsulaDTO.setFechaCreacion(capsula.getFechaCreacion());
            capsulaDTO.setFechaModificacion(capsula.getFechaModificacion());
            capsulaDTO.setParent((capsula.getParent() != null)
                ? capsula.getParent() : null);
            capsulaDTO.setResolucion((capsula.getResolucion() != null)
                ? capsula.getResolucion() : null);
            capsulaDTO.setSituacion((capsula.getSituacion() != null)
                ? capsula.getSituacion() : null);
            capsulaDTO.setTitulo((capsula.getTitulo() != null)
                ? capsula.getTitulo() : null);
            capsulaDTO.setUsuCreador((capsula.getUsuCreador() != null)
                ? capsula.getUsuCreador() : null);
            capsulaDTO.setUsuModificador((capsula.getUsuModificador() != null)
                ? capsula.getUsuModificador() : null);
            capsulaDTO.setValor((capsula.getValor() != null)
                ? capsula.getValor() : null);

            if (capsula.getCategoria() != null) {
                capsulaDTO.setIdCategoria_Categoria(capsula.getCategoria()
                                                           .getIdCategoria());
            } else {
                capsulaDTO.setIdCategoria_Categoria(null);
            }

            if (capsula.getProceso() != null) {
                capsulaDTO.setIdProceso_Proceso(capsula.getProceso()
                                                       .getIdProceso());
            } else {
                capsulaDTO.setIdProceso_Proceso(null);
            }

            if (capsula.getSubproceso() != null) {
                capsulaDTO.setIdSubproceso_Subproceso(capsula.getSubproceso()
                                                             .getIdSubproceso());
            } else {
                capsulaDTO.setIdSubproceso_Subproceso(null);
            }

            capsulaDTO.setIdTipoCapsula_TipoCapsula((capsula.getTipoCapsula()
                                                            .getIdTipoCapsula() != null)
                ? capsula.getTipoCapsula().getIdTipoCapsula() : null);

            if (capsula.getUsuario() != null) {
                capsulaDTO.setIdUsuario_Usuario(capsula.getUsuario()
                                                       .getIdUsuario());
            } else {
                capsulaDTO.setIdUsuario_Usuario(null);
            }

            return capsulaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Capsula capsulaDTOToCapsula(CapsulaDTO capsulaDTO)
        throws Exception {
        try {
            Capsula capsula = new Capsula();

            capsula.setIdCapsula(capsulaDTO.getIdCapsula());
            capsula.setActivo((capsulaDTO.getActivo() != null)
                ? capsulaDTO.getActivo() : null);
            capsula.setDescripcion((capsulaDTO.getDescripcion() != null)
                ? capsulaDTO.getDescripcion() : null);
            capsula.setDisparador((capsulaDTO.getDisparador() != null)
                ? capsulaDTO.getDisparador() : null);
            capsula.setFechaCreacion(capsulaDTO.getFechaCreacion());
            capsula.setFechaModificacion(capsulaDTO.getFechaModificacion());
            capsula.setParent((capsulaDTO.getParent() != null)
                ? capsulaDTO.getParent() : null);
            capsula.setResolucion((capsulaDTO.getResolucion() != null)
                ? capsulaDTO.getResolucion() : null);
            capsula.setSituacion((capsulaDTO.getSituacion() != null)
                ? capsulaDTO.getSituacion() : null);
            capsula.setTitulo((capsulaDTO.getTitulo() != null)
                ? capsulaDTO.getTitulo() : null);
            capsula.setUsuCreador((capsulaDTO.getUsuCreador() != null)
                ? capsulaDTO.getUsuCreador() : null);
            capsula.setUsuModificador((capsulaDTO.getUsuModificador() != null)
                ? capsulaDTO.getUsuModificador() : null);
            capsula.setValor((capsulaDTO.getValor() != null)
                ? capsulaDTO.getValor() : null);

            Categoria categoria = new Categoria();

            if (capsulaDTO.getIdCategoria_Categoria() != null) {
                categoria = serviceCategoria1.getCategoria(capsulaDTO.getIdCategoria_Categoria());
            }

            if (categoria != null) {
                capsula.setCategoria(categoria);
            }

            Proceso proceso = new Proceso();

            if (capsulaDTO.getIdProceso_Proceso() != null) {
                proceso = serviceProceso2.getProceso(capsulaDTO.getIdProceso_Proceso());
            }

            if (proceso != null) {
                capsula.setProceso(proceso);
            }

            Subproceso subproceso = new Subproceso();

            if (capsulaDTO.getIdSubproceso_Subproceso() != null) {
                subproceso = serviceSubproceso3.getSubproceso(capsulaDTO.getIdSubproceso_Subproceso());
            }

            if (subproceso != null) {
                capsula.setSubproceso(subproceso);
            }

            TipoCapsula tipoCapsula = new TipoCapsula();

            if (capsulaDTO.getIdTipoCapsula_TipoCapsula() != null) {
                tipoCapsula = serviceTipoCapsula4.getTipoCapsula(capsulaDTO.getIdTipoCapsula_TipoCapsula());
            }

            if (tipoCapsula != null) {
                capsula.setTipoCapsula(tipoCapsula);
            }

            Usuario usuario = new Usuario();

            if (capsulaDTO.getIdUsuario_Usuario() != null) {
                usuario = serviceUsuario5.getUsuario(capsulaDTO.getIdUsuario_Usuario());
            }

            if (usuario != null) {
                capsula.setUsuario(usuario);
            }

            return capsula;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CapsulaDTO> listCapsulaToListCapsulaDTO(
        List<Capsula> listCapsula) throws Exception {
        try {
            List<CapsulaDTO> capsulaDTOs = new ArrayList<CapsulaDTO>();

            for (Capsula capsula : listCapsula) {
                CapsulaDTO capsulaDTO = capsulaToCapsulaDTO(capsula);

                capsulaDTOs.add(capsulaDTO);
            }

            return capsulaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Capsula> listCapsulaDTOToListCapsula(
        List<CapsulaDTO> listCapsulaDTO) throws Exception {
        try {
            List<Capsula> listCapsula = new ArrayList<Capsula>();

            for (CapsulaDTO capsulaDTO : listCapsulaDTO) {
                Capsula capsula = capsulaDTOToCapsula(capsulaDTO);

                listCapsula.add(capsula);
            }

            return listCapsula;
        } catch (Exception e) {
            throw e;
        }
    }
}
