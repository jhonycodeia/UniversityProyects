package co.edu.usbcali.arquitectura.presentation.businessDelegate;

import co.edu.usbcali.arquitectura.modelo.Idioma;
import co.edu.usbcali.arquitectura.modelo.Nombre;
import co.edu.usbcali.arquitectura.modelo.Saludo;
import co.edu.usbcali.arquitectura.modelo.control.IIdiomaLogic;
import co.edu.usbcali.arquitectura.modelo.control.INombreLogic;
import co.edu.usbcali.arquitectura.modelo.control.ISaludoLogic;
import co.edu.usbcali.arquitectura.modelo.control.IdiomaLogic;
import co.edu.usbcali.arquitectura.modelo.control.NombreLogic;
import co.edu.usbcali.arquitectura.modelo.control.SaludoLogic;
import co.edu.usbcali.arquitectura.modelo.dto.IdiomaDTO;
import co.edu.usbcali.arquitectura.modelo.dto.NombreDTO;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoDTO;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoNombreDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Idioma> getIdioma() throws Exception;

    public void saveIdioma(Idioma entity) throws Exception;

    public void deleteIdioma(Idioma entity) throws Exception;

    public void updateIdioma(Idioma entity) throws Exception;

    public Idioma getIdioma(Integer idIdioma) throws Exception;

    public List<Idioma> findByCriteriaInIdioma(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Idioma> findPageIdioma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberIdioma() throws Exception;

    public List<IdiomaDTO> getDataIdioma() throws Exception;

    public void validateIdioma(Idioma idioma) throws Exception;

    public List<Nombre> getNombre() throws Exception;

    public void saveNombre(Nombre entity) throws Exception;

    public void deleteNombre(Nombre entity) throws Exception;

    public void updateNombre(Nombre entity) throws Exception;

    public Nombre getNombre(Integer idNombre) throws Exception;

    public List<Nombre> findByCriteriaInNombre(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Nombre> findPageNombre(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberNombre() throws Exception;

    public List<NombreDTO> getDataNombre() throws Exception;

    public void validateNombre(Nombre nombre) throws Exception;

    public List<Saludo> getSaludo() throws Exception;

    public void saveSaludo(Saludo entity) throws Exception;

    public void deleteSaludo(Saludo entity) throws Exception;

    public void updateSaludo(Saludo entity) throws Exception;

    public Saludo getSaludo(Integer idSaludo) throws Exception;

    public List<Saludo> findByCriteriaInSaludo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Saludo> findPageSaludo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSaludo() throws Exception;

    public List<SaludoDTO> getDataSaludo() throws Exception;

    public void validateSaludo(Saludo saludo) throws Exception;
    public SaludoNombreDTO SaludoNombre(String nombre) throws Exception;
}
