package com.green.mapper;

import com.green.dto.CalificacionDTO;

import com.green.modelo.*;
import com.green.modelo.Calificacion;

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
public class CalificacionMapperImpl implements CalificacionMapper {
    private static final Logger log = LoggerFactory.getLogger(CalificacionMapperImpl.class);

    /**
    * Service injected by Spring that manages Capsula entities
    *
    */
    @Autowired
    CapsulaService serviceCapsula1;

    /**
    * Service injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    UsuarioService serviceUsuario2;

    @Transactional(readOnly = true)
    public CalificacionDTO calificacionToCalificacionDTO(
        Calificacion calificacion) throws Exception {
        try {
            CalificacionDTO calificacionDTO = new CalificacionDTO();

            calificacionDTO.setIdCalificacion(calificacion.getIdCalificacion());
            calificacionDTO.setActivo((calificacion.getActivo() != null)
                ? calificacion.getActivo() : null);
            calificacionDTO.setFechaCreacion(calificacion.getFechaCreacion());
            calificacionDTO.setFechaModificacion(calificacion.getFechaModificacion());
            calificacionDTO.setUsuCreador((calificacion.getUsuCreador() != null)
                ? calificacion.getUsuCreador() : null);
            calificacionDTO.setUsuModificador((calificacion.getUsuModificador() != null)
                ? calificacion.getUsuModificador() : null);
            calificacionDTO.setValor((calificacion.getValor() != null)
                ? calificacion.getValor() : null);
            calificacionDTO.setIdCapsula_Capsula((calificacion.getCapsula()
                                                              .getIdCapsula() != null)
                ? calificacion.getCapsula().getIdCapsula() : null);
            calificacionDTO.setIdUsuario_Usuario((calificacion.getUsuario()
                                                              .getIdUsuario() != null)
                ? calificacion.getUsuario().getIdUsuario() : null);

            return calificacionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Calificacion calificacionDTOToCalificacion(
        CalificacionDTO calificacionDTO) throws Exception {
        try {
            Calificacion calificacion = new Calificacion();

            calificacion.setIdCalificacion(calificacionDTO.getIdCalificacion());
            calificacion.setActivo((calificacionDTO.getActivo() != null)
                ? calificacionDTO.getActivo() : null);
            calificacion.setFechaCreacion(calificacionDTO.getFechaCreacion());
            calificacion.setFechaModificacion(calificacionDTO.getFechaModificacion());
            calificacion.setUsuCreador((calificacionDTO.getUsuCreador() != null)
                ? calificacionDTO.getUsuCreador() : null);
            calificacion.setUsuModificador((calificacionDTO.getUsuModificador() != null)
                ? calificacionDTO.getUsuModificador() : null);
            calificacion.setValor((calificacionDTO.getValor() != null)
                ? calificacionDTO.getValor() : null);

            Capsula capsula = new Capsula();

            if (calificacionDTO.getIdCapsula_Capsula() != null) {
                capsula = serviceCapsula1.getCapsula(calificacionDTO.getIdCapsula_Capsula());
            }

            if (capsula != null) {
                calificacion.setCapsula(capsula);
            }

            Usuario usuario = new Usuario();

            if (calificacionDTO.getIdUsuario_Usuario() != null) {
                usuario = serviceUsuario2.getUsuario(calificacionDTO.getIdUsuario_Usuario());
            }

            if (usuario != null) {
                calificacion.setUsuario(usuario);
            }

            return calificacion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CalificacionDTO> listCalificacionToListCalificacionDTO(
        List<Calificacion> listCalificacion) throws Exception {
        try {
            List<CalificacionDTO> calificacionDTOs = new ArrayList<CalificacionDTO>();

            for (Calificacion calificacion : listCalificacion) {
                CalificacionDTO calificacionDTO = calificacionToCalificacionDTO(calificacion);

                calificacionDTOs.add(calificacionDTO);
            }

            return calificacionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Calificacion> listCalificacionDTOToListCalificacion(
        List<CalificacionDTO> listCalificacionDTO) throws Exception {
        try {
            List<Calificacion> listCalificacion = new ArrayList<Calificacion>();

            for (CalificacionDTO calificacionDTO : listCalificacionDTO) {
                Calificacion calificacion = calificacionDTOToCalificacion(calificacionDTO);

                listCalificacion.add(calificacion);
            }

            return listCalificacion;
        } catch (Exception e) {
            throw e;
        }
    }
}
