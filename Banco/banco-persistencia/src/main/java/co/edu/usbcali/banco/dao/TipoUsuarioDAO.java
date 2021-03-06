package co.edu.usbcali.banco.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.banco.modelo.TipoDocumento;
import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Usuario;

@Repository
@Scope("singleton")

public class TipoUsuarioDAO implements ITipoUsuarioDAO{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void create(TipoUsuario tipoUsuario) {
		entityManager.persist(tipoUsuario);	
		
	}

	@Override
	public void update(TipoUsuario tipoUsuario) {
		entityManager.merge(tipoUsuario);
		
	}

	@Override
	public void delete(TipoUsuario tipoUsuario) {
		entityManager.remove(tipoUsuario);
		
	}

	@Override
	public void delete(long id) {
		entityManager.remove(find(id));
		
	}

	@Override
	public TipoUsuario find(long id) {
		return entityManager.find(TipoUsuario.class,id);
	}

	@Override
	public List<TipoUsuario> findAll() {
		final String  jpql = "SELECT tip FROM TipoUsuario tip";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public TipoUsuario findName(String nombre) {
		String jpql = "SELECT tip from TipoUsuario tip where tip.nombre=:nombre";
		return (TipoUsuario)entityManager.createQuery(jpql).setParameter("nombre",nombre).getSingleResult();
	}
}
