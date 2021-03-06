package co.edu.usbcali.banco.logica;

import java.util.List;

import co.edu.usbcali.banco.modelo.TipoUsuario;


public interface ITipoUsuarioLogica {

	public void create(TipoUsuario tipoUsuario)throws Exception;
	public void update(TipoUsuario tipoUsuario)throws Exception;
	public void delete(TipoUsuario tipoUsuario)throws Exception;
	public void delete(long id)throws Exception;	
	public TipoUsuario find(long id);
	public List<TipoUsuario> findAll();
	public TipoUsuario findName(String nombre);
}
