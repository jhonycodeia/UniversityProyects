package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.JpaDaoImpl;

import com.saberpro.modelo.RespuestaPruebaProgramaUsuarioPregunta;

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
 * RespuestaPruebaProgramaUsuarioPregunta entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.RespuestaPruebaProgramaUsuarioPregunta
 */
@Scope("singleton")
@Repository("RespuestaPruebaProgramaUsuarioPreguntaDAO")
public class RespuestaPruebaProgramaUsuarioPreguntaDAO extends JpaDaoImpl<RespuestaPruebaProgramaUsuarioPregunta, Long>
    implements IRespuestaPruebaProgramaUsuarioPreguntaDAO {
    private static final Logger log = LoggerFactory.getLogger(RespuestaPruebaProgramaUsuarioPreguntaDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IRespuestaPruebaProgramaUsuarioPreguntaDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IRespuestaPruebaProgramaUsuarioPreguntaDAO) ctx.getBean(
            "RespuestaPruebaProgramaUsuarioPreguntaDAO");
    }

	@Override
	public List<RespuestaPruebaProgramaUsuarioPregunta> findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuario(
			long idPruebaProgramaUsuario) {
		String sql ="SELECT rpu From RespuestaPruebaProgramaUsuarioPregunta rpu,"
				+ " PruebaProgramaUsuarioPregunta ppu, PruebaProgramaUsuario ppe "
				+ "where rpu.pruebaProgramaUsuarioPregunta.idPruebaProgramaUsuarioPregunta=ppu.idPruebaProgramaUsuarioPregunta and "
				+ "ppu.pruebaProgramaUsuario.idPruebaProgramaUsuario=ppe.idPruebaProgramaUsuario "
				+ "and ppe.idPruebaProgramaUsuario=:idPruebaProgramaUsuario and ppe.activo='S'";
		return entityManager.createQuery(sql).setParameter("idPruebaProgramaUsuario",idPruebaProgramaUsuario).getResultList();
	}
	
	@Override
	public List<RespuestaPruebaProgramaUsuarioPregunta> findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuarioPregunta(
			long idPruebaProgramaUsuarioPregunta) {
		String sql ="SELECT rpu From RespuestaPruebaProgramaUsuarioPregunta rpu,"
				+ " PruebaProgramaUsuarioPregunta ppu, PruebaProgramaUsuario ppe "
				+ "where rpu.pruebaProgramaUsuarioPregunta.idPruebaProgramaUsuarioPregunta=ppu.idPruebaProgramaUsuarioPregunta and "
				+ "ppu.pruebaProgramaUsuario.idPruebaProgramaUsuario=ppe.idPruebaProgramaUsuario "
				+ "and ppu.idPruebaProgramaUsuarioPregunta=:idPruebaProgramaUsuarioPregunta and ppu.activo='S'";
		return entityManager.createQuery(sql).setParameter("idPruebaProgramaUsuario",idPruebaProgramaUsuarioPregunta).getResultList();
	}
}
