package co.edu.usbcali.banco.dao;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.Usuario;

@Repository
@Scope("singleton")

public class CuentaDAO implements ICuentaDAO{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void create(Cuenta cuenta) {
		entityManager.persist(cuenta);		
		
	}

	@Override
	public void update(Cuenta cuenta) {
		entityManager.merge(cuenta);
		
	}

	@Override
	public void delete(Cuenta cuenta) {
		entityManager.remove(cuenta);
		
	}

	@Override
	public void delete(String id) {
		entityManager.remove(find(id));
		
	}

	@Override
	public Cuenta find(String id) {
		Cuenta cuenta = entityManager.find(Cuenta.class,id);
		if(cuenta!=null)
			Hibernate.initialize(cuenta.getCliente());
		return cuenta;
	}

	@Override
	public List<Cuenta> findAll() {
		final String  jpql = "SELECT cue FROM Cuenta cue";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Cuenta> findAllCliente(BigDecimal idCliente) {
		String jpql = "SELECT cue from Cuenta cue where cue.cliente.clieId=:id";
		return entityManager.createQuery(jpql).setParameter("id",idCliente).getResultList();
	}
	
	
}
