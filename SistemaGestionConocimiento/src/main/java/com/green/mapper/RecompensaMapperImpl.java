package com.green.mapper;

import com.green.dto.RecompensaDTO;

import com.green.modelo.*;
import com.green.modelo.Recompensa;

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
public class RecompensaMapperImpl implements RecompensaMapper {
    private static final Logger log = LoggerFactory.getLogger(RecompensaMapperImpl.class);

    @Transactional(readOnly = true)
    public RecompensaDTO recompensaToRecompensaDTO(Recompensa recompensa)
        throws Exception {
        try {
            RecompensaDTO recompensaDTO = new RecompensaDTO();

            recompensaDTO.setIdRecompensa(recompensa.getIdRecompensa());
            recompensaDTO.setActivo((recompensa.getActivo() != null)
                ? recompensa.getActivo() : null);
            recompensaDTO.setDescripcion((recompensa.getDescripcion() != null)
                ? recompensa.getDescripcion() : null);
            recompensaDTO.setFechaCreacion(recompensa.getFechaCreacion());
            recompensaDTO.setFechaModificacion(recompensa.getFechaModificacion());
            recompensaDTO.setNombre((recompensa.getNombre() != null)
                ? recompensa.getNombre() : null);
            recompensaDTO.setRequisito((recompensa.getRequisito() != null)
                ? recompensa.getRequisito() : null);
            recompensaDTO.setUsuCreador((recompensa.getUsuCreador() != null)
                ? recompensa.getUsuCreador() : null);
            recompensaDTO.setUsuModificador((recompensa.getUsuModificador() != null)
                ? recompensa.getUsuModificador() : null);
            recompensaDTO.setValor((recompensa.getValor() != null)
                ? recompensa.getValor() : null);

            return recompensaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Recompensa recompensaDTOToRecompensa(RecompensaDTO recompensaDTO)
        throws Exception {
        try {
            Recompensa recompensa = new Recompensa();

            recompensa.setIdRecompensa(recompensaDTO.getIdRecompensa());
            recompensa.setActivo((recompensaDTO.getActivo() != null)
                ? recompensaDTO.getActivo() : null);
            recompensa.setDescripcion((recompensaDTO.getDescripcion() != null)
                ? recompensaDTO.getDescripcion() : null);
            recompensa.setFechaCreacion(recompensaDTO.getFechaCreacion());
            recompensa.setFechaModificacion(recompensaDTO.getFechaModificacion());
            recompensa.setNombre((recompensaDTO.getNombre() != null)
                ? recompensaDTO.getNombre() : null);
            recompensa.setRequisito((recompensaDTO.getRequisito() != null)
                ? recompensaDTO.getRequisito() : null);
            recompensa.setUsuCreador((recompensaDTO.getUsuCreador() != null)
                ? recompensaDTO.getUsuCreador() : null);
            recompensa.setUsuModificador((recompensaDTO.getUsuModificador() != null)
                ? recompensaDTO.getUsuModificador() : null);
            recompensa.setValor((recompensaDTO.getValor() != null)
                ? recompensaDTO.getValor() : null);

            return recompensa;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RecompensaDTO> listRecompensaToListRecompensaDTO(
        List<Recompensa> listRecompensa) throws Exception {
        try {
            List<RecompensaDTO> recompensaDTOs = new ArrayList<RecompensaDTO>();

            for (Recompensa recompensa : listRecompensa) {
                RecompensaDTO recompensaDTO = recompensaToRecompensaDTO(recompensa);

                recompensaDTOs.add(recompensaDTO);
            }

            return recompensaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Recompensa> listRecompensaDTOToListRecompensa(
        List<RecompensaDTO> listRecompensaDTO) throws Exception {
        try {
            List<Recompensa> listRecompensa = new ArrayList<Recompensa>();

            for (RecompensaDTO recompensaDTO : listRecompensaDTO) {
                Recompensa recompensa = recompensaDTOToRecompensa(recompensaDTO);

                listRecompensa.add(recompensa);
            }

            return listRecompensa;
        } catch (Exception e) {
            throw e;
        }
    }
}
