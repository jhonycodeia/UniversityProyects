package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.DaoException;
import com.saberpro.dataaccess.api.JpaDaoImpl;

import com.saberpro.modelo.GrupoOpcion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * GrupoOpcion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.GrupoOpcion
 */
@Scope("singleton")
@Repository("GrupoOpcionDAO")
public class GrupoOpcionDAO extends JpaDaoImpl<GrupoOpcion, Long>
    implements IGrupoOpcionDAO {
    private static final Logger log = LoggerFactory.getLogger(GrupoOpcionDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IGrupoOpcionDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IGrupoOpcionDAO) ctx.getBean("GrupoOpcionDAO");
    }

	@Override
	public List<GrupoOpcion> findByTipoUsuario(long tipoUsuario,String activo) throws DaoException {
		return entityManager.createQuery("select gru from GrupoOpcion gru,Permiso per where per.grupoOpcion.idGrupoOpcion=gru.idGrupoOpcion and per.tipoUsuario.idTipoUsuario=:tipoUsuario and gru.activo=:activo").setParameter("tipoUsuario",tipoUsuario).setParameter("activo",activo).getResultList();
	}
	
	@Override
	public List<GrupoOpcion> findByTipoUsuario(long tipoUsuario) throws DaoException {
		return entityManager.createQuery("select gru from GrupoOpcion gru,Permiso per where per.grupoOpcion.idGrupoOpcion=gru.idGrupoOpcion and per.tipoUsuario.idTipoUsuario=:tipoUsuario").setParameter("tipoUsuario",tipoUsuario).getResultList();
	}
}
