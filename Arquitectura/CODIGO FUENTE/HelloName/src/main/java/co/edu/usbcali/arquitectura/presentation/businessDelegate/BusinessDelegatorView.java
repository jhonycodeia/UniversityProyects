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
import co.edu.usbcali.arquitectura.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private IIdiomaLogic idiomaLogic;
    @Autowired
    private INombreLogic nombreLogic;
    @Autowired
    private ISaludoLogic saludoLogic;

    public List<Idioma> getIdioma() throws Exception {
        return idiomaLogic.getIdioma();
    }

    public void saveIdioma(Idioma entity) throws Exception {
        idiomaLogic.saveIdioma(entity);
    }

    public void deleteIdioma(Idioma entity) throws Exception {
        idiomaLogic.deleteIdioma(entity);
    }

    public void updateIdioma(Idioma entity) throws Exception {
        idiomaLogic.updateIdioma(entity);
    }

    public Idioma getIdioma(Integer idIdioma) throws Exception {
        Idioma idioma = null;

        try {
            idioma = idiomaLogic.getIdioma(idIdioma);
        } catch (Exception e) {
            throw e;
        }

        return idioma;
    }

    public List<Idioma> findByCriteriaInIdioma(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return idiomaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Idioma> findPageIdioma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return idiomaLogic.findPageIdioma(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberIdioma() throws Exception {
        return idiomaLogic.findTotalNumberIdioma();
    }

    public List<IdiomaDTO> getDataIdioma() throws Exception {
        return idiomaLogic.getDataIdioma();
    }

    public void validateIdioma(Idioma idioma) throws Exception {
        idiomaLogic.validateIdioma(idioma);
    }

    public List<Nombre> getNombre() throws Exception {
        return nombreLogic.getNombre();
    }

    public void saveNombre(Nombre entity) throws Exception {
        nombreLogic.saveNombre(entity);
    }

    public void deleteNombre(Nombre entity) throws Exception {
        nombreLogic.deleteNombre(entity);
    }

    public void updateNombre(Nombre entity) throws Exception {
        nombreLogic.updateNombre(entity);
    }

    public Nombre getNombre(Integer idNombre) throws Exception {
        Nombre nombre = null;

        try {
            nombre = nombreLogic.getNombre(idNombre);
        } catch (Exception e) {
            throw e;
        }

        return nombre;
    }

    public List<Nombre> findByCriteriaInNombre(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return nombreLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Nombre> findPageNombre(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return nombreLogic.findPageNombre(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberNombre() throws Exception {
        return nombreLogic.findTotalNumberNombre();
    }

    public List<NombreDTO> getDataNombre() throws Exception {
        return nombreLogic.getDataNombre();
    }

    public void validateNombre(Nombre nombre) throws Exception {
        nombreLogic.validateNombre(nombre);
    }

    public List<Saludo> getSaludo() throws Exception {
        return saludoLogic.getSaludo();
    }

    public void saveSaludo(Saludo entity) throws Exception {
        saludoLogic.saveSaludo(entity);
    }

    public void deleteSaludo(Saludo entity) throws Exception {
        saludoLogic.deleteSaludo(entity);
    }

    public void updateSaludo(Saludo entity) throws Exception {
        saludoLogic.updateSaludo(entity);
    }

    public Saludo getSaludo(Integer idSaludo) throws Exception {
        Saludo saludo = null;

        try {
            saludo = saludoLogic.getSaludo(idSaludo);
        } catch (Exception e) {
            throw e;
        }

        return saludo;
    }

    public List<Saludo> findByCriteriaInSaludo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return saludoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Saludo> findPageSaludo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return saludoLogic.findPageSaludo(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberSaludo() throws Exception {
        return saludoLogic.findTotalNumberSaludo();
    }

    public List<SaludoDTO> getDataSaludo() throws Exception {
        return saludoLogic.getDataSaludo();
    }

    public void validateSaludo(Saludo saludo) throws Exception {
        saludoLogic.validateSaludo(saludo);
    }

	@Override
	public SaludoNombreDTO SaludoNombre(String nombre) throws Exception {
		return saludoLogic.SaludoNombre(nombre);
	}


}
