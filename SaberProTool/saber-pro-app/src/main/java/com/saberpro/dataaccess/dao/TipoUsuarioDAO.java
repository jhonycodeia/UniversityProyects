package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.JpaDaoImpl;
import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.TipoUsuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * TipoUsuario entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.TipoUsuario
 */
@Scope("singleton")
@Repository("TipoUsuarioDAO")
public class TipoUsuarioDAO extends JpaDaoImpl<TipoUsuario, Long>
    implements ITipoUsuarioDAO {
    private static final Logger log = LoggerFactory.getLogger(TipoUsuarioDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ITipoUsuarioDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ITipoUsuarioDAO) ctx.getBean("TipoUsuarioDAO");
    }

	@Override
	public TipoUsuario findByNombre(String nombre) {
		return (TipoUsuario)entityManager.createQuery("SELECT tip FROM TipoUsuario tip WHERE UPPER(sinacentos(tip.nombre))=UPPER(sinacentos(:nombre))").setParameter("nombre",nombre).getSingleResult();
	}
}
