package co.edu.usbcali.banco.dao;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.banco.modelo.Cliente;

public interface IClienteDAO {

	public void create(Cliente cliente);
	public void update(Cliente cliente);
	public void delete(Cliente cliente);
	public void delete(BigDecimal id);	
	public Cliente find(BigDecimal id);
	public List<Cliente> findAll();
}
