package com.saberpro.presentation.backingBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.saberpro.modelo.Usuario;
import com.saberpro.presentation.businessDelegate.IBusinessDelegatorView;
import com.saberpro.utilities.Constantes;
import com.saberpro.utilities.FacesUtils;

@ViewScoped
@ManagedBean(name = "cambiarPasswordView")
public class CambiarPasswordView {

	// Variable que se realiza un value con cambiarPassword.xhtml para guardar la
	// contraseña
	private String password;

	// Variable que se realiza un value con cambiarPassword.xhtml para guardar la
	// segunda contraseña
	private String passwordRepeat;

	// Delegado de negocio encargado de llamar a toda la logica
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	// Metodo encargado de cambiar la contraseña
	public void cambiarPassword() {

		try {
			// Se toma el usuario en session
			Usuario usuario = (Usuario) FacesUtils.getfromSession("usuario");

			// Validacion de contraseñas sin valor
			if (password.isEmpty() || passwordRepeat.isEmpty()) {
				FacesUtils.addErrorMessage("Escriba una contraseña");
			} else {
				// Compara que las contraseñas sean igual
				if (password.equals(passwordRepeat)) {
					// Actualiza los datos del usuario en session
					usuario.setPassword(businessDelegatorView.encodePasswordUsuario(password));
					usuario.setActivo(Constantes.ESTADO_ACTIVO);
					// Se actualiza en base de datos
					businessDelegatorView.updateUsuario(usuario);
					// Redirecciona el menu principal
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("/saber-pro-app/XHTML/initialMenu.xhtml");
				} else {
					// Validacion de no coincidencia de contraseña
					FacesUtils.addErrorMessage("Las contraseñas no conciden");
				}
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			e.printStackTrace();

		}
	}

	// Getter and Setter
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

}
