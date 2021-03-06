package co.edu.usbcali.banco.dao;


import java.util.List;

import co.edu.usbcali.banco.modelo.Usuario;



public interface IUsuarioDAO {

	public void create(Usuario usuario);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	public void delete(String id);	
	public Usuario find(String id);
	public List<Usuario> findAll();
}
