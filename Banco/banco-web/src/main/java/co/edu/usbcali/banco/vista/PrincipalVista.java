package co.edu.usbcali.banco.vista;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Usuario;
import co.edu.usbcali.banco.util.FacesUtils;

@ManagedBean
@ViewScoped
public class PrincipalVista {
	
	private String nombreUsuario;
	private boolean perfilView;
	private boolean cajeroView;
	private boolean asesorView;
	private boolean administradorView;

	public String getNombreUsuario() {
		try {
			Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
			nombreUsuario=usuario.getNombre();
			return nombreUsuario;
		} catch (Exception e) {
			return "";
		}
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public boolean isCajeroView() {
		try {
			Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
			if(usuario.getTipoUsuario().getTiusId()==1L) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void setCajeroView(boolean cajeroView) {
		this.cajeroView = cajeroView;
	}

	public boolean isAsesorView() {
		try {
			Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
			if(usuario.getTipoUsuario().getTiusId()>=2L) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void setAsesorView(boolean asesorView) {
		this.asesorView = asesorView;
	}

	public boolean isAdministradorView() {
		try {
			Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
			if(usuario.getTipoUsuario().getTiusId()==3L) {
				return true;
			}
			return false;
			
		} catch (Exception e) {
			return false;
		}
		
	}

	public void setAdministradorView(boolean administradorView) {
		this.administradorView = administradorView;
	}

	public boolean isPerfilView() {
		try {
			Cliente cliente = (Cliente)FacesUtils.getfromSession("cliente");
			if(cliente!=null)
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}		
	}

	public void setPerfilView(boolean perfilView) {
		this.perfilView = perfilView;
	}
	
	

}
