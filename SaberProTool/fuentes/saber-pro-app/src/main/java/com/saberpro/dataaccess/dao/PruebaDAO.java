package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.JpaDaoImpl;

import com.saberpro.modelo.Prueba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Prueba entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Prueba
 */
@Scope("singleton")
@Repository("PruebaDAO")
public class PruebaDAO extends JpaDaoImpl<Prueba, Long> implements IPruebaDAO {
    private static final Logger log = LoggerFactory.getLogger(PruebaDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IPruebaDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IPruebaDAO) ctx.getBean("PruebaDAO");
    }
}
