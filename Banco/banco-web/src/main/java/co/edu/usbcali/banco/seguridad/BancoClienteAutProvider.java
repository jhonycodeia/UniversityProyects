package co.edu.usbcali.banco.seguridad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import co.edu.usbcali.banco.dao.TestClienteDAO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.Usuario;
import co.edu.usbcali.banco.util.FacesUtils;
import co.edu.usbcali.banco.vista.DelegadoDeNegocio;
import co.edu.usbcali.banco.vista.IDelegadoDeNegocio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Scope("singleton")
@Component("bancoClienteAutProvider")
public class BancoClienteAutProvider implements AuthenticationProvider {

	private final static Logger log = LoggerFactory.getLogger(BancoClienteAutProvider.class);
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		BigDecimal identificacion;
		try {
			identificacion = new BigDecimal(
					((AuthenticationHierachyAutProvider) authentication).getClieId().toString());
		} catch (Exception e) {
			identificacion = null;
		}
		
		
		try {
			String name = authentication.getName();
			String password = authentication.getCredentials().toString();
			 
			
			Cliente cliente = delegadoDeNegocio.loginCliente(identificacion,name, password);

			if (cliente!=null) {

				final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
				grantedAuths.add(new SimpleGrantedAuthority("ROLE_CLIENTE"));

				final UserDetails principal = new User(name, password, grantedAuths);
				final Authentication auth = new AuthenticationHierachyAutProvider(principal, password,identificacion,
						grantedAuths);

				FacesUtils.putinSession("cliente",cliente);
				return auth;
			}
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			log.info(e.getMessage());
			return null;
		}
		return null;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(AuthenticationHierachyAutProvider.class);
	}
}
