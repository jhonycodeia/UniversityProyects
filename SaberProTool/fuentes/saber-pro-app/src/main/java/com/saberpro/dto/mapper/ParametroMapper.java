package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.Parametro;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.ParametroDTO;

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
public class ParametroMapper implements IParametroMapper {
    private static final Logger log = LoggerFactory.getLogger(ParametroMapper.class);

    @Transactional(readOnly = true)
    public ParametroDTO parametroToParametroDTO(Parametro parametro)
        throws Exception {
        try {
            ParametroDTO parametroDTO = new ParametroDTO();

            parametroDTO.setIdParametro(parametro.getIdParametro());
            parametroDTO.setActivo((parametro.getActivo() != null)
                ? parametro.getActivo() : null);
            parametroDTO.setDescripcion((parametro.getDescripcion() != null)
                ? parametro.getDescripcion() : null);
            parametroDTO.setFechaCreacion(parametro.getFechaCreacion());
            parametroDTO.setFechaModificacion(parametro.getFechaModificacion());
            parametroDTO.setNombre((parametro.getNombre() != null)
                ? parametro.getNombre() : null);
            parametroDTO.setUsuCreador((parametro.getUsuCreador() != null)
                ? parametro.getUsuCreador() : null);
            parametroDTO.setUsuModificador((parametro.getUsuModificador() != null)
                ? parametro.getUsuModificador() : null);
            parametroDTO.setValor((parametro.getValor() != null)
                ? parametro.getValor() : null);

            return parametroDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Parametro parametroDTOToParametro(ParametroDTO parametroDTO)
        throws Exception {
        try {
            Parametro parametro = new Parametro();

            parametro.setIdParametro(parametroDTO.getIdParametro());
            parametro.setActivo((parametroDTO.getActivo() != null)
                ? parametroDTO.getActivo() : null);
            parametro.setDescripcion((parametroDTO.getDescripcion() != null)
                ? parametroDTO.getDescripcion() : null);
            parametro.setFechaCreacion(parametroDTO.getFechaCreacion());
            parametro.setFechaModificacion(parametroDTO.getFechaModificacion());
            parametro.setNombre((parametroDTO.getNombre() != null)
                ? parametroDTO.getNombre() : null);
            parametro.setUsuCreador((parametroDTO.getUsuCreador() != null)
                ? parametroDTO.getUsuCreador() : null);
            parametro.setUsuModificador((parametroDTO.getUsuModificador() != null)
                ? parametroDTO.getUsuModificador() : null);
            parametro.setValor((parametroDTO.getValor() != null)
                ? parametroDTO.getValor() : null);

            return parametro;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ParametroDTO> listParametroToListParametroDTO(
        List<Parametro> listParametro) throws Exception {
        try {
            List<ParametroDTO> parametroDTOs = new ArrayList<ParametroDTO>();

            for (Parametro parametro : listParametro) {
                ParametroDTO parametroDTO = parametroToParametroDTO(parametro);

                parametroDTOs.add(parametroDTO);
            }

            return parametroDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Parametro> listParametroDTOToListParametro(
        List<ParametroDTO> listParametroDTO) throws Exception {
        try {
            List<Parametro> listParametro = new ArrayList<Parametro>();

            for (ParametroDTO parametroDTO : listParametroDTO) {
                Parametro parametro = parametroDTOToParametro(parametroDTO);

                listParametro.add(parametro);
            }

            return listParametro;
        } catch (Exception e) {
            throw e;
        }
    }
}
