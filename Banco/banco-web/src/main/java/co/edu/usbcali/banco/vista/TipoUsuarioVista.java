package co.edu.usbcali.banco.vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.edu.usbcali.banco.modelo.TipoUsuario;

@ManagedBean
@ViewScoped
public class TipoUsuarioVista {

	@ManagedProperty("#{delegadoDeNegocio}")
	private IDelegadoDeNegocio delegadoDeNegocio;
	public IDelegadoDeNegocio getDelegadoDeNegocio() {
		return delegadoDeNegocio;
	}

	public void setDelegadoDeNegocio(IDelegadoDeNegocio delegadoDeNegocio) {
		this.delegadoDeNegocio = delegadoDeNegocio;
	}

	private List<TipoUsuario> losTipoDeUsuario;

	public List<TipoUsuario> getLosTipoDeUsuario() {
		if (losTipoDeUsuario == null) {
			losTipoDeUsuario = delegadoDeNegocio.findAllTipoUsuario();
		}
		return losTipoDeUsuario;
	}

	public void setLosTipoDeUsuario(List<TipoUsuario> losTipoDeUsuario) {
		this.losTipoDeUsuario = losTipoDeUsuario;
	}
	
	
	
	
}
