package com.green.mapper;

import com.green.dto.TrofeoDTO;

import com.green.modelo.*;
import com.green.modelo.Trofeo;

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
public class TrofeoMapperImpl implements TrofeoMapper {
    private static final Logger log = LoggerFactory.getLogger(TrofeoMapperImpl.class);

    @Transactional(readOnly = true)
    public TrofeoDTO trofeoToTrofeoDTO(Trofeo trofeo) throws Exception {
        try {
            TrofeoDTO trofeoDTO = new TrofeoDTO();

            trofeoDTO.setIdTrofeo(trofeo.getIdTrofeo());
            trofeoDTO.setActivo((trofeo.getActivo() != null)
                ? trofeo.getActivo() : null);
            trofeoDTO.setDescripcion((trofeo.getDescripcion() != null)
                ? trofeo.getDescripcion() : null);
            trofeoDTO.setFechaCreacion(trofeo.getFechaCreacion());
            trofeoDTO.setFechaModificacion(trofeo.getFechaModificacion());
            trofeoDTO.setNombre((trofeo.getNombre() != null)
                ? trofeo.getNombre() : null);
            trofeoDTO.setRequisito((trofeo.getRequisito() != null)
                ? trofeo.getRequisito() : null);
            trofeoDTO.setUsuCreador((trofeo.getUsuCreador() != null)
                ? trofeo.getUsuCreador() : null);
            trofeoDTO.setUsuModificador((trofeo.getUsuModificador() != null)
                ? trofeo.getUsuModificador() : null);
            trofeoDTO.setValor((trofeo.getValor() != null) ? trofeo.getValor()
                                                           : null);

            return trofeoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Trofeo trofeoDTOToTrofeo(TrofeoDTO trofeoDTO)
        throws Exception {
        try {
            Trofeo trofeo = new Trofeo();

            trofeo.setIdTrofeo(trofeoDTO.getIdTrofeo());
            trofeo.setActivo((trofeoDTO.getActivo() != null)
                ? trofeoDTO.getActivo() : null);
            trofeo.setDescripcion((trofeoDTO.getDescripcion() != null)
                ? trofeoDTO.getDescripcion() : null);
            trofeo.setFechaCreacion(trofeoDTO.getFechaCreacion());
            trofeo.setFechaModificacion(trofeoDTO.getFechaModificacion());
            trofeo.setNombre((trofeoDTO.getNombre() != null)
                ? trofeoDTO.getNombre() : null);
            trofeo.setRequisito((trofeoDTO.getRequisito() != null)
                ? trofeoDTO.getRequisito() : null);
            trofeo.setUsuCreador((trofeoDTO.getUsuCreador() != null)
                ? trofeoDTO.getUsuCreador() : null);
            trofeo.setUsuModificador((trofeoDTO.getUsuModificador() != null)
                ? trofeoDTO.getUsuModificador() : null);
            trofeo.setValor((trofeoDTO.getValor() != null)
                ? trofeoDTO.getValor() : null);

            return trofeo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TrofeoDTO> listTrofeoToListTrofeoDTO(List<Trofeo> listTrofeo)
        throws Exception {
        try {
            List<TrofeoDTO> trofeoDTOs = new ArrayList<TrofeoDTO>();

            for (Trofeo trofeo : listTrofeo) {
                TrofeoDTO trofeoDTO = trofeoToTrofeoDTO(trofeo);

                trofeoDTOs.add(trofeoDTO);
            }

            return trofeoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Trofeo> listTrofeoDTOToListTrofeo(List<TrofeoDTO> listTrofeoDTO)
        throws Exception {
        try {
            List<Trofeo> listTrofeo = new ArrayList<Trofeo>();

            for (TrofeoDTO trofeoDTO : listTrofeoDTO) {
                Trofeo trofeo = trofeoDTOToTrofeo(trofeoDTO);

                listTrofeo.add(trofeo);
            }

            return listTrofeo;
        } catch (Exception e) {
            throw e;
        }
    }
}
