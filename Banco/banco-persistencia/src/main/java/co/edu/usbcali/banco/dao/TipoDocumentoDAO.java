package co.edu.usbcali.banco.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.TipoDocumento;




@Repository
@Scope("singleton")

public class TipoDocumentoDAO implements ITipoDocumentoDAO{

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void create(TipoDocumento tipoDocumento) {
		entityManager.persist(tipoDocumento);			
	}

	@Override
	public void update(TipoDocumento tipoDocumento) {
		entityManager.merge(tipoDocumento);		
	}

	@Override
	public void delete(TipoDocumento tipoDocumento) {
		entityManager.remove(tipoDocumento);		
	}

	@Override
	public void delete(long id) {
		entityManager.remove(find(id));
		
	}

	@Override
	public TipoDocumento find(long id) {
		return entityManager.find(TipoDocumento.class,id);
	}

	@Override
	public List<co.edu.usbcali.banco.modelo.TipoDocumento> findAll() {
		final String  jpql = "SELECT tip FROM TipoDocumento tip";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public TipoDocumento findName(String nombre) {
		String jpql = "SELECT tip from TipoDocumento tip where tip.nombre=:nombre";
		return (TipoDocumento)entityManager.createQuery(jpql).setParameter("nombre",nombre).getSingleResult();
	}

}
