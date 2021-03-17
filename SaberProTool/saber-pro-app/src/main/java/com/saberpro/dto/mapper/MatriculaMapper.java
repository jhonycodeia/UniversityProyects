package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.Matricula;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.MatriculaDTO;

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
public class MatriculaMapper implements IMatriculaMapper {
    private static final Logger log = LoggerFactory.getLogger(MatriculaMapper.class);

    /**
    * Logic injected by Spring that manages PruebaReal entities
    *
    */
    @Autowired
    IPruebaRealLogic logicPruebaReal1;

    /**
    * Logic injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    IUsuarioLogic logicUsuario2;

    @Transactional(readOnly = true)
    public MatriculaDTO matriculaToMatriculaDTO(Matricula matricula)
        throws Exception {
        try {
            MatriculaDTO matriculaDTO = new MatriculaDTO();

            matriculaDTO.setIdMatricula(matricula.getIdMatricula());
            matriculaDTO.setActivo((matricula.getActivo() != null)
                ? matricula.getActivo() : null);
            matriculaDTO.setFechaCreacion(matricula.getFechaCreacion());
            matriculaDTO.setFechaModificacion(matricula.getFechaModificacion());
            matriculaDTO.setUsuCreador((matricula.getUsuCreador() != null)
                ? matricula.getUsuCreador() : null);
            matriculaDTO.setUsuModificador((matricula.getUsuModificador() != null)
                ? matricula.getUsuModificador() : null);
            matriculaDTO.setIdPruebaReal_PruebaReal((matricula.getPruebaReal()
                                                              .getIdPruebaReal() != null)
                ? matricula.getPruebaReal().getIdPruebaReal() : null);
            matriculaDTO.setIdUsuario_Usuario((matricula.getUsuario()
                                                        .getIdUsuario() != null)
                ? matricula.getUsuario().getIdUsuario() : null);

            return matriculaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Matricula matriculaDTOToMatricula(MatriculaDTO matriculaDTO)
        throws Exception {
        try {
            Matricula matricula = new Matricula();

            matricula.setIdMatricula(matriculaDTO.getIdMatricula());
            matricula.setActivo((matriculaDTO.getActivo() != null)
                ? matriculaDTO.getActivo() : null);
            matricula.setFechaCreacion(matriculaDTO.getFechaCreacion());
            matricula.setFechaModificacion(matriculaDTO.getFechaModificacion());
            matricula.setUsuCreador((matriculaDTO.getUsuCreador() != null)
                ? matriculaDTO.getUsuCreador() : null);
            matricula.setUsuModificador((matriculaDTO.getUsuModificador() != null)
                ? matriculaDTO.getUsuModificador() : null);

            PruebaReal pruebaReal = new PruebaReal();

            if (matriculaDTO.getIdPruebaReal_PruebaReal() != null) {
                pruebaReal = logicPruebaReal1.getPruebaReal(matriculaDTO.getIdPruebaReal_PruebaReal());
            }

            if (pruebaReal != null) {
                matricula.setPruebaReal(pruebaReal);
            }

            Usuario usuario = new Usuario();

            if (matriculaDTO.getIdUsuario_Usuario() != null) {
                usuario = logicUsuario2.getUsuario(matriculaDTO.getIdUsuario_Usuario());
            }

            if (usuario != null) {
                matricula.setUsuario(usuario);
            }

            return matricula;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<MatriculaDTO> listMatriculaToListMatriculaDTO(
        List<Matricula> listMatricula) throws Exception {
        try {
            List<MatriculaDTO> matriculaDTOs = new ArrayList<MatriculaDTO>();

            for (Matricula matricula : listMatricula) {
                MatriculaDTO matriculaDTO = matriculaToMatriculaDTO(matricula);

                matriculaDTOs.add(matriculaDTO);
            }

            return matriculaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Matricula> listMatriculaDTOToListMatricula(
        List<MatriculaDTO> listMatriculaDTO) throws Exception {
        try {
            List<Matricula> listMatricula = new ArrayList<Matricula>();

            for (MatriculaDTO matriculaDTO : listMatriculaDTO) {
                Matricula matricula = matriculaDTOToMatricula(matriculaDTO);

                listMatricula.add(matricula);
            }

            return listMatricula;
        } catch (Exception e) {
            throw e;
        }
    }
}
