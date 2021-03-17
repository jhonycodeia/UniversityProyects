package com.saberpro.dto.mapper;

import com.saberpro.modelo.Programa;
import com.saberpro.modelo.dto.ProgramaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IProgramaMapper {
    public ProgramaDTO programaToProgramaDTO(Programa programa)
        throws Exception;

    public Programa programaDTOToPrograma(ProgramaDTO programaDTO)
        throws Exception;

    public List<ProgramaDTO> listProgramaToListProgramaDTO(
        List<Programa> programas) throws Exception;

    public List<Programa> listProgramaDTOToListPrograma(
        List<ProgramaDTO> programaDTOs) throws Exception;
}
