package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.JpaDaoImpl;

import com.saberpro.modelo.EstadoPrueba;
import com.saberpro.modelo.Facultad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * EstadoPrueba entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.EstadoPrueba
 */
@Scope("singleton")
@Repository("EstadoPruebaDAO")
public class EstadoPruebaDAO extends JpaDaoImpl<EstadoPrueba, Long>
    implements IEstadoPruebaDAO {
    private static final Logger log = LoggerFactory.getLogger(EstadoPruebaDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IEstadoPruebaDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IEstadoPruebaDAO) ctx.getBean("EstadoPruebaDAO");
    }

	@Override
	public EstadoPrueba findByNombre(String nombre) {
		return (EstadoPrueba)entityManager.createQuery("SELECT est FROM EstadoPrueba est WHERE UPPER(sinacentos(est.nombre))=UPPER(sinacentos(:nombre))").setParameter("nombre",nombre).getSingleResult();
	}
}
