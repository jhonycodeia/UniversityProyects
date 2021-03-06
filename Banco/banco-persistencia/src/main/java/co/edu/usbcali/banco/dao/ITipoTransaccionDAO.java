package co.edu.usbcali.banco.dao;

import java.util.List;

import co.edu.usbcali.banco.modelo.TipoTransaccion;


public interface ITipoTransaccionDAO {

	public void create(TipoTransaccion tipoTransaccion);
	public void update(TipoTransaccion tipoTransaccion);
	public void delete(TipoTransaccion tipoTransaccion);
	public void delete(long id);	
	public TipoTransaccion find(long id);
	public List<TipoTransaccion> findAll();
	public TipoTransaccion findName(String nombre);
}
