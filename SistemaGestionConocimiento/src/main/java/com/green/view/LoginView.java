package com.green.view;

import com.green.modelo.Usuario;
import com.green.utility.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


@ViewScoped
@ManagedBean(name = "loginView")
public class LoginView {
	
    private String userId;
    private String password;
    private String email;
    
    
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;
    
    public String login() {
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUserId(),
                    this.getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(result);

            FacesUtils.getHttpSession(true)
                      .setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
            
          //Se toma el usuario en session
            Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
            
            //Si esta logeando por primera vez redirecciona para escribir una contraseña
            if(usuario.getActivo().equals(Constantes.ESTADO_PENDIENTE)) {
            	return "/XHTML/cambiarPassword.xhtml";
            }
            //Si esta logeando por con cuenta activa lo envia al menu
            else if(usuario.getActivo().equals(Constantes.ESTADO_ACTIVO)) {
            	return "/XHTML/feed/home.xhtml";
            }
            //Si esta logeando pero la cuenta no esta inactiva no deja entrar
            else if(usuario.getActivo().equals(Constantes.ESTADO_INACTIVO)) {
            	FacesUtils.addErrorMessage("La cuenta no esta activa");
            }    
        } catch (AuthenticationException e) {
        	FacesUtils.addErrorMessage(e.getMessage());
        	e.printStackTrace();
        }

        return "/login.xhtml";
    }
    
    public void resetPassword() {
		try {
			//Se envia un correo electronico al correo con contraseña aleatoria para que recupere la contraseña
			//businessDelegatorView.resetByEmailUsuario(email);
			FacesUtils.addInfoMessage("Se le ha enviado un correo para poder recuperar su contraseña");
			
		} catch (Exception e) {
			//Mensage en caso de error
			FacesUtils.addErrorMessage("Correo no encontrado"); 
			
        }
	}
    
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(
        AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }   

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
