package com.saberpro.dto.mapper;

import com.saberpro.modelo.Modulo;
import com.saberpro.modelo.dto.ModuloDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IModuloMapper {
    public ModuloDTO moduloToModuloDTO(Modulo modulo) throws Exception;

    public Modulo moduloDTOToModulo(ModuloDTO moduloDTO)
        throws Exception;

    public List<ModuloDTO> listModuloToListModuloDTO(List<Modulo> modulos)
        throws Exception;

    public List<Modulo> listModuloDTOToListModulo(List<ModuloDTO> moduloDTOs)
        throws Exception;
}
