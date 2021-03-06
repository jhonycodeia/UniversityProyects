package co.edu.usbcali.banco.vista;


import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import co.edu.usbcali.banco.modelo.Usuario;
import co.edu.usbcali.banco.seguridad.AuthenticationHierachyAutProvider;
import co.edu.usbcali.banco.seguridad.BancoClienteAutProvider;
import co.edu.usbcali.banco.util.FacesUtils;

import java.io.IOException;
import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ViewScoped
@ManagedBean(name = "loginView")
public class LoginView {
	
	private final static Logger log = LoggerFactory.getLogger(LoginView.class);
	//user
    private String userId;
    private String password;    
    //cliente
    private String clieId;
    private String clieCuenId;
    private String clieCuenPass;
    //menu
    private SelectOneRadio somRadioLogin;    
    
    private boolean viewUser = true;
    private boolean viewCliente;
    
    public String menuOnChange() {
    	String tipo = somRadioLogin.getValue().toString();
    	if(tipo.equals("1")) {
    		viewUser = true;
    		viewCliente= false;
    	}
    	else {
    		viewUser = false;
    		viewCliente= true;
    	}
    	return "";
    }
    
    public String login() throws IOException {
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUserId(), this.getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(result);

            ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

            Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
             
            if(usuario.getTipoUsuario().getNombre().equals("CAJERO"))
            	FacesContext.getCurrentInstance().getExternalContext().redirect("CAJERO/cajero.xhtml");
            else if(usuario.getTipoUsuario().getNombre().equals("ASESOR COMERCIAL"))
            	FacesContext.getCurrentInstance().getExternalContext().redirect("ASESOR_COMERCIAL/asesor.xhtml");
            else if(usuario.getTipoUsuario().getNombre().equals("ADMINISTRADOR"))
            	FacesContext.getCurrentInstance().getExternalContext().redirect("ADMINISTRADOR/administrador.xhtml");
            else {
            	FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_WARN,"Su tipo de usuario no tiene permisos en el sistema", ""));
            }
        } catch (AuthenticationException e) {          

            return "";
        }
        
        
        
      return "";
    }
    
    public String loginCliente() throws IOException {
    	 try {
    		 
             
    		 Authentication request = new AuthenticationHierachyAutProvider(this.getClieCuenId(), this.getClieCuenPass(),this.getClieId());
             Authentication result = authenticationManager.authenticate(request);
             SecurityContext securityContext = SecurityContextHolder.getContext();
             securityContext.setAuthentication(result);

             ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
             
             FacesContext.getCurrentInstance().getExternalContext().redirect("CLIENTE/cliente.xhtml");
         } catch (AuthenticationException e) {                  	 
             return "";
         }
    	 
         return "";
    }
   
    //binding
    
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;

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
    
        
    

	public SelectOneRadio getSomRadioLogin() {
		return somRadioLogin;
	}

	public void setSomRadioLogin(SelectOneRadio somRadioLogin) {
		this.somRadioLogin = somRadioLogin;
	}

	public boolean isViewUser() {
		return viewUser;
	}

	public void setViewUser(boolean viewUser) {
		this.viewUser = viewUser;
	}

	public boolean isViewCliente() {
		return viewCliente;
	}

	public void setViewCliente(boolean viewCliente) {
		this.viewCliente = viewCliente;
	}

	public String getClieId() {
		return clieId;
	}

	public void setClieId(String clieId) {
		this.clieId = clieId;
	}

	public String getClieCuenId() {
		return clieCuenId;
	}

	public void setClieCuenId(String clieCuenId) {
		this.clieCuenId = clieCuenId;
	}

	public String getClieCuenPass() {
		return clieCuenPass;
	}

	public void setClieCuenPass(String clieCuenPass) {
		this.clieCuenPass = clieCuenPass;
	}	
	 
}
