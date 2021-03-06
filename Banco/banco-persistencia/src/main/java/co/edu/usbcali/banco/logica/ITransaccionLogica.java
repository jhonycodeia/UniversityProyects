package co.edu.usbcali.banco.logica;

import java.util.List;

import co.edu.usbcali.banco.modelo.Transaccion;



public interface ITransaccionLogica {

	public void create(Transaccion transaccion)throws Exception;
	public void update(Transaccion transaccion)throws Exception;
	public void delete(Transaccion transaccion)throws Exception;
	public void delete(long id)throws Exception;	
	public Transaccion find(long id);
	public List<Transaccion> findAll();
	public List<Transaccion> findAllCuenta(String cuenta);
	
}
