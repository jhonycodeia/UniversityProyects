package co.edu.usbcali.banco.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Component;

import co.edu.usbcali.banco.modelo.Usuario;
import co.edu.usbcali.banco.util.FacesUtils;
import co.edu.usbcali.banco.vista.IDelegadoDeNegocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
* @author Zathura Code Generator http://code.google.com/p/zathura/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Component("bancoAutProvider")
public class BancoAutProvider implements AuthenticationProvider {
    /**
     * Security Implementation
     */
	@Autowired
	private IDelegadoDeNegocio delegadoNegocio;
	
    @Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {        
		try {
			String name = authentication.getName();
	        String password = authentication.getCredentials().toString();
	        String role;
	        
	        Usuario usuario;
	        
			usuario = delegadoNegocio.loginUsuario(name, password);
			
			role = "ROLE "+usuario.getTipoUsuario().getNombre();
        	role = role.replaceAll(" ","_");
        	
            final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority(role));

            final UserDetails principal = new User(name, password, grantedAuths);
            final Authentication auth = new UsernamePasswordAuthenticationToken(principal,
                    password, grantedAuths);
            
            FacesUtils.putinSession("usuario",usuario);            

            return auth;
            
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		}
        
       
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
