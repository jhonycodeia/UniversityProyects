package com.saberpro.dto.mapper;

import com.saberpro.modelo.Matricula;
import com.saberpro.modelo.dto.MatriculaDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IMatriculaMapper {
    public MatriculaDTO matriculaToMatriculaDTO(Matricula matricula)
        throws Exception;

    public Matricula matriculaDTOToMatricula(MatriculaDTO matriculaDTO)
        throws Exception;

    public List<MatriculaDTO> listMatriculaToListMatriculaDTO(
        List<Matricula> matriculas) throws Exception;

    public List<Matricula> listMatriculaDTOToListMatricula(
        List<MatriculaDTO> matriculaDTOs) throws Exception;
}
