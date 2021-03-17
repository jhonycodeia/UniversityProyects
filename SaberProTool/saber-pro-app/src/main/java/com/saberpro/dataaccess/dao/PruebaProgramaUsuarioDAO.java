package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.JpaDaoImpl;

import com.saberpro.modelo.PruebaProgramaUsuario;
import com.saberpro.modelo.dto.ResultadosModuloDTO;

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
 * PruebaProgramaUsuario entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.PruebaProgramaUsuario
 */
@Scope("singleton")
@Repository("PruebaProgramaUsuarioDAO")
public class PruebaProgramaUsuarioDAO extends JpaDaoImpl<PruebaProgramaUsuario, Long>
    implements IPruebaProgramaUsuarioDAO {
    private static final Logger log = LoggerFactory.getLogger(PruebaProgramaUsuarioDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IPruebaProgramaUsuarioDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IPruebaProgramaUsuarioDAO) ctx.getBean(
            "PruebaProgramaUsuarioDAO");
    }

	@Override
	public List<ResultadosModuloDTO> findResultado(long idProgramaUsuario, long idPruebaProgramaUsuario) {
		String sql ="SELECT new com.saberpro.modelo.dto.ResultadosModuloDTO(mod.nombre,(count(*)-(sum(rppup.porcentajeAsignado)/100)),(sum(rppup.porcentajeAsignado)/100),(count(*)),(avg(rppup.porcentajeAsignado)*300/100)) "
				+ " FROM PruebaProgramaUsuario ppu,"
				+ "		RespuestaPruebaProgramaUsuarioPregunta rppup,"
				+ "		PruebaProgramaUsuarioPregunta ppup,"
				+ "		ProgramaUsuario pu,"
				+ "		Prueba pru,"
				+ "		Pregunta pre,"
				+ "		Modulo mod "
				+ "WHERE ppu.idPruebaProgramaUsuario=ppup.pruebaProgramaUsuario.idPruebaProgramaUsuario AND"
				+ "		 ppu.prueba.idPrueba=pru.idPrueba AND "
				+ "		 ppup.idPruebaProgramaUsuarioPregunta=rppup.pruebaProgramaUsuarioPregunta.idPruebaProgramaUsuarioPregunta AND "
				+ "		 ppup.pregunta.idPregunta=pre.idPregunta AND "
				+ "		 pu.idProgramaUsuario=ppu.programaUsuario.idProgramaUsuario AND "
				+ "		 pre.modulo.idModulo=mod.idModulo AND "
				+ "		 ppu.idPruebaProgramaUsuario=:idPruebaProgramaUsuario AND "
				+ "		 pu.idProgramaUsuario=:idProgramaUsuario"
				+ " GROUP BY mod.idModulo";
		
		return entityManager.createQuery(sql).setParameter("idPruebaProgramaUsuario",idPruebaProgramaUsuario).setParameter("idProgramaUsuario",idProgramaUsuario).getResultList();
		
		
	}
}
