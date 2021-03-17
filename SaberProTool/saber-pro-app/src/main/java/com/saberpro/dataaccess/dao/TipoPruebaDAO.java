package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.JpaDaoImpl;
import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.TipoPrueba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * TipoPrueba entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.TipoPrueba
 */
@Scope("singleton")
@Repository("TipoPruebaDAO")
public class TipoPruebaDAO extends JpaDaoImpl<TipoPrueba, Long>
    implements ITipoPruebaDAO {
    private static final Logger log = LoggerFactory.getLogger(TipoPruebaDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ITipoPruebaDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ITipoPruebaDAO) ctx.getBean("TipoPruebaDAO");
    }

	@Override
	public TipoPrueba findByNombre(String nombre) {
		return (TipoPrueba)entityManager.createQuery("SELECT tip FROM TipoPrueba tip WHERE UPPER(sinacentos(tip.nombre))=UPPER(sinacentos(:nombre))").setParameter("nombre",nombre).getSingleResult();
	}
}
