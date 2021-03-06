package co.edu.usbcali.banco.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.banco.modelo.TipoDocumento;
import co.edu.usbcali.banco.modelo.TipoTransaccion;

@Repository
@Scope("singleton")

public class TipoTransaccionDAO implements ITipoTransaccionDAO{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void create(TipoTransaccion tipoTransaccion) {
		entityManager.persist(tipoTransaccion);	
		
	}

	@Override
	public void update(TipoTransaccion tipoTransaccion) {
		entityManager.merge(tipoTransaccion);
		
	}

	@Override
	public void delete(TipoTransaccion tipoTransaccion) {
		entityManager.remove(tipoTransaccion);
		
	}

	@Override
	public void delete(long id) {
		entityManager.remove(find(id));
		
	}

	@Override
	public TipoTransaccion find(long id) {
		return entityManager.find(TipoTransaccion.class,id);
	}

	@Override
	public List<TipoTransaccion> findAll() {
		final String  jpql = "SELECT tip FROM TipoTransaccion tip";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public TipoTransaccion findName(String nombre) {
		String jpql = "SELECT tip from TipoTransaccion tip where tip.nombre=:nombre";
		return (TipoTransaccion)entityManager.createQuery(jpql).setParameter("nombre",nombre).getSingleResult();
	}
}
