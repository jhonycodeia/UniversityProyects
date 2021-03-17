package co.edu.usbcali.arquitectura.dataaccess.dao;

import co.edu.usbcali.arquitectura.dataaccess.api.DaoException;
import co.edu.usbcali.arquitectura.dataaccess.api.JpaDaoImpl;
import co.edu.usbcali.arquitectura.modelo.Saludo;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoNombreDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * A data access object (DAO) providing persistence and search support for
 * Saludo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Saludo
 */
@Scope("singleton")
@Repository("SaludoDAO")
public class SaludoDAO extends JpaDaoImpl<Saludo, Integer> implements ISaludoDAO {
    private static final Logger log = LoggerFactory.getLogger(SaludoDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ISaludoDAO getFromApplicationContext(ApplicationContext ctx) {
        return (ISaludoDAO) ctx.getBean("SaludoDAO");
    }
    
    public SaludoNombreDTO SaludoNombre(String nombre) throws DaoException {
        String queryString = "SELECT new co.edu.usbcali.arquitectura.modelo.dto.SaludoNombreDTO(nom.nombre,sal.saludo)" + 
        		" FROM \r\n" + 
        		"  Idioma idi," + 
        		"  Nombre nom," + 
        		"  Saludo sal" + 
        		" WHERE \r\n" + 
        		"  idi.idIdioma = sal.idioma.idIdioma AND" + 
        		"  sal.idioma.idIdioma = nom.idioma.idIdioma AND" + 
        		"  nom.nombre = :nombre";
        return (SaludoNombreDTO) entityManager.createQuery(queryString).setParameter("nombre",nombre).getSingleResult();
    }

}
