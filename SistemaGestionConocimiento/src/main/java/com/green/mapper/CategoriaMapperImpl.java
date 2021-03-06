package com.green.mapper;

import com.green.dto.CategoriaDTO;

import com.green.modelo.*;
import com.green.modelo.Categoria;

import com.green.service.*;

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
public class CategoriaMapperImpl implements CategoriaMapper {
    private static final Logger log = LoggerFactory.getLogger(CategoriaMapperImpl.class);

    @Transactional(readOnly = true)
    public CategoriaDTO categoriaToCategoriaDTO(Categoria categoria)
        throws Exception {
        try {
            CategoriaDTO categoriaDTO = new CategoriaDTO();

            categoriaDTO.setIdCategoria(categoria.getIdCategoria());
            categoriaDTO.setActivo((categoria.getActivo() != null)
                ? categoria.getActivo() : null);
            categoriaDTO.setDescripcion((categoria.getDescripcion() != null)
                ? categoria.getDescripcion() : null);
            categoriaDTO.setFechaCreacion(categoria.getFechaCreacion());
            categoriaDTO.setFechaModificacion(categoria.getFechaModificacion());
            categoriaDTO.setNombre((categoria.getNombre() != null)
                ? categoria.getNombre() : null);
            categoriaDTO.setUsuCreador((categoria.getUsuCreador() != null)
                ? categoria.getUsuCreador() : null);
            categoriaDTO.setUsuModificador((categoria.getUsuModificador() != null)
                ? categoria.getUsuModificador() : null);

            return categoriaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO)
        throws Exception {
        try {
            Categoria categoria = new Categoria();

            categoria.setIdCategoria(categoriaDTO.getIdCategoria());
            categoria.setActivo((categoriaDTO.getActivo() != null)
                ? categoriaDTO.getActivo() : null);
            categoria.setDescripcion((categoriaDTO.getDescripcion() != null)
                ? categoriaDTO.getDescripcion() : null);
            categoria.setFechaCreacion(categoriaDTO.getFechaCreacion());
            categoria.setFechaModificacion(categoriaDTO.getFechaModificacion());
            categoria.setNombre((categoriaDTO.getNombre() != null)
                ? categoriaDTO.getNombre() : null);
            categoria.setUsuCreador((categoriaDTO.getUsuCreador() != null)
                ? categoriaDTO.getUsuCreador() : null);
            categoria.setUsuModificador((categoriaDTO.getUsuModificador() != null)
                ? categoriaDTO.getUsuModificador() : null);

            return categoria;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CategoriaDTO> listCategoriaToListCategoriaDTO(
        List<Categoria> listCategoria) throws Exception {
        try {
            List<CategoriaDTO> categoriaDTOs = new ArrayList<CategoriaDTO>();

            for (Categoria categoria : listCategoria) {
                CategoriaDTO categoriaDTO = categoriaToCategoriaDTO(categoria);

                categoriaDTOs.add(categoriaDTO);
            }

            return categoriaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Categoria> listCategoriaDTOToListCategoria(
        List<CategoriaDTO> listCategoriaDTO) throws Exception {
        try {
            List<Categoria> listCategoria = new ArrayList<Categoria>();

            for (CategoriaDTO categoriaDTO : listCategoriaDTO) {
                Categoria categoria = categoriaDTOToCategoria(categoriaDTO);

                listCategoria.add(categoria);
            }

            return listCategoria;
        } catch (Exception e) {
            throw e;
        }
    }
}
