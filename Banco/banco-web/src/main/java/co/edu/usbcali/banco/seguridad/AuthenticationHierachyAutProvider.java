package co.edu.usbcali.banco.seguridad;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class AuthenticationHierachyAutProvider extends 	UsernamePasswordAuthenticationToken{
	
	private Object clieId;
	
	public AuthenticationHierachyAutProvider(Object principal, Object credentials, Object clienId) {
		super(principal, credentials);
		this.clieId = clienId;
	}
	
	public AuthenticationHierachyAutProvider(Object principal, Object credentials, Object clienId,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
		this.clieId = clienId;
	}

	public Object getClieId() {
		return clieId;
	}

	public void setClieId(Object clieId) {
		this.clieId = clieId;
	}

}
