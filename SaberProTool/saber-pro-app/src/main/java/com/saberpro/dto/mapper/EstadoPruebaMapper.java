package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.EstadoPrueba;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.EstadoPruebaDTO;

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
public class EstadoPruebaMapper implements IEstadoPruebaMapper {
    private static final Logger log = LoggerFactory.getLogger(EstadoPruebaMapper.class);

    @Transactional(readOnly = true)
    public EstadoPruebaDTO estadoPruebaToEstadoPruebaDTO(
        EstadoPrueba estadoPrueba) throws Exception {
        try {
            EstadoPruebaDTO estadoPruebaDTO = new EstadoPruebaDTO();

            estadoPruebaDTO.setIdEstadoPrueba(estadoPrueba.getIdEstadoPrueba());
            estadoPruebaDTO.setActivo((estadoPrueba.getActivo() != null)
                ? estadoPrueba.getActivo() : null);
            estadoPruebaDTO.setDescripcion((estadoPrueba.getDescripcion() != null)
                ? estadoPrueba.getDescripcion() : null);
            estadoPruebaDTO.setFechaCreacion(estadoPrueba.getFechaCreacion());
            estadoPruebaDTO.setFechaModificacion(estadoPrueba.getFechaModificacion());
            estadoPruebaDTO.setNombre((estadoPrueba.getNombre() != null)
                ? estadoPrueba.getNombre() : null);
            estadoPruebaDTO.setUsuCreador((estadoPrueba.getUsuCreador() != null)
                ? estadoPrueba.getUsuCreador() : null);
            estadoPruebaDTO.setUsuModificador((estadoPrueba.getUsuModificador() != null)
                ? estadoPrueba.getUsuModificador() : null);

            return estadoPruebaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public EstadoPrueba estadoPruebaDTOToEstadoPrueba(
        EstadoPruebaDTO estadoPruebaDTO) throws Exception {
        try {
            EstadoPrueba estadoPrueba = new EstadoPrueba();

            estadoPrueba.setIdEstadoPrueba(estadoPruebaDTO.getIdEstadoPrueba());
            estadoPrueba.setActivo((estadoPruebaDTO.getActivo() != null)
                ? estadoPruebaDTO.getActivo() : null);
            estadoPrueba.setDescripcion((estadoPruebaDTO.getDescripcion() != null)
                ? estadoPruebaDTO.getDescripcion() : null);
            estadoPrueba.setFechaCreacion(estadoPruebaDTO.getFechaCreacion());
            estadoPrueba.setFechaModificacion(estadoPruebaDTO.getFechaModificacion());
            estadoPrueba.setNombre((estadoPruebaDTO.getNombre() != null)
                ? estadoPruebaDTO.getNombre() : null);
            estadoPrueba.setUsuCreador((estadoPruebaDTO.getUsuCreador() != null)
                ? estadoPruebaDTO.getUsuCreador() : null);
            estadoPrueba.setUsuModificador((estadoPruebaDTO.getUsuModificador() != null)
                ? estadoPruebaDTO.getUsuModificador() : null);

            return estadoPrueba;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EstadoPruebaDTO> listEstadoPruebaToListEstadoPruebaDTO(
        List<EstadoPrueba> listEstadoPrueba) throws Exception {
        try {
            List<EstadoPruebaDTO> estadoPruebaDTOs = new ArrayList<EstadoPruebaDTO>();

            for (EstadoPrueba estadoPrueba : listEstadoPrueba) {
                EstadoPruebaDTO estadoPruebaDTO = estadoPruebaToEstadoPruebaDTO(estadoPrueba);

                estadoPruebaDTOs.add(estadoPruebaDTO);
            }

            return estadoPruebaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EstadoPrueba> listEstadoPruebaDTOToListEstadoPrueba(
        List<EstadoPruebaDTO> listEstadoPruebaDTO) throws Exception {
        try {
            List<EstadoPrueba> listEstadoPrueba = new ArrayList<EstadoPrueba>();

            for (EstadoPruebaDTO estadoPruebaDTO : listEstadoPruebaDTO) {
                EstadoPrueba estadoPrueba = estadoPruebaDTOToEstadoPrueba(estadoPruebaDTO);

                listEstadoPrueba.add(estadoPrueba);
            }

            return listEstadoPrueba;
        } catch (Exception e) {
            throw e;
        }
    }
}
