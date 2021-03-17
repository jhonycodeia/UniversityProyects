package co.edu.usbcali.arquitectura.dto.mapper;

import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.Saludo;
import co.edu.usbcali.arquitectura.modelo.control.*;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class SaludoMapper implements ISaludoMapper {
    private static final Logger log = LoggerFactory.getLogger(SaludoMapper.class);

    /**
    * Logic injected by Spring that manages Idioma entities
    *
    */
    @Autowired
    IIdiomaLogic logicIdioma1;

    @Transactional(readOnly = true)
    public SaludoDTO saludoToSaludoDTO(Saludo saludo) throws Exception {
        try {
            SaludoDTO saludoDTO = new SaludoDTO();

            saludoDTO.setIdSaludo(saludo.getIdSaludo());
            saludoDTO.setSaludo((saludo.getSaludo() != null)
                ? saludo.getSaludo() : null);
            saludoDTO.setIdIdioma_Idioma((saludo.getIdioma().getIdIdioma() != null)
                ? saludo.getIdioma().getIdIdioma() : null);

            return saludoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Saludo saludoDTOToSaludo(SaludoDTO saludoDTO)
        throws Exception {
        try {
            Saludo saludo = new Saludo();

            saludo.setIdSaludo(saludoDTO.getIdSaludo());
            saludo.setSaludo((saludoDTO.getSaludo() != null)
                ? saludoDTO.getSaludo() : null);

            Idioma idioma = new Idioma();

            if (saludoDTO.getIdIdioma_Idioma() != null) {
                idioma = logicIdioma1.getIdioma(saludoDTO.getIdIdioma_Idioma());
            }

            if (idioma != null) {
                saludo.setIdioma(idioma);
            }

            return saludo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SaludoDTO> listSaludoToListSaludoDTO(List<Saludo> listSaludo)
        throws Exception {
        try {
            List<SaludoDTO> saludoDTOs = new ArrayList<SaludoDTO>();

            for (Saludo saludo : listSaludo) {
                SaludoDTO saludoDTO = saludoToSaludoDTO(saludo);

                saludoDTOs.add(saludoDTO);
            }

            return saludoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Saludo> listSaludoDTOToListSaludo(List<SaludoDTO> listSaludoDTO)
        throws Exception {
        try {
            List<Saludo> listSaludo = new ArrayList<Saludo>();

            for (SaludoDTO saludoDTO : listSaludoDTO) {
                Saludo saludo = saludoDTOToSaludo(saludoDTO);

                listSaludo.add(saludo);
            }

            return listSaludo;
        } catch (Exception e) {
            throw e;
        }
    }
}
