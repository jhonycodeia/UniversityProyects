package co.edu.usbcali.banco.logica;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.banco.modelo.Cuenta;



public interface ICuentaLogica {

	public void create(Cuenta cuenta)throws Exception;
	public void update(Cuenta cuenta)throws Exception;
	public void delete(Cuenta cuenta)throws Exception;
	public void delete(String id)throws Exception;	
	public Cuenta find(String id);
	public List<Cuenta> findAll();
	public List<Cuenta> findAllCliente(BigDecimal idCliente);
}
