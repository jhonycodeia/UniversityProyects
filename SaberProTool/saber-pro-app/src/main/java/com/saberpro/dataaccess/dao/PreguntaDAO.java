package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.JpaDaoImpl;

import com.saberpro.modelo.Pregunta;
import com.saberpro.modelo.dto.ResultadosPreguntaDTO;

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
 * Pregunta entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Pregunta
 */
@Scope("singleton")
@Repository("PreguntaDAO")
public class PreguntaDAO extends JpaDaoImpl<Pregunta, Long>
    implements IPreguntaDAO {
    private static final Logger log = LoggerFactory.getLogger(PreguntaDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IPreguntaDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IPreguntaDAO) ctx.getBean("PreguntaDAO");
    }

	@Override
	public List<Pregunta> findByRandom(long idModulo, long limit) {		
		return entityManager.createQuery("select pre from Pregunta pre where pre.modulo.idModulo=:idModulo order by random()").setParameter("idModulo",idModulo).setMaxResults((int) limit).getResultList();
	}

	@Override
	public List<Pregunta> findByPruebaProgramaUsuario(long idPruebaProgramaUsuario) {
		String sql="SELECT pre " + 
				" FROM " + 
				"  PruebaProgramaUsuario ppu," + 
				"  PruebaProgramaUsuarioPregunta ppup," + 
				"  Pregunta pre" + 
				" WHERE " + 
				"  ppu.idPruebaProgramaUsuario=ppup.pruebaProgramaUsuario.idPruebaProgramaUsuario AND" + 
				"  ppup.pregunta.idPregunta = pre.idPregunta AND"+
				"  ppu.idPruebaProgramaUsuario=:idPruebaProgramaUsuario";
		return entityManager.createQuery(sql).setParameter("idPruebaProgramaUsuario",idPruebaProgramaUsuario).getResultList();
	}

	@Override
	public List<ResultadosPreguntaDTO> findByTopPregunta(long idModulo) {
		String sql ="Select new com.saberpro.modelo.dto.ResultadosPreguntaDTO(pre.idPregunta," + 
				"  pre.descripcionPregunta,\n" + 
				"  count(rppup.porcentajeAsignado)) " + 
				" FROM " + 
				"  Modulo mod, " + 
				"  Pregunta pre, " + 
				"  PruebaProgramaUsuarioPregunta ppup, " + 
				"  RespuestaPruebaProgramaUsuarioPregunta rppup" + 
				" WHERE " + 
				"  pre.modulo.idModulo=mod.idModulo AND" + 
				"  ppup.pregunta.idPregunta = pre.idPregunta AND" + 
				"  ppup.idPruebaProgramaUsuarioPregunta = rppup.pruebaProgramaUsuarioPregunta.idPruebaProgramaUsuarioPregunta AND" + 
				"  rppup.porcentajeAsignado=0 AND mod.idModulo=:idModulo" + 
				"  Group by pre.idPregunta order by count(rppup.porcentajeAsignado) desc";
		return entityManager.createQuery(sql).setParameter("idModulo",idModulo).getResultList();
	}
}
