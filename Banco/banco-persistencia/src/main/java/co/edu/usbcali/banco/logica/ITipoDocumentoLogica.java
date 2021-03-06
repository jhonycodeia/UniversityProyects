package co.edu.usbcali.banco.logica;

import java.util.List;

import co.edu.usbcali.banco.modelo.TipoDocumento;



public interface ITipoDocumentoLogica {

	public void create(TipoDocumento tipoDocumento)throws Exception;
	public void update(TipoDocumento tipoDocumento)throws Exception;
	public void delete(TipoDocumento tipoDocumento)throws Exception;
	public void delete(long id)throws Exception;	
	public TipoDocumento find(long id);
	public List<TipoDocumento> findAll();
	public TipoDocumento findName(String nombre);
}
