package co.edu.usbcali.banco.logica;

import java.util.List;

import co.edu.usbcali.banco.modelo.Usuario;

public interface IUsuarioLogica {

	public void create(Usuario usuario)throws Exception;
	public void update(Usuario usuario)throws Exception;
	public void delete(Usuario usuario)throws Exception;
	public void delete(String id)throws Exception;	
	public Usuario find(String id);
	public List<Usuario> findAll();
	public Usuario login(String id,String pass)throws Exception;
}
