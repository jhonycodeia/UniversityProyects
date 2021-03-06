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
import com.green.utility.FilesDocumento;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface BusinessDelegator {
    public List<Proceso> getProceso() throws Exception;

    public void saveProceso(Proceso entity) throws Exception;

    public void deleteProceso(Proceso entity) throws Exception;

    public void updateProceso(Proceso entity) throws Exception;

    public Proceso getProceso(Long idProceso) throws Exception;

    public List<Proceso> findByCriteriaInProceso(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Proceso> findPageProceso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberProceso() throws Exception;

    public List<ProcesoDTO> getDataProceso() throws Exception;

    public void validateProceso(Proceso proceso) throws Exception;

    public List<Subproceso> getSubproceso() throws Exception;

    public void saveSubproceso(Subproceso entity) throws Exception;

    public void deleteSubproceso(Subproceso entity) throws Exception;

    public void updateSubproceso(Subproceso entity) throws Exception;

    public Subproceso getSubproceso(Long idSubproceso)
        throws Exception;

    public List<Subproceso> findByCriteriaInSubproceso(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Subproceso> findPageSubproceso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSubproceso() throws Exception;

    public List<SubprocesoDTO> getDataSubproceso() throws Exception;

    public void validateSubproceso(Subproceso subproceso)
        throws Exception;

    public List<UsuarioTrofeo> getUsuarioTrofeo() throws Exception;

    public void saveUsuarioTrofeo(UsuarioTrofeo entity)
        throws Exception;

    public void deleteUsuarioTrofeo(UsuarioTrofeo entity)
        throws Exception;

    public void updateUsuarioTrofeo(UsuarioTrofeo entity)
        throws Exception;

    public UsuarioTrofeo getUsuarioTrofeo(Long idUsuarioTrofeo)
        throws Exception;

    public List<UsuarioTrofeo> findByCriteriaInUsuarioTrofeo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<UsuarioTrofeo> findPageUsuarioTrofeo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuarioTrofeo() throws Exception;

    public List<UsuarioTrofeoDTO> getDataUsuarioTrofeo()
        throws Exception;

    public void validateUsuarioTrofeo(UsuarioTrofeo usuarioTrofeo)
        throws Exception;

    public List<Notificacion> getNotificacion() throws Exception;

    public void saveNotificacion(Notificacion entity) throws Exception;

    public void deleteNotificacion(Notificacion entity)
        throws Exception;

    public void updateNotificacion(Notificacion entity)
        throws Exception;

    public Notificacion getNotificacion(Long idNotificacion)
        throws Exception;

    public List<Notificacion> findByCriteriaInNotificacion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Notificacion> findPageNotificacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberNotificacion() throws Exception;

    public List<NotificacionDTO> getDataNotificacion()
        throws Exception;

    public void validateNotificacion(Notificacion notificacion)
        throws Exception;

    public List<CapsulaPalabrasClave> getCapsulaPalabrasClave()
        throws Exception;

    public void saveCapsulaPalabrasClave(CapsulaPalabrasClave entity)
        throws Exception;

    public void deleteCapsulaPalabrasClave(CapsulaPalabrasClave entity)
        throws Exception;

    public void updateCapsulaPalabrasClave(CapsulaPalabrasClave entity)
        throws Exception;

    public CapsulaPalabrasClave getCapsulaPalabrasClave(
        Long idCapsulaPalabraClave) throws Exception;

    public List<CapsulaPalabrasClave> findByCriteriaInCapsulaPalabrasClave(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<CapsulaPalabrasClave> findPageCapsulaPalabrasClave(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberCapsulaPalabrasClave() throws Exception;

    public List<CapsulaPalabrasClaveDTO> getDataCapsulaPalabrasClave()
        throws Exception;

    public void validateCapsulaPalabrasClave(
        CapsulaPalabrasClave capsulaPalabrasClave) throws Exception;

    public List<TipoUsuario> getTipoUsuario() throws Exception;

    public void saveTipoUsuario(TipoUsuario entity) throws Exception;

    public void deleteTipoUsuario(TipoUsuario entity) throws Exception;

    public void updateTipoUsuario(TipoUsuario entity) throws Exception;

    public TipoUsuario getTipoUsuario(Long idTipoUsuario)
        throws Exception;

    public List<TipoUsuario> findByCriteriaInTipoUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoUsuario> findPageTipoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoUsuario() throws Exception;

    public List<TipoUsuarioDTO> getDataTipoUsuario() throws Exception;

    public void validateTipoUsuario(TipoUsuario tipoUsuario)
        throws Exception;

    public List<Parametro> getParametro() throws Exception;

    public void saveParametro(Parametro entity) throws Exception;

    public void deleteParametro(Parametro entity) throws Exception;

    public void updateParametro(Parametro entity) throws Exception;

    public Parametro getParametro(Long idParametro) throws Exception;

    public List<Parametro> findByCriteriaInParametro(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Parametro> findPageParametro(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberParametro() throws Exception;

    public List<ParametroDTO> getDataParametro() throws Exception;

    public void validateParametro(Parametro parametro)
        throws Exception;

    public List<PalabrasClave> getPalabrasClave() throws Exception;

    public void savePalabrasClave(PalabrasClave entity)
        throws Exception;

    public void deletePalabrasClave(PalabrasClave entity)
        throws Exception;

    public void updatePalabrasClave(PalabrasClave entity)
        throws Exception;

    public PalabrasClave getPalabrasClave(Long idPalabraClave)
        throws Exception;

    public List<PalabrasClave> findByCriteriaInPalabrasClave(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<PalabrasClave> findPagePalabrasClave(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPalabrasClave() throws Exception;

    public List<PalabrasClaveDTO> getDataPalabrasClave()
        throws Exception;

    public void validatePalabrasClave(PalabrasClave palabrasClave)
        throws Exception;

    public List<Recompensa> getRecompensa() throws Exception;

    public void saveRecompensa(Recompensa entity) throws Exception;

    public void deleteRecompensa(Recompensa entity) throws Exception;

    public void updateRecompensa(Recompensa entity) throws Exception;

    public Recompensa getRecompensa(Long idRecompensa)
        throws Exception;

    public List<Recompensa> findByCriteriaInRecompensa(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Recompensa> findPageRecompensa(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRecompensa() throws Exception;

    public List<RecompensaDTO> getDataRecompensa() throws Exception;

    public void validateRecompensa(Recompensa recompensa)
        throws Exception;

    public List<Capsula> getCapsula() throws Exception;

    public void saveCapsula(Capsula entity) throws Exception;

    public void deleteCapsula(Capsula entity) throws Exception;

    public void updateCapsula(Capsula entity) throws Exception;

    public Capsula getCapsula(Long idCapsula) throws Exception;

    public List<Capsula> findByCriteriaInCapsula(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Capsula> findPageCapsula(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCapsula() throws Exception;

    public List<CapsulaDTO> getDataCapsula() throws Exception;

    public void validateCapsula(Capsula capsula) throws Exception;

    public List<TipoCapsula> getTipoCapsula() throws Exception;

    public void saveTipoCapsula(TipoCapsula entity) throws Exception;

    public void deleteTipoCapsula(TipoCapsula entity) throws Exception;

    public void updateTipoCapsula(TipoCapsula entity) throws Exception;

    public TipoCapsula getTipoCapsula(Long idTipoCapsula)
        throws Exception;

    public List<TipoCapsula> findByCriteriaInTipoCapsula(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoCapsula> findPageTipoCapsula(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoCapsula() throws Exception;

    public List<TipoCapsulaDTO> getDataTipoCapsula() throws Exception;

    public void validateTipoCapsula(TipoCapsula tipoCapsula)
        throws Exception;

    public List<Usuario> getUsuario() throws Exception;

    public void saveUsuario(Usuario entity) throws Exception;

    public void deleteUsuario(Usuario entity) throws Exception;

    public void updateUsuario(Usuario entity) throws Exception;

    public Usuario getUsuario(Long idUsuario) throws Exception;

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuario() throws Exception;

    public List<UsuarioDTO> getDataUsuario() throws Exception;

    public void validateUsuario(Usuario usuario) throws Exception;

    public List<TipoNotificacion> getTipoNotificacion()
        throws Exception;

    public void saveTipoNotificacion(TipoNotificacion entity)
        throws Exception;

    public void deleteTipoNotificacion(TipoNotificacion entity)
        throws Exception;

    public void updateTipoNotificacion(TipoNotificacion entity)
        throws Exception;

    public TipoNotificacion getTipoNotificacion(Long idTipoNotificacion)
        throws Exception;

    public List<TipoNotificacion> findByCriteriaInTipoNotificacion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoNotificacion> findPageTipoNotificacion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoNotificacion() throws Exception;

    public List<TipoNotificacionDTO> getDataTipoNotificacion()
        throws Exception;

    public void validateTipoNotificacion(TipoNotificacion tipoNotificacion)
        throws Exception;

    public List<Documento> getDocumento() throws Exception;

    public void saveDocumento(Documento entity) throws Exception;

    public void deleteDocumento(Documento entity) throws Exception;

    public void updateDocumento(Documento entity) throws Exception;

    public Documento getDocumento(Long idDocumento) throws Exception;

    public List<Documento> findByCriteriaInDocumento(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Documento> findPageDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDocumento() throws Exception;

    public List<DocumentoDTO> getDataDocumento() throws Exception;

    public void validateDocumento(Documento documento)
        throws Exception;

    public List<TipoDocumento> getTipoDocumento() throws Exception;

    public void saveTipoDocumento(TipoDocumento entity)
        throws Exception;

    public void deleteTipoDocumento(TipoDocumento entity)
        throws Exception;

    public void updateTipoDocumento(TipoDocumento entity)
        throws Exception;

    public TipoDocumento getTipoDocumento(Long idTipoDocumento)
        throws Exception;

    public List<TipoDocumento> findByCriteriaInTipoDocumento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoDocumento() throws Exception;

    public List<TipoDocumentoDTO> getDataTipoDocumento()
        throws Exception;

    public void validateTipoDocumento(TipoDocumento tipoDocumento)
        throws Exception;

    public List<Trofeo> getTrofeo() throws Exception;

    public void saveTrofeo(Trofeo entity) throws Exception;

    public void deleteTrofeo(Trofeo entity) throws Exception;

    public void updateTrofeo(Trofeo entity) throws Exception;

    public Trofeo getTrofeo(Long idTrofeo) throws Exception;

    public List<Trofeo> findByCriteriaInTrofeo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Trofeo> findPageTrofeo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTrofeo() throws Exception;

    public List<TrofeoDTO> getDataTrofeo() throws Exception;

    public void validateTrofeo(Trofeo trofeo) throws Exception;

    public List<Categoria> getCategoria() throws Exception;

    public void saveCategoria(Categoria entity) throws Exception;

    public void deleteCategoria(Categoria entity) throws Exception;

    public void updateCategoria(Categoria entity) throws Exception;

    public Categoria getCategoria(Long idCategoria) throws Exception;

    public List<Categoria> findByCriteriaInCategoria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Categoria> findPageCategoria(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCategoria() throws Exception;

    public List<CategoriaDTO> getDataCategoria() throws Exception;

    public void validateCategoria(Categoria categoria)
        throws Exception;

    public List<Calificacion> getCalificacion() throws Exception;

    public void saveCalificacion(Calificacion entity) throws Exception;

    public void deleteCalificacion(Calificacion entity)
        throws Exception;

    public void updateCalificacion(Calificacion entity)
        throws Exception;

    public Calificacion getCalificacion(Long idCalificacion)
        throws Exception;

    public List<Calificacion> findByCriteriaInCalificacion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Calificacion> findPageCalificacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCalificacion() throws Exception;

    public List<CalificacionDTO> getDataCalificacion()
        throws Exception;

    public void validateCalificacion(Calificacion calificacion)
        throws Exception;

    public List<Area> getArea() throws Exception;

    public void saveArea(Area entity) throws Exception;

    public void deleteArea(Area entity) throws Exception;

    public void updateArea(Area entity) throws Exception;

    public Area getArea(Long idArea) throws Exception;

    public List<Area> findByCriteriaInArea(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Area> findPageArea(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberArea() throws Exception;

    public List<AreaDTO> getDataArea() throws Exception;

    public void validateArea(Area area) throws Exception;

    public List<RecompensaUsuario> getRecompensaUsuario()
        throws Exception;

    public void saveRecompensaUsuario(RecompensaUsuario entity)
        throws Exception;

    public void deleteRecompensaUsuario(RecompensaUsuario entity)
        throws Exception;

    public void updateRecompensaUsuario(RecompensaUsuario entity)
        throws Exception;

    public RecompensaUsuario getRecompensaUsuario(Long idRecompensaUsuario)
        throws Exception;

    public List<RecompensaUsuario> findByCriteriaInRecompensaUsuario(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<RecompensaUsuario> findPageRecompensaUsuario(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberRecompensaUsuario() throws Exception;

    public List<RecompensaUsuarioDTO> getDataRecompensaUsuario()
        throws Exception;

    public void validateRecompensaUsuario(RecompensaUsuario recompensaUsuario)
        throws Exception;

    public List<Comentario> getComentario() throws Exception;

    public void saveComentario(Comentario entity) throws Exception;

    public void deleteComentario(Comentario entity) throws Exception;

    public void updateComentario(Comentario entity) throws Exception;

    public Comentario getComentario(Long idComentario)
        throws Exception;

    public List<Comentario> findByCriteriaInComentario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Comentario> findPageComentario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberComentario() throws Exception;

    public List<ComentarioDTO> getDataComentario() throws Exception;

    public void validateComentario(Comentario comentario)
        throws Exception;

    public List<TipoPuntos> getTipoPuntos() throws Exception;

    public void saveTipoPuntos(TipoPuntos entity) throws Exception;

    public void deleteTipoPuntos(TipoPuntos entity) throws Exception;

    public void updateTipoPuntos(TipoPuntos entity) throws Exception;

    public TipoPuntos getTipoPuntos(Long idTipoPuntos)
        throws Exception;

    public List<TipoPuntos> findByCriteriaInTipoPuntos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoPuntos> findPageTipoPuntos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoPuntos() throws Exception;

    public List<TipoPuntosDTO> getDataTipoPuntos() throws Exception;

    public void validateTipoPuntos(TipoPuntos tipoPuntos)
        throws Exception;

    public List<Puntos> getPuntos() throws Exception;

    public void savePuntos(Puntos entity) throws Exception;

    public void deletePuntos(Puntos entity) throws Exception;

    public void updatePuntos(Puntos entity) throws Exception;

    public Puntos getPuntos(Long idPuntos) throws Exception;

    public List<Puntos> findByCriteriaInPuntos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Puntos> findPagePuntos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPuntos() throws Exception;

    public List<PuntosDTO> getDataPuntos() throws Exception;

    public void validatePuntos(Puntos puntos) throws Exception;
    
    public void saveCapsula(Capsula entity,List<FilesDocumento> documentos,List<String> palabras)throws Exception;
    
    public void updateCapsula(Capsula entity,List<FilesDocumento> documentos,List<String> palabras)throws Exception;
    
    public InputStream generarFiles(Long idDocumento) throws Exception;
    
    public void validarCapsula(Capsula entity,Usuario usuario,boolean pasa)throws Exception;
    
    public InputStream generarRecompensa(Long idRecompensa) throws Exception;
    
    public InputStream generarTrofeo(Long idTrofeo) throws Exception;
    
    public void reclamarRecompensa(Recompensa entity,Usuario usuario)throws Exception;
    
    public List<RankDTO> rankPuntos(long idTipoPuntos)throws Exception;
	public List<RankDTO> rankCapsulas()throws Exception;
	public List<RankDTO> rankComentarios()throws Exception;
}
