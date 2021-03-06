package co.edu.usbcali.banco.dao;


import java.util.List;

import co.edu.usbcali.banco.modelo.TipoUsuario;



public interface ITipoUsuarioDAO {

	public void create(TipoUsuario tipoUsuario);
	public void update(TipoUsuario tipoUsuario);
	public void delete(TipoUsuario tipoUsuario);
	public void delete(long id);	
	public TipoUsuario find(long id);
	public List<TipoUsuario> findAll();
	public TipoUsuario findName(String nombre);
}
