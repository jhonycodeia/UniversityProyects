package co.edu.usbcali.banco.logica;

import java.util.List;

import co.edu.usbcali.banco.modelo.TipoTransaccion;

public interface ITipoTransaccionLogica {

	public void create(TipoTransaccion tipoTransaccion)throws Exception;
	public void update(TipoTransaccion tipoTransaccion)throws Exception;
	public void delete(TipoTransaccion tipoTransaccion)throws Exception;
	public void delete(long id)throws Exception;	
	public TipoTransaccion find(long id);
	public List<TipoTransaccion> findAll();
	public TipoTransaccion findName(String nombre);
}
