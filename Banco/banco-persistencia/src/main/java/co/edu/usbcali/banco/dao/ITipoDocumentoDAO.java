package co.edu.usbcali.banco.dao;


import java.util.List;

import co.edu.usbcali.banco.modelo.TipoDocumento;


public interface ITipoDocumentoDAO {

	public void create(TipoDocumento tipoDocumento);
	public void update(TipoDocumento tipoDocumento);
	public void delete(TipoDocumento tipoDocumento);
	public void delete(long id);	
	public TipoDocumento find(long id);
	public List<TipoDocumento> findAll();
	public TipoDocumento findName(String nombre);
}

