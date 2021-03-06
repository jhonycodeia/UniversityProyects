package co.edu.usbcali.banco.dao;

import java.util.List;

import co.edu.usbcali.banco.modelo.Transaccion;

public interface ITransaccionDAO {

	public void create(Transaccion transaccion);
	public void update(Transaccion transaccion);
	public void delete(Transaccion transaccion);
	public void delete(long id);	
	public Transaccion find(long id);
	public List<Transaccion> findAll();
	public List<Transaccion> findAllCuenta(String cuenta);
}
