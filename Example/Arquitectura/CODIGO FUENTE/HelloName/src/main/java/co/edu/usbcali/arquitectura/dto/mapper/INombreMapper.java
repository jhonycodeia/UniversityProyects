package co.edu.usbcali.arquitectura.dto.mapper;

import co.edu.usbcali.arquitectura.modelo.Nombre;
import co.edu.usbcali.arquitectura.modelo.dto.NombreDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface INombreMapper {
    public NombreDTO nombreToNombreDTO(Nombre nombre) throws Exception;

    public Nombre nombreDTOToNombre(NombreDTO nombreDTO)
        throws Exception;

    public List<NombreDTO> listNombreToListNombreDTO(List<Nombre> nombres)
        throws Exception;

    public List<Nombre> listNombreDTOToListNombre(List<NombreDTO> nombreDTOs)
        throws Exception;
}
