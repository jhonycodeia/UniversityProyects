package com.co.indra.view;

import com.co.indra.dto.CalculoDTO;
import com.co.indra.dto.RegistroCalculoDTO;
import com.co.indra.dto.UsuariosDTO;
import com.co.indra.model.RegistroCalculo;
import com.co.indra.model.Usuarios;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface BusinessDelegator {
    public List<Usuarios> getUsuarios() throws Exception;

    public void saveUsuarios(Usuarios entity) throws Exception;

    public void deleteUsuarios(Usuarios entity) throws Exception;

    public void updateUsuarios(Usuarios entity) throws Exception;

    public Usuarios getUsuarios(Integer idUsuario) throws Exception;

    public List<Usuarios> findByCriteriaInUsuarios(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuarios> findPageUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuarios() throws Exception;

    public List<UsuariosDTO> getDataUsuarios() throws Exception;

    public void validateUsuarios(Usuarios usuarios) throws Exception;

    public List<RegistroCalculo> getRegistroCalculo() throws Exception;

    public void saveRegistroCalculo(RegistroCalculo entity)
        throws Exception;

    public void deleteRegistroCalculo(RegistroCalculo entity)
        throws Exception;

    public void updateRegistroCalculo(RegistroCalculo entity)
        throws Exception;

    public RegistroCalculo getRegistroCalculo(Integer idResultado)
        throws Exception;

    public List<RegistroCalculo> findByCriteriaInRegistroCalculo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<RegistroCalculo> findPageRegistroCalculo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberRegistroCalculo() throws Exception;

    public List<RegistroCalculoDTO> getDataRegistroCalculo()
        throws Exception;

    public void validateRegistroCalculo(RegistroCalculo registroCalculo)
        throws Exception;
    
    public RegistroCalculo saveRegistroCalculo(CalculoDTO entity)
            throws Exception;
}
