package co.edu.usbcali.banco.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.banco.modelo.Transaccion;

@Repository
@Scope("singleton")

public class TransaccionDAO implements ITransaccionDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void create(Transaccion transaccion) {
		entityManager.persist(transaccion);
	}

	@Override
	public void update(Transaccion transaccion) {
		entityManager.merge(transaccion);

	}

	@Override
	public void delete(Transaccion transaccion) {
		entityManager.remove(transaccion);

	}

	@Override
	public void delete(long id) {
		entityManager.remove(find(id));

	}

	@Override
	public Transaccion find(long id) {
		Transaccion transaccion = entityManager.find(Transaccion.class, id);
		if(transaccion!=null)
			Hibernate.initialize(transaccion.getTipoTransaccion());
		return transaccion;
	}

	@Override
	public List<Transaccion> findAll() {
		final String jpql = "SELECT tran FROM Transaccion tran";
		List<Transaccion> lasTransacciones = entityManager.createQuery(jpql).getResultList();
		if (lasTransacciones != null) {
			for (Transaccion transaccion : lasTransacciones) {
				Hibernate.initialize(transaccion.getTipoTransaccion());
				Hibernate.initialize(transaccion.getCuenta());
				Hibernate.initialize(transaccion.getUsuario());
			}
		}
		return lasTransacciones;
	}

	@Override
	public List<Transaccion> findAllCuenta(String cuenta) {
		String jpql = "SELECT tran FROM Transaccion tran WHERE tran.cuenta.cuenId=:cuenta";
		List<Transaccion> lasTransacciones = entityManager.createQuery(jpql).setParameter("cuenta", cuenta).getResultList();
		if (lasTransacciones != null) {
			for (Transaccion transaccion : lasTransacciones) {
				Hibernate.initialize(transaccion.getTipoTransaccion());
				Hibernate.initialize(transaccion.getCuenta());
				Hibernate.initialize(transaccion.getUsuario());
			}
		}
		return lasTransacciones;
	}
}
