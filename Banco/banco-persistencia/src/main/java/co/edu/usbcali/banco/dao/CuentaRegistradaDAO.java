package co.edu.usbcali.banco.dao;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.banco.modelo.CuentaRegistrada;
import co.edu.usbcali.banco.modelo.Usuario;

@Repository
@Scope("singleton")

public class CuentaRegistradaDAO implements ICuentaRegistradaDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void create(CuentaRegistrada cuentaRegistrada) {
		entityManager.persist(cuentaRegistrada);

	}

	@Override
	public void update(CuentaRegistrada cuentaRegistrada) {
		entityManager.merge(cuentaRegistrada);

	}

	@Override
	public void delete(CuentaRegistrada cuentaRegistrada) {
		entityManager.remove(cuentaRegistrada);

	}

	@Override
	public void delete(long id) {
		entityManager.remove(find(id));

	}

	@Override
	public CuentaRegistrada find(long id) {
		return entityManager.find(CuentaRegistrada.class, id);
	}

	@Override
	public List<CuentaRegistrada> findAll() {
		final String jpql = "SELECT cue FROM CuentaRegistrada cue";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<CuentaRegistrada> findCliente(BigDecimal clieId) {
		String jpql ="SELECT cue FROM CuentaRegistrada cue WHERE cue.cliente.clieId=:id";
		List<CuentaRegistrada> lasCuentasRegistradas = entityManager.createQuery(jpql).setParameter("id",clieId).getResultList();
		if(lasCuentasRegistradas!=null) {
			for (CuentaRegistrada cuentaRegistrada : lasCuentasRegistradas) {
				Hibernate.initialize(cuentaRegistrada.getCliente());
				Hibernate.initialize(cuentaRegistrada.getCuenta());
			}
		}
		return lasCuentasRegistradas;
	}

	@Override
	public CuentaRegistrada findClienteCuenta(String cuenId, BigDecimal clieId) {
		String jpql ="SELECT cue FROM CuentaRegistrada cue WHERE cue.cliente.clieId=:id AND cue.cuenta.cuenId=:cuenta";
		return (CuentaRegistrada)entityManager.createQuery(jpql).setParameter("id",clieId).setParameter("cuenta",cuenId).getSingleResult();
	}

	@Override
	public List<CuentaRegistrada> findClienteOnly(BigDecimal clieId) {
		String jpql ="SELECT cue FROM CuentaRegistrada cue,Cuenta cuenta WHERE cue.cliente.clieId=:id AND cuenta.cliente.clieId=cue.cliente.clieId AND cue.cuenta.cuenId=cuenta.cuenId" ;
		List<CuentaRegistrada> lasCuentasRegistradas = entityManager.createQuery(jpql).setParameter("id",clieId).getResultList();
		if(lasCuentasRegistradas!=null) {
			for (CuentaRegistrada cuentaRegistrada : lasCuentasRegistradas) {
				Hibernate.initialize(cuentaRegistrada.getCliente());
				Hibernate.initialize(cuentaRegistrada.getCuenta());
			}
		}
		return lasCuentasRegistradas;
	}

}
