package com.green.view;

import com.green.dto.AreaDTO;
import com.green.dto.CalificacionDTO;
import com.green.dto.CapsulaDTO;
import com.green.dto.CapsulaPalabrasClaveDTO;
import com.green.dto.CategoriaDTO;
import com.green.dto.ComentarioDTO;
import com.green.dto.DocumentoDTO;
import com.green.dto.NotificacionDTO;
import com.green.dto.PalabrasClaveDTO;
import com.green.dto.ParametroDTO;
import com.green.dto.ProcesoDTO;
import com.green.dto.PuntosDTO;
import com.green.dto.RankDTO;
import com.green.dto.RecompensaDTO;
import com.green.dto.RecompensaUsuarioDTO;
import com.green.dto.SubprocesoDTO;
import com.green.dto.TipoCapsulaDTO;
import com.green.dto.TipoDocumentoDTO;
import com.green.dto.TipoNotificacionDTO;
import com.green.dto.TipoPuntosDTO;
import com.green.dto.TipoUsuarioDTO;
import com.green.dto.TrofeoDTO;
import com.green.dto.UsuarioDTO;
import com.green.dto.UsuarioTrofeoDTO;

import com.green.modelo.Area;
import com.green.modelo.Calificacion;
import com.green.modelo.Capsula;
import com.green.modelo.CapsulaPalabrasClave;
import com.green.modelo.Categoria;
import com.green.modelo.Comentario;
import com.green.modelo.Documento;
import com.green.modelo.Notificacion;
import com.green.modelo.PalabrasClave;
import com.green.modelo.Parametro;
import com.green.modelo.Proceso;
import com.green.modelo.Puntos;
import com.green.modelo.Recompensa;
import com.green.modelo.RecompensaUsuario;
import com.green.modelo.Subproceso;
import com.green.modelo.TipoCapsula;
import com.green.modelo.TipoDocumento;
import com.green.modelo.TipoNotificacion;
import com.green.modelo.TipoPuntos;
import com.green.modelo.TipoUsuario;
import com.green.modelo.Trofeo;
import com.green.modelo.Usuario;
import com.green.modelo.UsuarioTrofeo;

