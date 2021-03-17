package com.saberpro.presentation.backingBeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.saberpro.utilities.Constantes;
import com.saberpro.utilities.FacesUtils;
import com.saberpro.modelo.Usuario;

import com.saberpro.presentation.businessDelegate.IBusinessDelegatorView;


@ViewScoped
@ManagedBean(name = "loginView")
public class LoginView {
	
	//Variable encargada de realizar los log
	private static final Logger log = LoggerFactory.getLogger(LoginView.class);
	
	// Variable que se realiza un value con login.xhtml para guardar el codigo del
	// usuario que va acceder
    private String userId;
    
    //Variable que se realiza un value con login.xhtml para guardar el correo de recuperar contraseña
    private String email;
    
    //Variable que se realiza un value con login.xhtml para guardar la clave del usuario que va acceder
    private String password;
    
    //autenticador de seguridad
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;
    
    //Delegado de negocio encargado de llamar a toda la logica
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;	

    //Metodo encargado de logear al usuario
    public String login() {
        try {
        	//Se envian los credenciales al ZathuraCodeAuthenticationProvider para que los verifique
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUserId(),this.getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(result);

            FacesUtils.getHttpSession(true).setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
            
            //Se toma el usuario en session
            Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
            
            //Si esta logeando por primera vez redirecciona para escribir una contraseña
            if(usuario.getActivo().equals(Constantes.ESTADO_PENDIENTE)) {
            	return "/XHTML/cambiarPassword.xhtml";
            }
            //Si esta logeando por con cuenta activa lo envia al menu
            else if(usuario.getActivo().equals(Constantes.ESTADO_ACTIVO)) {
            	return "/XHTML/initialMenu.xhtml\";";
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
			businessDelegatorView.resetByEmailUsuario(email);
			FacesUtils.addInfoMessage("Se le ha enviado un correo para poder recuperar su contraseña");
			
		} catch (Exception e) {
			//Mensage en caso de error
			FacesUtils.addErrorMessage("Correo no encontrado"); 
			
        }
	}

    
    //Getter and Setter
    
	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
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
