package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.JpaDaoImpl;
import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.TipoModulo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * TipoModulo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.TipoModulo
 */
@Scope("singleton")
@Repository("TipoModuloDAO")
public class TipoModuloDAO extends JpaDaoImpl<TipoModulo, Long>
    implements ITipoModuloDAO {
    private static final Logger log = LoggerFactory.getLogger(TipoModuloDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ITipoModuloDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ITipoModuloDAO) ctx.getBean("TipoModuloDAO");
    }

	@Override
	public TipoModulo findByNombre(String nombre) {
		return (TipoModulo)entityManager.createQuery("SELECT tip FROM TipoModulo tip WHERE UPPER(sinacentos(tip.nombre))=UPPER(sinacentos(:nombre))").setParameter("nombre",nombre).getSingleResult();
	}
}
