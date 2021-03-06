package co.edu.usbcali.banco.vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.edu.usbcali.banco.modelo.TipoDocumento;

@ManagedBean
@ViewScoped
public class TipoDocumentoVista {

	@ManagedProperty("#{delegadoDeNegocio}")
	private IDelegadoDeNegocio delegadoDeNegocio;
	private List<TipoDocumento> losTipoDeDocumento;
	
	public IDelegadoDeNegocio getDelegadoDeNegocio() {
		return delegadoDeNegocio;
	}
	public void setDelegadoDeNegocio(IDelegadoDeNegocio delegadoDeNegocio) {
		this.delegadoDeNegocio = delegadoDeNegocio;
	}
	public List<TipoDocumento> getLosTipoDeDocumento() {
		if(losTipoDeDocumento == null) {
			losTipoDeDocumento = delegadoDeNegocio.findAllTipoDocumento();
		}
		return losTipoDeDocumento;
	}
	public void setLosTipoDeDocumento(List<TipoDocumento> losTipoDeDocumento) {
		this.losTipoDeDocumento = losTipoDeDocumento;
	}
	
	
}
