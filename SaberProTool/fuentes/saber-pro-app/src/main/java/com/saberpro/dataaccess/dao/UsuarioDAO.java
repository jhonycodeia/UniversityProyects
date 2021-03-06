package com.saberpro.dataaccess.dao;

import com.saberpro.dataaccess.api.DaoException;
import com.saberpro.dataaccess.api.JpaDaoImpl;

import com.saberpro.modelo.Usuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Usuario entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Usuario
 */
@Scope("singleton")
@Repository("UsuarioDAO")
public class UsuarioDAO extends JpaDaoImpl<Usuario, Long> implements IUsuarioDAO {
    private static final Logger log = LoggerFactory.getLogger(UsuarioDAO.class);
    @PersistenceContext
    private EntityManager entityManager;
    
    

    public static IUsuarioDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IUsuarioDAO) ctx.getBean("UsuarioDAO");
    }

	@Override
	public Usuario findByCodigo(long codigo) {
		return (Usuario)entityManager.createQuery("SELECT usu FROM Usuario usu WHERE usu.codigo=:codigo").setParameter("codigo",codigo).getSingleResult();	
		
	}
	
	@Override
	public Usuario findByEmail(String email) {
		return (Usuario)entityManager.createQuery("SELECT usu FROM Usuario usu WHERE usu.correo=:email").setParameter("email",email.toLowerCase()).getSingleResult();
		
	}	

	@Override
	public List<Usuario> findByTipoUsuarioPrograma(long idPrograma, long idTipoUsuario) {
		String sql="SELECT usu "
				+ "FROM Usuario usu,ProgramaUsuario pro "
				+ "WHERE usu.idUsuario=pro.usuario.idUsuario AND "
				+ "		 usu.tipoUsuario.idTipoUsuario=:idTipoUsuario AND "
				+ "		 pro.programa.idPrograma=:idPrograma";
		return entityManager.createQuery(sql).setParameter("idPrograma",idPrograma).setParameter("idTipoUsuario",idTipoUsuario).getResultList();
	}

	@Override
	public List<Usuario> findByTipoUsuarioFacultad(long idFacultad, long idTipoUsuario) {
		String sql="SELECT usu "
				+ "FROM Usuario usu,ProgramaUsuario pro,Facultad fac,Programa prog "
				+ "WHERE usu.idUsuario=pro.usuario.idUsuario AND "
				+ "		 usu.tipoUsuario.idTipoUsuario=:idTipoUsuario AND "
				+ "		 pro.programa.idPrograma=prog.idPrograma  AND "
				+ "		 prog.facultad.idFacultad=fac.idFacultad AND  "
				+ "		 fac.idFacultad=:idFacultad";
		return entityManager.createQuery(sql).setParameter("idFacultad",idFacultad).setParameter("idTipoUsuario",idTipoUsuario).getResultList();
	}

	@Override
	public List<Usuario> findByUsuarioInPrueba(long idPrueba) {
		String sql = "SELECT usu " + 
				"FROM " + 
				"  Prueba pru," + 
				"  PruebaProgramaUsuario ppu," + 
				"  ProgramaUsuario pu," + 
				"  Usuario usu" + 
				" WHERE \n" + 
				"  pru.idPrueba=ppu.prueba.idPrueba AND" + 
				"  ppu.programaUsuario.idProgramaUsuario = pu.idProgramaUsuario AND" + 
				"  pu.usuario.idUsuario = usu.idUsuario AND "+
				"  pru.idPrueba=:idPrueba " + 
				"";
		return entityManager.createQuery(sql).setParameter("idPrueba",idPrueba).getResultList();
	}	
	
	@Override
	public List<Usuario> findByUsuarioInPruebaActivo(long idPrueba) {
		String sql = "SELECT usu " + 
				"FROM " + 
				"  Prueba pru," + 
				"  PruebaProgramaUsuario ppu," + 
				"  ProgramaUsuario pu," + 
				"  Usuario usu" + 
				" WHERE \n" + 
				"  pru.idPrueba=ppu.prueba.idPrueba AND" + 
				"  ppu.programaUsuario.idProgramaUsuario = pu.idProgramaUsuario AND" + 
				"  pu.usuario.idUsuario = usu.idUsuario AND "+
				"  pru.idPrueba=:idPrueba AND ppu.activo='S'" + 
				"";
		return entityManager.createQuery(sql).setParameter("idPrueba",idPrueba).getResultList();
	}	
	
	
    
}
