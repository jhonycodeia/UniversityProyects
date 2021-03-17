package co.edu.usbcali.arquitectura.dto.mapper;

import co.edu.usbcali.arquitectura.modelo.Saludo;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ISaludoMapper {
    public SaludoDTO saludoToSaludoDTO(Saludo saludo) throws Exception;

    public Saludo saludoDTOToSaludo(SaludoDTO saludoDTO)
        throws Exception;

    public List<SaludoDTO> listSaludoToListSaludoDTO(List<Saludo> saludos)
        throws Exception;

    public List<Saludo> listSaludoDTOToListSaludo(List<SaludoDTO> saludoDTOs)
        throws Exception;
}
