package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.Imagen;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.ImagenDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class ImagenMapper implements IImagenMapper {
    private static final Logger log = LoggerFactory.getLogger(ImagenMapper.class);

    /**
    * Logic injected by Spring that manages Pregunta entities
    *
    */
    @Autowired
    IPreguntaLogic logicPregunta1;

    @Transactional(readOnly = true)
    public ImagenDTO imagenToImagenDTO(Imagen imagen) throws Exception {
        try {
            ImagenDTO imagenDTO = new ImagenDTO();

            imagenDTO.setIdImagen(imagen.getIdImagen());
            imagenDTO.setActivo((imagen.getActivo() != null)
                ? imagen.getActivo() : null);
            imagenDTO.setDescripcion((imagen.getDescripcion() != null)
                ? imagen.getDescripcion() : null);
            imagenDTO.setFechaCreacion(imagen.getFechaCreacion());
            imagenDTO.setFechaModificacion(imagen.getFechaModificacion());
            imagenDTO.setNombre((imagen.getNombre() != null)
                ? imagen.getNombre() : null);
            imagenDTO.setRuta((imagen.getRuta() != null) ? imagen.getRuta() : null);
            imagenDTO.setUsuCreador((imagen.getUsuCreador() != null)
                ? imagen.getUsuCreador() : null);
            imagenDTO.setUsuModificador((imagen.getUsuModificador() != null)
                ? imagen.getUsuModificador() : null);
            imagenDTO.setIdPregunta_Pregunta((imagen.getPregunta()
                                                    .getIdPregunta() != null)
                ? imagen.getPregunta().getIdPregunta() : null);

            return imagenDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Imagen imagenDTOToImagen(ImagenDTO imagenDTO)
        throws Exception {
        try {
            Imagen imagen = new Imagen();

            imagen.setIdImagen(imagenDTO.getIdImagen());
            imagen.setActivo((imagenDTO.getActivo() != null)
                ? imagenDTO.getActivo() : null);
            imagen.setDescripcion((imagenDTO.getDescripcion() != null)
                ? imagenDTO.getDescripcion() : null);
            imagen.setFechaCreacion(imagenDTO.getFechaCreacion());
            imagen.setFechaModificacion(imagenDTO.getFechaModificacion());
            imagen.setNombre((imagenDTO.getNombre() != null)
                ? imagenDTO.getNombre() : null);
            imagen.setRuta((imagenDTO.getRuta() != null) ? imagenDTO.getRuta()
                                                         : null);
            imagen.setUsuCreador((imagenDTO.getUsuCreador() != null)
                ? imagenDTO.getUsuCreador() : null);
            imagen.setUsuModificador((imagenDTO.getUsuModificador() != null)
                ? imagenDTO.getUsuModificador() : null);

            Pregunta pregunta = new Pregunta();

            if (imagenDTO.getIdPregunta_Pregunta() != null) {
                pregunta = logicPregunta1.getPregunta(imagenDTO.getIdPregunta_Pregunta());
            }

            if (pregunta != null) {
                imagen.setPregunta(pregunta);
            }

            return imagen;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ImagenDTO> listImagenToListImagenDTO(List<Imagen> listImagen)
        throws Exception {
        try {
            List<ImagenDTO> imagenDTOs = new ArrayList<ImagenDTO>();

            for (Imagen imagen : listImagen) {
                ImagenDTO imagenDTO = imagenToImagenDTO(imagen);

                imagenDTOs.add(imagenDTO);
            }

            return imagenDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Imagen> listImagenDTOToListImagen(List<ImagenDTO> listImagenDTO)
        throws Exception {
        try {
            List<Imagen> listImagen = new ArrayList<Imagen>();

            for (ImagenDTO imagenDTO : listImagenDTO) {
                Imagen imagen = imagenDTOToImagen(imagenDTO);

                listImagen.add(imagen);
            }

            return listImagen;
        } catch (Exception e) {
            throw e;
        }
    }
}
