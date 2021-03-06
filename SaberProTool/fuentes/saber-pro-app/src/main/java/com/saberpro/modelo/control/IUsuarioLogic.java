package com.saberpro.modelo.control;

import com.saberpro.modelo.Usuario;
import com.saberpro.modelo.dto.UsuarioDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.User;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IUsuarioLogic {
    public List<Usuario> getUsuario() throws Exception;

    /**
         * Save an new Usuario entity
         */
    public void saveUsuario(Usuario entity) throws Exception;

    /**
         * Delete an existing Usuario entity
         *
         */
    public void deleteUsuario(Usuario entity) throws Exception;

    /**
        * Update an existing Usuario entity
        *
        */
    public void updateUsuario(Usuario entity) throws Exception;

    /**
         * Load an existing Usuario entity
         *
         */
    public Usuario getUsuario(Long idUsuario) throws Exception;  
    
    public List<Usuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuario() throws Exception;

    public List<UsuarioDTO> getDataUsuario() throws Exception;

    public void validateUsuario(Usuario usuario) throws Exception;
    
    public Usuario findByCodigo(long codigo) throws Exception;
    
    public UsuarioDTO findDataByCodigo(long codigo) throws Exception;
    
    public Usuario findByEmail(String email) throws Exception;
    
    public void resetByEmail(String email) throws Exception;
    
    public User loadByCodigo(long codigo) throws Exception;
    
    public String encodePassword(String code)throws Exception;
    
    public List<Usuario> getUsuario(String tipo) throws Exception;
    
    public List<UsuarioDTO> getDataUsuario(String tipo) throws Exception;
    
    public List<Usuario> findByTipoUsuarioPrograma(long idPrograma,long idTipoUsuario) throws Exception;
    
    public List<Usuario> findByTipoUsuarioFacultad(long idFacultad,long idTipoUsuario) throws Exception;
    
    public List<Usuario> findByUsuarioInPrueba(long idPrueba)throws Exception;
    
    public List<Usuario> findByUsuarioInPruebaActivo(long idPrueba)throws Exception;
    
    public void asignarDecano(Usuario decano,Usuario despedido,long user,long idFacultad)throws Exception;
    
}
