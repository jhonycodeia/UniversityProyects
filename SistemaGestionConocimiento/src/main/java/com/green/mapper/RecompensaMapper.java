package com.green.mapper;

import com.green.dto.RecompensaDTO;

import com.green.modelo.Recompensa;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface RecompensaMapper {
    public RecompensaDTO recompensaToRecompensaDTO(Recompensa recompensa)
        throws Exception;

    public Recompensa recompensaDTOToRecompensa(RecompensaDTO recompensaDTO)
        throws Exception;

    public List<RecompensaDTO> listRecompensaToListRecompensaDTO(
        List<Recompensa> recompensas) throws Exception;

    public List<Recompensa> listRecompensaDTOToListRecompensa(
        List<RecompensaDTO> recompensaDTOs) throws Exception;
}
