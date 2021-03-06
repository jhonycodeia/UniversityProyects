package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.DaoException;
import com.saberpro.dataaccess.api.JpaDaoImpl;

import com.saberpro.modelo.Opcion;

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
 * Opcion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Opcion
 */
@Scope("singleton")
@Repository("OpcionDAO")
public class OpcionDAO extends JpaDaoImpl<Opcion, Long> implements IOpcionDAO {
    private static final Logger log = LoggerFactory.getLogger(OpcionDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IOpcionDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IOpcionDAO) ctx.getBean("OpcionDAO");
    }

	@Override
	public List<Opcion> findByGrupo(long grupo) throws DaoException {
		return entityManager.createQuery("select opc from GrupoOpcion gru,Opcion opc where gru.idGrupoOpcion=opc.grupoOpcion.idGrupoOpcion and opc.grupoOpcion.idGrupoOpcion=:grupo order by opc.nombre").setParameter("grupo",grupo).getResultList();
	}
	
	@Override
	public List<Opcion> findByGrupo(long grupo,String activo) throws DaoException {
		return entityManager.createQuery("select opc from GrupoOpcion gru,Opcion opc where gru.idGrupoOpcion=opc.grupoOpcion.idGrupoOpcion and opc.grupoOpcion.idGrupoOpcion=:grupo and opc.activo=:activo order by opc.nombre").setParameter("grupo",grupo).setParameter("activo",activo).getResultList();
	}
}
