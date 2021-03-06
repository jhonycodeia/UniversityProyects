package co.edu.usbcali.arquitectura.dto.mapper;

import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.Idioma;
import co.edu.usbcali.arquitectura.modelo.control.*;
import co.edu.usbcali.arquitectura.modelo.dto.IdiomaDTO;

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
public class IdiomaMapper implements IIdiomaMapper {
    private static final Logger log = LoggerFactory.getLogger(IdiomaMapper.class);

    @Transactional(readOnly = true)
    public IdiomaDTO idiomaToIdiomaDTO(Idioma idioma) throws Exception {
        try {
            IdiomaDTO idiomaDTO = new IdiomaDTO();

            idiomaDTO.setIdIdioma(idioma.getIdIdioma());
            idiomaDTO.setNombreIdioma((idioma.getNombreIdioma() != null)
                ? idioma.getNombreIdioma() : null);

            return idiomaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Idioma idiomaDTOToIdioma(IdiomaDTO idiomaDTO)
        throws Exception {
        try {
            Idioma idioma = new Idioma();

            idioma.setIdIdioma(idiomaDTO.getIdIdioma());
            idioma.setNombreIdioma((idiomaDTO.getNombreIdioma() != null)
                ? idiomaDTO.getNombreIdioma() : null);

            return idioma;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<IdiomaDTO> listIdiomaToListIdiomaDTO(List<Idioma> listIdioma)
        throws Exception {
        try {
            List<IdiomaDTO> idiomaDTOs = new ArrayList<IdiomaDTO>();

            for (Idioma idioma : listIdioma) {
                IdiomaDTO idiomaDTO = idiomaToIdiomaDTO(idioma);

                idiomaDTOs.add(idiomaDTO);
            }

            return idiomaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Idioma> listIdiomaDTOToListIdioma(List<IdiomaDTO> listIdiomaDTO)
        throws Exception {
        try {
            List<Idioma> listIdioma = new ArrayList<Idioma>();

            for (IdiomaDTO idiomaDTO : listIdiomaDTO) {
                Idioma idioma = idiomaDTOToIdioma(idiomaDTO);

                listIdioma.add(idioma);
            }

            return listIdioma;
        } catch (Exception e) {
            throw e;
        }
    }
}
