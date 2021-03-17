package com.saberpro.dto.mapper;

import com.saberpro.modelo.ProgramaModulo;
import com.saberpro.modelo.dto.ProgramaModuloDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IProgramaModuloMapper {
    public ProgramaModuloDTO programaModuloToProgramaModuloDTO(
        ProgramaModulo programaModulo) throws Exception;

    public ProgramaModulo programaModuloDTOToProgramaModulo(
        ProgramaModuloDTO programaModuloDTO) throws Exception;

    public List<ProgramaModuloDTO> listProgramaModuloToListProgramaModuloDTO(
        List<ProgramaModulo> programaModulos) throws Exception;

    public List<ProgramaModulo> listProgramaModuloDTOToListProgramaModulo(
        List<ProgramaModuloDTO> programaModuloDTOs) throws Exception;
}
