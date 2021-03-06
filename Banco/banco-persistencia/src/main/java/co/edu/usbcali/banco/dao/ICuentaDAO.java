package co.edu.usbcali.banco.dao;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.banco.modelo.Cuenta;



public interface ICuentaDAO {

	public void create(Cuenta cuenta);
	public void update(Cuenta cuenta);
	public void delete(Cuenta cuenta);
	public void delete(String id);	
	public Cuenta find(String id);
	public List<Cuenta> findAll(); 
	public List<Cuenta> findAllCliente(BigDecimal idCliente);
}
