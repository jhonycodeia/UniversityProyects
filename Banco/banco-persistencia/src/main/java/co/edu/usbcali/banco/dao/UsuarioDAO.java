package co.edu.usbcali.banco.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.banco.modelo.Transaccion;
import co.edu.usbcali.banco.modelo.Usuario;

@Repository
@Scope("singleton")

public class UsuarioDAO implements IUsuarioDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void create(Usuario usuario) {
		entityManager.persist(usuario);		
		
	}

	@Override
	public void update(Usuario usuario) {
		entityManager.merge(usuario);
		
	}

	@Override
	public void delete(Usuario usuario) {
		entityManager.remove(usuario);
		
	}

	@Override
	public void delete(String id) {
		entityManager.remove(find(id));
		
	}

	@Override
	public Usuario find(String id) {
		Usuario usuario=entityManager.find(Usuario.class,id);
		if(usuario!=null)
			Hibernate.initialize(usuario.getTipoUsuario());
		return usuario;
	}

	@Override
	public List<Usuario> findAll() {
		final String  jpql = "SELECT usu FROM Usuario usu";
		List<Usuario> losUsuarios = entityManager.createQuery(jpql).getResultList();
		if (losUsuarios != null) {
			for (Usuario usuario : losUsuarios) {
				Hibernate.initialize(usuario.getTipoUsuario());
			}
		}
		return losUsuarios;
	}
}
