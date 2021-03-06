package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.JpaDaoImpl;
import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.Programa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Programa entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Programa
 */
@Scope("singleton")
@Repository("ProgramaDAO")
public class ProgramaDAO extends JpaDaoImpl<Programa, Long>
    implements IProgramaDAO {
    private static final Logger log = LoggerFactory.getLogger(ProgramaDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IProgramaDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IProgramaDAO) ctx.getBean("ProgramaDAO");
    }

	@Override
	public Programa findByNombre(String nombre) {
		return (Programa)entityManager.createQuery("SELECT pro FROM Programa pro WHERE UPPER(sinacentos(pro.nombre))=UPPER(sinacentos(:nombre))").setParameter("nombre",nombre).getSingleResult();
	}
}
