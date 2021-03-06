package com.co.indra.mapper;

import com.co.indra.dto.RegistroCalculoDTO;
import com.co.indra.model.RegistroCalculo;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface RegistroCalculoMapper {
    public RegistroCalculoDTO registroCalculoToRegistroCalculoDTO(
        RegistroCalculo registroCalculo) throws Exception;

    public RegistroCalculo registroCalculoDTOToRegistroCalculo(
        RegistroCalculoDTO registroCalculoDTO) throws Exception;

    public List<RegistroCalculoDTO> listRegistroCalculoToListRegistroCalculoDTO(
        List<RegistroCalculo> registroCalculos) throws Exception;

    public List<RegistroCalculo> listRegistroCalculoDTOToListRegistroCalculo(
        List<RegistroCalculoDTO> registroCalculoDTOs) throws Exception;
}
