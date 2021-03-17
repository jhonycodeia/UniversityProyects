package co.edu.usbcali.arquitectura.dto.mapper;

import co.edu.usbcali.arquitectura.modelo.Idioma;
import co.edu.usbcali.arquitectura.modelo.dto.IdiomaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IIdiomaMapper {
    public IdiomaDTO idiomaToIdiomaDTO(Idioma idioma) throws Exception;

    public Idioma idiomaDTOToIdioma(IdiomaDTO idiomaDTO)
        throws Exception;

    public List<IdiomaDTO> listIdiomaToListIdiomaDTO(List<Idioma> idiomas)
        throws Exception;

    public List<Idioma> listIdiomaDTOToListIdioma(List<IdiomaDTO> idiomaDTOs)
        throws Exception;
}
