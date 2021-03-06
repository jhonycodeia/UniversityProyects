package co.edu.usbcali.banco.dao;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.banco.modelo.Cliente;

@Repository
@Scope("singleton")


public class ClienteDAO implements IClienteDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void create(Cliente cliente) {
		entityManager.persist(cliente);		
	}

	@Override
	public void update(Cliente cliente) {
		entityManager.merge(cliente);
		
	}
	
	@Override
	public void delete(Cliente cliente) {
		entityManager.remove(cliente);
		
	}
	
	@Override
	public void delete(BigDecimal id) {
		entityManager.remove(find(id));
		
	}	

	@Override	
	public Cliente find(BigDecimal id) {
		Cliente cliente = entityManager.find(Cliente.class,id);
		if(cliente!=null)
			Hibernate.initialize(cliente.getTipoDocumento());
		return cliente;
	}

	@Override	
	public List<Cliente> findAll() {	
		final String  jpql = "SELECT cli FROM Cliente cli";
		return entityManager.createQuery(jpql).getResultList();
	}

	

}
