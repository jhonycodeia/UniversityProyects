package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.JpaDaoImpl;

import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.Usuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Facultad entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Facultad
 */
@Scope("singleton")
@Repository("FacultadDAO")
public class FacultadDAO extends JpaDaoImpl<Facultad, Long>
    implements IFacultadDAO {
    private static final Logger log = LoggerFactory.getLogger(FacultadDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IFacultadDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IFacultadDAO) ctx.getBean("FacultadDAO");
    }

	@Override
	public Facultad findByNombre(String nombre) {
		return (Facultad)entityManager.createQuery("SELECT fac FROM Facultad fac WHERE UPPER(sinacentos(fac.nombre))=UPPER(sinacentos(:nombre))").setParameter("nombre",nombre).getSingleResult();
	}
}
