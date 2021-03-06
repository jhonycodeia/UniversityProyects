package com.saberpro.dto.mapper;

import com.saberpro.modelo.*;
import com.saberpro.modelo.ResultadoReal;
import com.saberpro.modelo.control.*;
import com.saberpro.modelo.dto.ResultadoRealDTO;

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
public class ResultadoRealMapper implements IResultadoRealMapper {
    private static final Logger log = LoggerFactory.getLogger(ResultadoRealMapper.class);

    /**
    * Logic injected by Spring that manages Matricula entities
    *
    */
    @Autowired
    IMatriculaLogic logicMatricula1;

    /**
    * Logic injected by Spring that manages Modulo entities
    *
    */
    @Autowired
    IModuloLogic logicModulo2;

    @Transactional(readOnly = true)
    public ResultadoRealDTO resultadoRealToResultadoRealDTO(
        ResultadoReal resultadoReal) throws Exception {
        try {
            ResultadoRealDTO resultadoRealDTO = new ResultadoRealDTO();

            resultadoRealDTO.setIdResultadoReal(resultadoReal.getIdResultadoReal());
            resultadoRealDTO.setActivo((resultadoReal.getActivo() != null)
                ? resultadoReal.getActivo() : null);
            resultadoRealDTO.setFechaCreacion(resultadoReal.getFechaCreacion());
            resultadoRealDTO.setFechaModificacion(resultadoReal.getFechaModificacion());
            resultadoRealDTO.setPercentilGrupo((resultadoReal.getPercentilGrupo() != null)
                ? resultadoReal.getPercentilGrupo() : null);
            resultadoRealDTO.setPercentilNacional((resultadoReal.getPercentilNacional() != null)
                ? resultadoReal.getPercentilNacional() : null);
            resultadoRealDTO.setUsuCreador((resultadoReal.getUsuCreador() != null)
                ? resultadoReal.getUsuCreador() : null);
            resultadoRealDTO.setUsuModificador((resultadoReal.getUsuModificador() != null)
                ? resultadoReal.getUsuModificador() : null);

            if (resultadoReal.getMatricula() != null) {
                resultadoRealDTO.setIdMatricula_Matricula(resultadoReal.getMatricula()
                                                                       .getIdMatricula());
            } else {
                resultadoRealDTO.setIdMatricula_Matricula(null);
            }

            resultadoRealDTO.setIdModulo_Modulo((resultadoReal.getModulo()
                                                              .getIdModulo() != null)
                ? resultadoReal.getModulo().getIdModulo() : null);

            return resultadoRealDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public ResultadoReal resultadoRealDTOToResultadoReal(
        ResultadoRealDTO resultadoRealDTO) throws Exception {
        try {
            ResultadoReal resultadoReal = new ResultadoReal();

            resultadoReal.setIdResultadoReal(resultadoRealDTO.getIdResultadoReal());
            resultadoReal.setActivo((resultadoRealDTO.getActivo() != null)
                ? resultadoRealDTO.getActivo() : null);
            resultadoReal.setFechaCreacion(resultadoRealDTO.getFechaCreacion());
            resultadoReal.setFechaModificacion(resultadoRealDTO.getFechaModificacion());
            resultadoReal.setPercentilGrupo((resultadoRealDTO.getPercentilGrupo() != null)
                ? resultadoRealDTO.getPercentilGrupo() : null);
            resultadoReal.setPercentilNacional((resultadoRealDTO.getPercentilNacional() != null)
                ? resultadoRealDTO.getPercentilNacional() : null);
            resultadoReal.setUsuCreador((resultadoRealDTO.getUsuCreador() != null)
                ? resultadoRealDTO.getUsuCreador() : null);
            resultadoReal.setUsuModificador((resultadoRealDTO.getUsuModificador() != null)
                ? resultadoRealDTO.getUsuModificador() : null);

            Matricula matricula = new Matricula();

            if (resultadoRealDTO.getIdMatricula_Matricula() != null) {
                matricula = logicMatricula1.getMatricula(resultadoRealDTO.getIdMatricula_Matricula());
            }

            if (matricula != null) {
                resultadoReal.setMatricula(matricula);
            }

            Modulo modulo = new Modulo();

            if (resultadoRealDTO.getIdModulo_Modulo() != null) {
                modulo = logicModulo2.getModulo(resultadoRealDTO.getIdModulo_Modulo());
            }

            if (modulo != null) {
                resultadoReal.setModulo(modulo);
            }

            return resultadoReal;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ResultadoRealDTO> listResultadoRealToListResultadoRealDTO(
        List<ResultadoReal> listResultadoReal) throws Exception {
        try {
            List<ResultadoRealDTO> resultadoRealDTOs = new ArrayList<ResultadoRealDTO>();

            for (ResultadoReal resultadoReal : listResultadoReal) {
                ResultadoRealDTO resultadoRealDTO = resultadoRealToResultadoRealDTO(resultadoReal);

                resultadoRealDTOs.add(resultadoRealDTO);
            }

            return resultadoRealDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ResultadoReal> listResultadoRealDTOToListResultadoReal(
        List<ResultadoRealDTO> listResultadoRealDTO) throws Exception {
        try {
            List<ResultadoReal> listResultadoReal = new ArrayList<ResultadoReal>();

            for (ResultadoRealDTO resultadoRealDTO : listResultadoRealDTO) {
                ResultadoReal resultadoReal = resultadoRealDTOToResultadoReal(resultadoRealDTO);

                listResultadoReal.add(resultadoReal);
            }

            return listResultadoReal;
        } catch (Exception e) {
            throw e;
        }
    }
}
