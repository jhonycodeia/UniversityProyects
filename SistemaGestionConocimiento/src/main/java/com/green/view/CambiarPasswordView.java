package com.green.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.modelo.Usuario;
import com.green.utility.Constantes;
import com.green.utility.FacesUtils;


@ViewScoped
@ManagedBean
public class CambiarPasswordView {

	// Variable que se realiza un value con cambiarPassword.xhtml para guardar la
	// contraseña
	private String password;

	// Variable que se realiza un value con cambiarPassword.xhtml para guardar la
	// segunda contraseña
	private String passwordRepeat;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	// Delegado de negocio encargado de llamar a toda la logica
	@ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

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
					usuario.setClave(password);					
					// Se actualiza en base de datos
					businessDelegatorView.updateUsuario(usuario);
					// Redirecciona el menu principal
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("/green/XHTML/feed/home.xhtml");
				} else {
					// Validacion de no coincidencia de contraseña
					FacesUtils.addErrorMessage("Las contraseñas no conciden");
				}
			}

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());

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
	
	 public BusinessDelegator getBusinessDelegatorView() {
	        return businessDelegatorView;
	    }

	    public void setBusinessDelegatorView(
	        BusinessDelegator businessDelegatorView) {
	        this.businessDelegatorView = businessDelegatorView;
	    }

	

}
