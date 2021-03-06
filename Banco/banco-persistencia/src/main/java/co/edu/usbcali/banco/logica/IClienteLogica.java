package co.edu.usbcali.banco.logica;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.banco.modelo.Cliente;

public interface IClienteLogica {
	
	public void create(Cliente cliente)throws Exception;
	public void update(Cliente cliente)throws Exception;
	public void delete(Cliente cliente)throws Exception;
	public void delete(BigDecimal id)throws Exception;	
	public Cliente find(BigDecimal id);
	public List<Cliente> findAll();
	public Cliente login(BigDecimal clieId,String cuenId,String pass)throws Exception;

}