import com.green.service.AreaService;
import com.green.service.CalificacionService;
import com.green.service.CapsulaPalabrasClaveService;
import com.green.service.CapsulaService;
import com.green.service.CategoriaService;
import com.green.service.ComentarioService;
import com.green.service.DocumentoService;
import com.green.service.NotificacionService;
import com.green.service.PalabrasClaveService;
import com.green.service.ParametroService;
import com.green.service.ProcesoService;
import com.green.service.PuntosService;
import com.green.service.RecompensaService;
import com.green.service.RecompensaUsuarioService;
import com.green.service.SubprocesoService;
import com.green.service.TipoCapsulaService;
import com.green.service.TipoDocumentoService;
import com.green.service.TipoNotificacionService;
import com.green.service.TipoPuntosService;
import com.green.service.TipoUsuarioService;
import com.green.service.TrofeoService;
import com.green.service.UsuarioService;
import com.green.service.UsuarioTrofeoService;
import com.green.utility.FilesDocumento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Component("businessDelegator")
public class BusinessDelegatorImpl implements BusinessDelegator {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorImpl.class);
    @Autowired
    private ProcesoService procesoService;
    @Autowired
    private SubprocesoService subprocesoService;
    @Autowired
    private UsuarioTrofeoService usuarioTrofeoService;
    @Autowired
    private NotificacionService notificacionService;
    @Autowired
    private CapsulaPalabrasClaveService capsulaPalabrasClaveService;
    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    @Autowired
    private ParametroService parametroService;
    @Autowired
    private PalabrasClaveService palabrasClaveService;
    @Autowired
    private RecompensaService recompensaService;
    @Autowired
    private CapsulaService capsulaService;
    @Autowired
    private TipoCapsulaService tipoCapsulaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TipoNotificacionService tipoNotificacionService;
    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    @Autowired
    private TrofeoService trofeoService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private CalificacionService calificacionService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private RecompensaUsuarioService recompensaUsuarioService;
    @Autowired
    private ComentarioService comentarioService;
    @Autowired
    private TipoPuntosService tipoPuntosService;
    @Autowired
    private PuntosService puntosService;

    public List<Proceso> getProceso() throws Exception {
        return procesoService.getProceso();
    }

    public void saveProceso(Proceso entity) throws Exception {
        procesoService.saveProceso(entity);
    }

    public void deleteProceso(Proceso entity) throws Exception {
        procesoService.deleteProceso(entity);
    }

    public void updateProceso(Proceso entity) throws Exception {
        procesoService.updateProceso(entity);
    }

    public Proceso getProceso(Long idProceso) throws Exception {
        Proceso proceso = null;

        try {
            proceso = procesoService.getProceso(idProceso);
        } catch (Exception e) {
            throw e;
        }

        return proceso;
    }

    public List<Proceso> findByCriteriaInProceso(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return procesoService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Proceso> findPageProceso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return procesoService.findPageProceso(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberProceso() throws Exception {
        return procesoService.findTotalNumberProceso();
    }

    public List<ProcesoDTO> getDataProceso() throws Exception {
        return procesoService.getDataProceso();
    }

    public void validateProceso(Proceso proceso) throws Exception {
        procesoService.validateProceso(proceso);
    }

    public List<Subproceso> getSubproceso() throws Exception {
        return subprocesoService.getSubproceso();
    }

    public void saveSubproceso(Subproceso entity) throws Exception {
        subprocesoService.saveSubproceso(entity);
    }

    public void deleteSubproceso(Subproceso entity) throws Exception {
        subprocesoService.deleteSubproceso(entity);
    }

    public void updateSubproceso(Subproceso entity) throws Exception {
        subprocesoService.updateSubproceso(entity);
    }

    public Subproceso getSubproceso(Long idSubproceso)
        throws Exception {
        Subproceso subproceso = null;

        try {
            subproceso = subprocesoService.getSubproceso(idSubproceso);
        } catch (Exception e) {
            throw e;
        }

        return subproceso;
    }

    public List<Subproceso> findByCriteriaInSubproceso(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return subprocesoService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Subproceso> findPageSubproceso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return subprocesoService.findPageSubproceso(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberSubproceso() throws Exception {
        return subprocesoService.findTotalNumberSubproceso();
    }

    public List<SubprocesoDTO> getDataSubproceso() throws Exception {
        return subprocesoService.getDataSubproceso();
    }

    public void validateSubproceso(Subproceso subproceso)
        throws Exception {
        subprocesoService.validateSubproceso(subproceso);
    }

    public List<UsuarioTrofeo> getUsuarioTrofeo() throws Exception {
        return usuarioTrofeoService.getUsuarioTrofeo();
    }

    public void saveUsuarioTrofeo(UsuarioTrofeo entity)
        throws Exception {
        usuarioTrofeoService.saveUsuarioTrofeo(entity);
    }

    public void deleteUsuarioTrofeo(UsuarioTrofeo entity)
        throws Exception {
        usuarioTrofeoService.deleteUsuarioTrofeo(entity);
    }

    public void updateUsuarioTrofeo(UsuarioTrofeo entity)
        throws Exception {
        usuarioTrofeoService.updateUsuarioTrofeo(entity);
    }

    public UsuarioTrofeo getUsuarioTrofeo(Long idUsuarioTrofeo)
        throws Exception {
        UsuarioTrofeo usuarioTrofeo = null;

        try {
            usuarioTrofeo = usuarioTrofeoService.getUsuarioTrofeo(idUsuarioTrofeo);
        } catch (Exception e) {
            throw e;
        }

        return usuarioTrofeo;
    }

    public List<UsuarioTrofeo> findByCriteriaInUsuarioTrofeo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return usuarioTrofeoService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<UsuarioTrofeo> findPageUsuarioTrofeo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuarioTrofeoService.findPageUsuarioTrofeo(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberUsuarioTrofeo() throws Exception {
        return usuarioTrofeoService.findTotalNumberUsuarioTrofeo();
    }

    public List<UsuarioTrofeoDTO> getDataUsuarioTrofeo()
        throws Exception {
        return usuarioTrofeoService.getDataUsuarioTrofeo();
    }

    public void validateUsuarioTrofeo(UsuarioTrofeo usuarioTrofeo)
        throws Exception {
        usuarioTrofeoService.validateUsuarioTrofeo(usuarioTrofeo);
    }

    public List<Notificacion> getNotificacion() throws Exception {
        return notificacionService.getNotificacion();
    }

    public void saveNotificacion(Notificacion entity) throws Exception {
        notificacionService.saveNotificacion(entity);
    }

    public void deleteNotificacion(Notificacion entity)
        throws Exception {
        notificacionService.deleteNotificacion(entity);
    }

    public void updateNotificacion(Notificacion entity)
        throws Exception {
        notificacionService.updateNotificacion(entity);
    }

    public Notificacion getNotificacion(Long idNotificacion)
        throws Exception {
        Notificacion notificacion = null;

        try {
            notificacion = notificacionService.getNotificacion(idNotificacion);
        } catch (Exception e) {
            throw e;
        }

        return notificacion;
    }

    public List<Notificacion> findByCriteriaInNotificacion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return notificacionService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Notificacion> findPageNotificacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return notificacionService.findPageNotificacion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberNotificacion() throws Exception {
        return notificacionService.findTotalNumberNotificacion();
    }

    public List<NotificacionDTO> getDataNotificacion()
        throws Exception {
        return notificacionService.getDataNotificacion();
    }

    public void validateNotificacion(Notificacion notificacion)
        throws Exception {
        notificacionService.validateNotificacion(notificacion);
    }

    public List<CapsulaPalabrasClave> getCapsulaPalabrasClave()
        throws Exception {
        return capsulaPalabrasClaveService.getCapsulaPalabrasClave();
    }

    public void saveCapsulaPalabrasClave(CapsulaPalabrasClave entity)
        throws Exception {
        capsulaPalabrasClaveService.saveCapsulaPalabrasClave(entity);
    }

    public void deleteCapsulaPalabrasClave(CapsulaPalabrasClave entity)
        throws Exception {
        capsulaPalabrasClaveService.deleteCapsulaPalabrasClave(entity);
    }

    public void updateCapsulaPalabrasClave(CapsulaPalabrasClave entity)
        throws Exception {
        capsulaPalabrasClaveService.updateCapsulaPalabrasClave(entity);
    }

    public CapsulaPalabrasClave getCapsulaPalabrasClave(
        Long idCapsulaPalabraClave) throws Exception {
        CapsulaPalabrasClave capsulaPalabrasClave = null;

        try {
            capsulaPalabrasClave = capsulaPalabrasClaveService.getCapsulaPalabrasClave(idCapsulaPalabraClave);
        } catch (Exception e) {
            throw e;
        }

        return capsulaPalabrasClave;
    }

    public List<CapsulaPalabrasClave> findByCriteriaInCapsulaPalabrasClave(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return capsulaPalabrasClaveService.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<CapsulaPalabrasClave> findPageCapsulaPalabrasClave(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return capsulaPalabrasClaveService.findPageCapsulaPalabrasClave(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberCapsulaPalabrasClave() throws Exception {
        return capsulaPalabrasClaveService.findTotalNumberCapsulaPalabrasClave();
    }

    public List<CapsulaPalabrasClaveDTO> getDataCapsulaPalabrasClave()
        throws Exception {
        return capsulaPalabrasClaveService.getDataCapsulaPalabrasClave();
    }

    public void validateCapsulaPalabrasClave(
        CapsulaPalabrasClave capsulaPalabrasClave) throws Exception {
        capsulaPalabrasClaveService.validateCapsulaPalabrasClave(capsulaPalabrasClave);
    }

    public List<TipoUsuario> getTipoUsuario() throws Exception {
        return tipoUsuarioService.getTipoUsuario();
    }

    public void saveTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioService.saveTipoUsuario(entity);
    }

    public void deleteTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioService.deleteTipoUsuario(entity);
    }

    public void updateTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioService.updateTipoUsuario(entity);
    }

    public TipoUsuario getTipoUsuario(Long idTipoUsuario)
        throws Exception {
        TipoUsuario tipoUsuario = null;

        try {
            tipoUsuario = tipoUsuarioService.getTipoUsuario(idTipoUsuario);
        } catch (Exception e) {
            throw e;
        }

        return tipoUsuario;
    }

    public List<TipoUsuario> findByCriteriaInTipoUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoUsuarioService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoUsuario> findPageTipoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoUsuarioService.findPageTipoUsuario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoUsuario() throws Exception {
        return tipoUsuarioService.findTotalNumberTipoUsuario();
    }

    public List<TipoUsuarioDTO> getDataTipoUsuario() throws Exception {
        return tipoUsuarioService.getDataTipoUsuario();
    }

    public void validateTipoUsuario(TipoUsuario tipoUsuario)
        throws Exception {
        tipoUsuarioService.validateTipoUsuario(tipoUsuario);
    }

    public List<Parametro> getParametro() throws Exception {
        return parametroService.getParametro();
    }

    public void saveParametro(Parametro entity) throws Exception {
        parametroService.saveParametro(entity);
    }

    public void deleteParametro(Parametro entity) throws Exception {
        parametroService.deleteParametro(entity);
    }

    public void updateParametro(Parametro entity) throws Exception {
        parametroService.updateParametro(entity);
    }

    public Parametro getParametro(Long idParametro) throws Exception {
        Parametro parametro = null;

        try {
            parametro = parametroService.getParametro(idParametro);
        } catch (Exception e) {
            throw e;
        }

        return parametro;
    }

    public List<Parametro> findByCriteriaInParametro(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return parametroService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Parametro> findPageParametro(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return parametroService.findPageParametro(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberParametro() throws Exception {
        return parametroService.findTotalNumberParametro();
    }

    public List<ParametroDTO> getDataParametro() throws Exception {
        return parametroService.getDataParametro();
    }

    public void validateParametro(Parametro parametro)
        throws Exception {
        parametroService.validateParametro(parametro);
    }

    public List<PalabrasClave> getPalabrasClave() throws Exception {
        return palabrasClaveService.getPalabrasClave();
    }

    public void savePalabrasClave(PalabrasClave entity)
        throws Exception {
        palabrasClaveService.savePalabrasClave(entity);
    }

    public void deletePalabrasClave(PalabrasClave entity)
        throws Exception {
        palabrasClaveService.deletePalabrasClave(entity);
    }

    public void updatePalabrasClave(PalabrasClave entity)
        throws Exception {
        palabrasClaveService.updatePalabrasClave(entity);
    }

    public PalabrasClave getPalabrasClave(Long idPalabraClave)
        throws Exception {
        PalabrasClave palabrasClave = null;

        try {
            palabrasClave = palabrasClaveService.getPalabrasClave(idPalabraClave);
        } catch (Exception e) {
            throw e;
        }

        return palabrasClave;
    }

    public List<PalabrasClave> findByCriteriaInPalabrasClave(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return palabrasClaveService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<PalabrasClave> findPagePalabrasClave(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return palabrasClaveService.findPagePalabrasClave(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberPalabrasClave() throws Exception {
        return palabrasClaveService.findTotalNumberPalabrasClave();
    }

    public List<PalabrasClaveDTO> getDataPalabrasClave()
        throws Exception {
        return palabrasClaveService.getDataPalabrasClave();
    }

    public void validatePalabrasClave(PalabrasClave palabrasClave)
        throws Exception {
        palabrasClaveService.validatePalabrasClave(palabrasClave);
    }

    public List<Recompensa> getRecompensa() throws Exception {
        return recompensaService.getRecompensa();
    }

    public void saveRecompensa(Recompensa entity) throws Exception {
        recompensaService.saveRecompensa(entity);
    }

    public void deleteRecompensa(Recompensa entity) throws Exception {
        recompensaService.deleteRecompensa(entity);
    }

    public void updateRecompensa(Recompensa entity) throws Exception {
        recompensaService.updateRecompensa(entity);
    }

    public Recompensa getRecompensa(Long idRecompensa)
        throws Exception {
        Recompensa recompensa = null;

        try {
            recompensa = recompensaService.getRecompensa(idRecompensa);
        } catch (Exception e) {
            throw e;
        }

        return recompensa;
    }

    public List<Recompensa> findByCriteriaInRecompensa(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return recompensaService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Recompensa> findPageRecompensa(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return recompensaService.findPageRecompensa(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberRecompensa() throws Exception {
        return recompensaService.findTotalNumberRecompensa();
    }

    public List<RecompensaDTO> getDataRecompensa() throws Exception {
        return recompensaService.getDataRecompensa();
    }

    public void validateRecompensa(Recompensa recompensa)
        throws Exception {
        recompensaService.validateRecompensa(recompensa);
    }

    public List<Capsula> getCapsula() throws Exception {
        return capsulaService.getCapsula();
    }

    public void saveCapsula(Capsula entity) throws Exception {
        capsulaService.saveCapsula(entity);
    }

    public void deleteCapsula(Capsula entity) throws Exception {
        capsulaService.deleteCapsula(entity);
    }

    public void updateCapsula(Capsula entity) throws Exception {
        capsulaService.updateCapsula(entity);
    }

    public Capsula getCapsula(Long idCapsula) throws Exception {
        Capsula capsula = null;

        try {
            capsula = capsulaService.getCapsula(idCapsula);
        } catch (Exception e) {
            throw e;
        }

        return capsula;
    }

    public List<Capsula> findByCriteriaInCapsula(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return capsulaService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Capsula> findPageCapsula(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return capsulaService.findPageCapsula(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCapsula() throws Exception {
        return capsulaService.findTotalNumberCapsula();
    }

    public List<CapsulaDTO> getDataCapsula() throws Exception {
        return capsulaService.getDataCapsula();
    }

    public void validateCapsula(Capsula capsula) throws Exception {
        capsulaService.validateCapsula(capsula);
    }

    public List<TipoCapsula> getTipoCapsula() throws Exception {
        return tipoCapsulaService.getTipoCapsula();
    }

    public void saveTipoCapsula(TipoCapsula entity) throws Exception {
        tipoCapsulaService.saveTipoCapsula(entity);
    }

    public void deleteTipoCapsula(TipoCapsula entity) throws Exception {
        tipoCapsulaService.deleteTipoCapsula(entity);
    }

    public void updateTipoCapsula(TipoCapsula entity) throws Exception {
        tipoCapsulaService.updateTipoCapsula(entity);
    }

    public TipoCapsula getTipoCapsula(Long idTipoCapsula)
        throws Exception {
        TipoCapsula tipoCapsula = null;

        try {
            tipoCapsula = tipoCapsulaService.getTipoCapsula(idTipoCapsula);
        } catch (Exception e) {
            throw e;
        }

        return tipoCapsula;
    }

    public List<TipoCapsula> findByCriteriaInTipoCapsula(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoCapsulaService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoCapsula> findPageTipoCapsula(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoCapsulaService.findPageTipoCapsula(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoCapsula() throws Exception {
        return tipoCapsulaService.findTotalNumberTipoCapsula();
    }

    public List<TipoCapsulaDTO> getDataTipoCapsula() throws Exception {
        return tipoCapsulaService.getDataTipoCapsula();
    }

    public void validateTipoCapsula(TipoCapsula tipoCapsula)
        throws Exception {
        tipoCapsulaService.validateTipoCapsula(tipoCapsula);
    }

    public List<Usuario> getUsuario() throws Exception {
        return usuarioService.getUsuario();
    }

    public void saveUsuario(Usuario entity) throws Exception {
        usuarioService.saveUsuario(entity);
    }

    public void deleteUsuario(Usuario entity) throws Exception {
        usuarioService.deleteUsuario(entity);
    }

    public void updateUsuario(Usuario entity) throws Exception {
        usuarioService.updateUsuario(entity);
    }

    public Usuario getUsuario(Long idUsuario) throws Exception {
        Usuario usuario = null;

        try {
            usuario = usuarioService.getUsuario(idUsuario);
        } catch (Exception e) {
            throw e;
        }

        return usuario;
    }

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuarioService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuarioService.findPageUsuario(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberUsuario() throws Exception {
        return usuarioService.findTotalNumberUsuario();
    }

    public List<UsuarioDTO> getDataUsuario() throws Exception {
        return usuarioService.getDataUsuario();
    }

    public void validateUsuario(Usuario usuario) throws Exception {
        usuarioService.validateUsuario(usuario);
    }

    public List<TipoNotificacion> getTipoNotificacion()
        throws Exception {
        return tipoNotificacionService.getTipoNotificacion();
    }

    public void saveTipoNotificacion(TipoNotificacion entity)
        throws Exception {
        tipoNotificacionService.saveTipoNotificacion(entity);
    }

    public void deleteTipoNotificacion(TipoNotificacion entity)
        throws Exception {
        tipoNotificacionService.deleteTipoNotificacion(entity);
    }

    public void updateTipoNotificacion(TipoNotificacion entity)
        throws Exception {
        tipoNotificacionService.updateTipoNotificacion(entity);
    }

    public TipoNotificacion getTipoNotificacion(Long idTipoNotificacion)
        throws Exception {
        TipoNotificacion tipoNotificacion = null;

        try {
            tipoNotificacion = tipoNotificacionService.getTipoNotificacion(idTipoNotificacion);
        } catch (Exception e) {
            throw e;
        }

        return tipoNotificacion;
    }

    public List<TipoNotificacion> findByCriteriaInTipoNotificacion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoNotificacionService.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<TipoNotificacion> findPageTipoNotificacion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tipoNotificacionService.findPageTipoNotificacion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoNotificacion() throws Exception {
        return tipoNotificacionService.findTotalNumberTipoNotificacion();
    }

    public List<TipoNotificacionDTO> getDataTipoNotificacion()
        throws Exception {
        return tipoNotificacionService.getDataTipoNotificacion();
    }

    public void validateTipoNotificacion(TipoNotificacion tipoNotificacion)
        throws Exception {
        tipoNotificacionService.validateTipoNotificacion(tipoNotificacion);
    }

    public List<Documento> getDocumento() throws Exception {
        return documentoService.getDocumento();
    }

    public void saveDocumento(Documento entity) throws Exception {
        documentoService.saveDocumento(entity);
    }

    public void deleteDocumento(Documento entity) throws Exception {
        documentoService.deleteDocumento(entity);
    }

    public void updateDocumento(Documento entity) throws Exception {
        documentoService.updateDocumento(entity);
    }

    public Documento getDocumento(Long idDocumento) throws Exception {
        Documento documento = null;

        try {
            documento = documentoService.getDocumento(idDocumento);
        } catch (Exception e) {
            throw e;
        }

        return documento;
    }

    public List<Documento> findByCriteriaInDocumento(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return documentoService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Documento> findPageDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return documentoService.findPageDocumento(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberDocumento() throws Exception {
        return documentoService.findTotalNumberDocumento();
    }

    public List<DocumentoDTO> getDataDocumento() throws Exception {
        return documentoService.getDataDocumento();
    }

    public void validateDocumento(Documento documento)
        throws Exception {
        documentoService.validateDocumento(documento);
    }

    public List<TipoDocumento> getTipoDocumento() throws Exception {
        return tipoDocumentoService.getTipoDocumento();
    }

    public void saveTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoService.saveTipoDocumento(entity);
    }

    public void deleteTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoService.deleteTipoDocumento(entity);
    }

    public void updateTipoDocumento(TipoDocumento entity)
        throws Exception {
        tipoDocumentoService.updateTipoDocumento(entity);
    }

    public TipoDocumento getTipoDocumento(Long idTipoDocumento)
        throws Exception {
        TipoDocumento tipoDocumento = null;

        try {
            tipoDocumento = tipoDocumentoService.getTipoDocumento(idTipoDocumento);
        } catch (Exception e) {
            throw e;
        }

        return tipoDocumento;
    }

    public List<TipoDocumento> findByCriteriaInTipoDocumento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoDocumentoService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoDocumentoService.findPageTipoDocumento(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoDocumento() throws Exception {
        return tipoDocumentoService.findTotalNumberTipoDocumento();
    }

    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception {
        return tipoDocumentoService.getDataTipoDocumento();
    }

    public void validateTipoDocumento(TipoDocumento tipoDocumento)
        throws Exception {
        tipoDocumentoService.validateTipoDocumento(tipoDocumento);
    }

    public List<Trofeo> getTrofeo() throws Exception {
        return trofeoService.getTrofeo();
    }

    public void saveTrofeo(Trofeo entity) throws Exception {
        trofeoService.saveTrofeo(entity);
    }

    public void deleteTrofeo(Trofeo entity) throws Exception {
        trofeoService.deleteTrofeo(entity);
    }

    public void updateTrofeo(Trofeo entity) throws Exception {
        trofeoService.updateTrofeo(entity);
    }

    public Trofeo getTrofeo(Long idTrofeo) throws Exception {
        Trofeo trofeo = null;

        try {
            trofeo = trofeoService.getTrofeo(idTrofeo);
        } catch (Exception e) {
            throw e;
        }

        return trofeo;
    }

    public List<Trofeo> findByCriteriaInTrofeo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return trofeoService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Trofeo> findPageTrofeo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return trofeoService.findPageTrofeo(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberTrofeo() throws Exception {
        return trofeoService.findTotalNumberTrofeo();
    }

    public List<TrofeoDTO> getDataTrofeo() throws Exception {
        return trofeoService.getDataTrofeo();
    }

    public void validateTrofeo(Trofeo trofeo) throws Exception {
        trofeoService.validateTrofeo(trofeo);
    }

    public List<Categoria> getCategoria() throws Exception {
        return categoriaService.getCategoria();
    }

    public void saveCategoria(Categoria entity) throws Exception {
        categoriaService.saveCategoria(entity);
    }

    public void deleteCategoria(Categoria entity) throws Exception {
        categoriaService.deleteCategoria(entity);
    }

    public void updateCategoria(Categoria entity) throws Exception {
        categoriaService.updateCategoria(entity);
    }

    public Categoria getCategoria(Long idCategoria) throws Exception {
        Categoria categoria = null;

        try {
            categoria = categoriaService.getCategoria(idCategoria);
        } catch (Exception e) {
            throw e;
        }

        return categoria;
    }

    public List<Categoria> findByCriteriaInCategoria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return categoriaService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Categoria> findPageCategoria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return categoriaService.findPageCategoria(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberCategoria() throws Exception {
        return categoriaService.findTotalNumberCategoria();
    }

    public List<CategoriaDTO> getDataCategoria() throws Exception {
        return categoriaService.getDataCategoria();
    }

    public void validateCategoria(Categoria categoria)
        throws Exception {
        categoriaService.validateCategoria(categoria);
    }

    public List<Calificacion> getCalificacion() throws Exception {
        return calificacionService.getCalificacion();
    }

    public void saveCalificacion(Calificacion entity) throws Exception {
        calificacionService.saveCalificacion(entity);
    }

    public void deleteCalificacion(Calificacion entity)
        throws Exception {
        calificacionService.deleteCalificacion(entity);
    }

    public void updateCalificacion(Calificacion entity)
        throws Exception {
        calificacionService.updateCalificacion(entity);
    }

    public Calificacion getCalificacion(Long idCalificacion)
        throws Exception {
        Calificacion calificacion = null;

        try {
            calificacion = calificacionService.getCalificacion(idCalificacion);
        } catch (Exception e) {
            throw e;
        }

        return calificacion;
    }

    public List<Calificacion> findByCriteriaInCalificacion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return calificacionService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Calificacion> findPageCalificacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return calificacionService.findPageCalificacion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberCalificacion() throws Exception {
        return calificacionService.findTotalNumberCalificacion();
    }

    public List<CalificacionDTO> getDataCalificacion()
        throws Exception {
        return calificacionService.getDataCalificacion();
    }

    public void validateCalificacion(Calificacion calificacion)
        throws Exception {
        calificacionService.validateCalificacion(calificacion);
    }

    public List<Area> getArea() throws Exception {
        return areaService.getArea();
    }

    public void saveArea(Area entity) throws Exception {
        areaService.saveArea(entity);
    }

    public void deleteArea(Area entity) throws Exception {
        areaService.deleteArea(entity);
    }

    public void updateArea(Area entity) throws Exception {
        areaService.updateArea(entity);
    }

    public Area getArea(Long idArea) throws Exception {
        Area area = null;

        try {
            area = areaService.getArea(idArea);
        } catch (Exception e) {
            throw e;
        }

        return area;
    }

    public List<Area> findByCriteriaInArea(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return areaService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Area> findPageArea(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return areaService.findPageArea(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberArea() throws Exception {
        return areaService.findTotalNumberArea();
    }

    public List<AreaDTO> getDataArea() throws Exception {
        return areaService.getDataArea();
    }

    public void validateArea(Area area) throws Exception {
        areaService.validateArea(area);
    }

    public List<RecompensaUsuario> getRecompensaUsuario()
        throws Exception {
        return recompensaUsuarioService.getRecompensaUsuario();
    }

    public void saveRecompensaUsuario(RecompensaUsuario entity)
        throws Exception {
        recompensaUsuarioService.saveRecompensaUsuario(entity);
    }

    public void deleteRecompensaUsuario(RecompensaUsuario entity)
        throws Exception {
        recompensaUsuarioService.deleteRecompensaUsuario(entity);
    }

    public void updateRecompensaUsuario(RecompensaUsuario entity)
        throws Exception {
        recompensaUsuarioService.updateRecompensaUsuario(entity);
    }

    public RecompensaUsuario getRecompensaUsuario(Long idRecompensaUsuario)
        throws Exception {
        RecompensaUsuario recompensaUsuario = null;

        try {
            recompensaUsuario = recompensaUsuarioService.getRecompensaUsuario(idRecompensaUsuario);
        } catch (Exception e) {
            throw e;
        }

        return recompensaUsuario;
    }

    public List<RecompensaUsuario> findByCriteriaInRecompensaUsuario(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return recompensaUsuarioService.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<RecompensaUsuario> findPageRecompensaUsuario(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return recompensaUsuarioService.findPageRecompensaUsuario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberRecompensaUsuario() throws Exception {
        return recompensaUsuarioService.findTotalNumberRecompensaUsuario();
    }

    public List<RecompensaUsuarioDTO> getDataRecompensaUsuario()
        throws Exception {
        return recompensaUsuarioService.getDataRecompensaUsuario();
    }

    public void validateRecompensaUsuario(RecompensaUsuario recompensaUsuario)
        throws Exception {
        recompensaUsuarioService.validateRecompensaUsuario(recompensaUsuario);
    }

    public List<Comentario> getComentario() throws Exception {
        return comentarioService.getComentario();
    }

    public void saveComentario(Comentario entity) throws Exception {
        comentarioService.saveComentario(entity);
    }

    public void deleteComentario(Comentario entity) throws Exception {
        comentarioService.deleteComentario(entity);
    }

    public void updateComentario(Comentario entity) throws Exception {
        comentarioService.updateComentario(entity);
    }

    public Comentario getComentario(Long idComentario)
        throws Exception {
        Comentario comentario = null;

        try {
            comentario = comentarioService.getComentario(idComentario);
        } catch (Exception e) {
            throw e;
        }

        return comentario;
    }

    public List<Comentario> findByCriteriaInComentario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return comentarioService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Comentario> findPageComentario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return comentarioService.findPageComentario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberComentario() throws Exception {
        return comentarioService.findTotalNumberComentario();
    }

    public List<ComentarioDTO> getDataComentario() throws Exception {
        return comentarioService.getDataComentario();
    }

    public void validateComentario(Comentario comentario)
        throws Exception {
        comentarioService.validateComentario(comentario);
    }

    public List<TipoPuntos> getTipoPuntos() throws Exception {
        return tipoPuntosService.getTipoPuntos();
    }

    public void saveTipoPuntos(TipoPuntos entity) throws Exception {
        tipoPuntosService.saveTipoPuntos(entity);
    }

    public void deleteTipoPuntos(TipoPuntos entity) throws Exception {
        tipoPuntosService.deleteTipoPuntos(entity);
    }

    public void updateTipoPuntos(TipoPuntos entity) throws Exception {
        tipoPuntosService.updateTipoPuntos(entity);
    }

    public TipoPuntos getTipoPuntos(Long idTipoPuntos)
        throws Exception {
        TipoPuntos tipoPuntos = null;

        try {
            tipoPuntos = tipoPuntosService.getTipoPuntos(idTipoPuntos);
        } catch (Exception e) {
            throw e;
        }

        return tipoPuntos;
    }

    public List<TipoPuntos> findByCriteriaInTipoPuntos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoPuntosService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoPuntos> findPageTipoPuntos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoPuntosService.findPageTipoPuntos(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoPuntos() throws Exception {
        return tipoPuntosService.findTotalNumberTipoPuntos();
    }

    public List<TipoPuntosDTO> getDataTipoPuntos() throws Exception {
        return tipoPuntosService.getDataTipoPuntos();
    }

    public void validateTipoPuntos(TipoPuntos tipoPuntos)
        throws Exception {
        tipoPuntosService.validateTipoPuntos(tipoPuntos);
    }

    public List<Puntos> getPuntos() throws Exception {
        return puntosService.getPuntos();
    }

    public void savePuntos(Puntos entity) throws Exception {
        puntosService.savePuntos(entity);
    }

    public void deletePuntos(Puntos entity) throws Exception {
        puntosService.deletePuntos(entity);
    }

    public void updatePuntos(Puntos entity) throws Exception {
        puntosService.updatePuntos(entity);
    }

    public Puntos getPuntos(Long idPuntos) throws Exception {
        Puntos puntos = null;

        try {
            puntos = puntosService.getPuntos(idPuntos);
        } catch (Exception e) {
            throw e;
        }

        return puntos;
    }

    public List<Puntos> findByCriteriaInPuntos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return puntosService.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Puntos> findPagePuntos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return puntosService.findPagePuntos(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberPuntos() throws Exception {
        return puntosService.findTotalNumberPuntos();
    }

    public List<PuntosDTO> getDataPuntos() throws Exception {
        return puntosService.getDataPuntos();
    }

    public void validatePuntos(Puntos puntos) throws Exception {
        puntosService.validatePuntos(puntos);
    }

	@Override
	public void saveCapsula(Capsula entity, List<FilesDocumento> documentos, List<String> palabras) throws Exception {
		capsulaService.saveCapsula(entity, documentos, palabras);
		
	}

	@Override
	public void updateCapsula(Capsula entity, List<FilesDocumento> documentos, List<String> palabras) throws Exception {
		capsulaService.updateCapsula(entity, documentos, palabras);
		
	}

	@Override
	public InputStream generarFiles(Long idDocumento) throws Exception {
		return documentoService.generarFiles(idDocumento);
	}

	@Override
	public void validarCapsula(Capsula entity,Usuario usuario,boolean pasa)throws Exception{
		capsulaService.validarCapsula(entity, usuario, pasa);		
	}

	@Override
	public InputStream generarRecompensa(Long idRecompensa) throws Exception {
		return recompensaService.generarRecompensa(idRecompensa);
	}

	@Override
	public InputStream generarTrofeo(Long idTrofeo) throws Exception {
		return trofeoService.generarTrofeo(idTrofeo);
	}

	@Override
	public void reclamarRecompensa(Recompensa entity, Usuario usuario) throws Exception {
		recompensaService.reclamarRecompensa(entity, usuario);
		
	}

	@Override
	public List<RankDTO> rankPuntos(long idTipoPuntos) throws Exception {
		return capsulaService.rankPuntos(idTipoPuntos);
	}

	@Override
	public List<RankDTO> rankCapsulas() throws Exception {
		return capsulaService.rankCapsulas();
	}

	@Override
	public List<RankDTO> rankComentarios() throws Exception {
		return capsulaService.rankComentarios();
	}
}
