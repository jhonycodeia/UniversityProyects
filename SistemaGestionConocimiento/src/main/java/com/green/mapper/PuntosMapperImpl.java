package com.green.mapper;

import com.green.dto.PuntosDTO;

import com.green.modelo.*;
import com.green.modelo.Puntos;

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
public class PuntosMapperImpl implements PuntosMapper {
    private static final Logger log = LoggerFactory.getLogger(PuntosMapperImpl.class);

    /**
    * Service injected by Spring that manages TipoPuntos entities
    *
    */
    @Autowired
    TipoPuntosService serviceTipoPuntos1;

    /**
    * Service injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    UsuarioService serviceUsuario2;

    @Transactional(readOnly = true)
    public PuntosDTO puntosToPuntosDTO(Puntos puntos) throws Exception {
        try {
            PuntosDTO puntosDTO = new PuntosDTO();

            puntosDTO.setIdPuntos(puntos.getIdPuntos());
            puntosDTO.setActivo((puntos.getActivo() != null)
                ? puntos.getActivo() : null);
            puntosDTO.setFechaCreacion(puntos.getFechaCreacion());
            puntosDTO.setFechaModificacion(puntos.getFechaModificacion());
            puntosDTO.setPuntos((puntos.getPuntos() != null)
                ? puntos.getPuntos() : null);
            puntosDTO.setUsuCreador((puntos.getUsuCreador() != null)
                ? puntos.getUsuCreador() : null);
            puntosDTO.setUsuModificador((puntos.getUsuModificador() != null)
                ? puntos.getUsuModificador() : null);
            puntosDTO.setIdTipoPuntos_TipoPuntos((puntos.getTipoPuntos()
                                                        .getIdTipoPuntos() != null)
                ? puntos.getTipoPuntos().getIdTipoPuntos() : null);
            puntosDTO.setIdUsuario_Usuario((puntos.getUsuario().getIdUsuario() != null)
                ? puntos.getUsuario().getIdUsuario() : null);

            return puntosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Puntos puntosDTOToPuntos(PuntosDTO puntosDTO)
        throws Exception {
        try {
            Puntos puntos = new Puntos();

            puntos.setIdPuntos(puntosDTO.getIdPuntos());
            puntos.setActivo((puntosDTO.getActivo() != null)
                ? puntosDTO.getActivo() : null);
            puntos.setFechaCreacion(puntosDTO.getFechaCreacion());
            puntos.setFechaModificacion(puntosDTO.getFechaModificacion());
            puntos.setPuntos((puntosDTO.getPuntos() != null)
                ? puntosDTO.getPuntos() : null);
            puntos.setUsuCreador((puntosDTO.getUsuCreador() != null)
                ? puntosDTO.getUsuCreador() : null);
            puntos.setUsuModificador((puntosDTO.getUsuModificador() != null)
                ? puntosDTO.getUsuModificador() : null);

            TipoPuntos tipoPuntos = new TipoPuntos();

            if (puntosDTO.getIdTipoPuntos_TipoPuntos() != null) {
                tipoPuntos = serviceTipoPuntos1.getTipoPuntos(puntosDTO.getIdTipoPuntos_TipoPuntos());
            }

            if (tipoPuntos != null) {
                puntos.setTipoPuntos(tipoPuntos);
            }

            Usuario usuario = new Usuario();

            if (puntosDTO.getIdUsuario_Usuario() != null) {
                usuario = serviceUsuario2.getUsuario(puntosDTO.getIdUsuario_Usuario());
            }

            if (usuario != null) {
                puntos.setUsuario(usuario);
            }

            return puntos;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PuntosDTO> listPuntosToListPuntosDTO(List<Puntos> listPuntos)
        throws Exception {
        try {
            List<PuntosDTO> puntosDTOs = new ArrayList<PuntosDTO>();

            for (Puntos puntos : listPuntos) {
                PuntosDTO puntosDTO = puntosToPuntosDTO(puntos);

                puntosDTOs.add(puntosDTO);
            }

            return puntosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Puntos> listPuntosDTOToListPuntos(List<PuntosDTO> listPuntosDTO)
        throws Exception {
        try {
            List<Puntos> listPuntos = new ArrayList<Puntos>();

            for (PuntosDTO puntosDTO : listPuntosDTO) {
                Puntos puntos = puntosDTOToPuntos(puntosDTO);

                listPuntos.add(puntos);
            }

            return listPuntos;
        } catch (Exception e) {
            throw e;
        }
    }
}
