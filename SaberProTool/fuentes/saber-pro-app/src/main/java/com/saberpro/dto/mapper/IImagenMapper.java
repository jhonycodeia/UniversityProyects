package com.saberpro.dto.mapper;

import com.saberpro.modelo.Imagen;
import com.saberpro.modelo.dto.ImagenDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IImagenMapper {
    public ImagenDTO imagenToImagenDTO(Imagen imagen) throws Exception;

    public Imagen imagenDTOToImagen(ImagenDTO imagenDTO)
        throws Exception;

    public List<ImagenDTO> listImagenToListImagenDTO(List<Imagen> imagens)
        throws Exception;

    public List<Imagen> listImagenDTOToListImagen(List<ImagenDTO> imagenDTOs)
        throws Exception;
}
