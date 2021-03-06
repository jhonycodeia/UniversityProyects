package co.edu.usbcali.arquitectura.dto.mapper;

import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.Nombre;
import co.edu.usbcali.arquitectura.modelo.control.*;
import co.edu.usbcali.arquitectura.modelo.dto.NombreDTO;

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
public class NombreMapper implements INombreMapper {
    private static final Logger log = LoggerFactory.getLogger(NombreMapper.class);

    /**
    * Logic injected by Spring that manages Idioma entities
    *
    */
    @Autowired
    IIdiomaLogic logicIdioma1;

    @Transactional(readOnly = true)
    public NombreDTO nombreToNombreDTO(Nombre nombre) throws Exception {
        try {
            NombreDTO nombreDTO = new NombreDTO();

            nombreDTO.setIdNombre(nombre.getIdNombre());
            nombreDTO.setNombre((nombre.getNombre() != null)
                ? nombre.getNombre() : null);
            nombreDTO.setIdIdioma_Idioma((nombre.getIdioma().getIdIdioma() != null)
                ? nombre.getIdioma().getIdIdioma() : null);

            return nombreDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Nombre nombreDTOToNombre(NombreDTO nombreDTO)
        throws Exception {
        try {
            Nombre nombre = new Nombre();

            nombre.setIdNombre(nombreDTO.getIdNombre());
            nombre.setNombre((nombreDTO.getNombre() != null)
                ? nombreDTO.getNombre() : null);

            Idioma idioma = new Idioma();

            if (nombreDTO.getIdIdioma_Idioma() != null) {
                idioma = logicIdioma1.getIdioma(nombreDTO.getIdIdioma_Idioma());
            }

            if (idioma != null) {
                nombre.setIdioma(idioma);
            }

            return nombre;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<NombreDTO> listNombreToListNombreDTO(List<Nombre> listNombre)
        throws Exception {
        try {
            List<NombreDTO> nombreDTOs = new ArrayList<NombreDTO>();

            for (Nombre nombre : listNombre) {
                NombreDTO nombreDTO = nombreToNombreDTO(nombre);

                nombreDTOs.add(nombreDTO);
            }

            return nombreDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Nombre> listNombreDTOToListNombre(List<NombreDTO> listNombreDTO)
        throws Exception {
        try {
            List<Nombre> listNombre = new ArrayList<Nombre>();

            for (NombreDTO nombreDTO : listNombreDTO) {
                Nombre nombre = nombreDTOToNombre(nombreDTO);

                listNombre.add(nombre);
            }

            return listNombre;
        } catch (Exception e) {
            throw e;
        }
    }
}
