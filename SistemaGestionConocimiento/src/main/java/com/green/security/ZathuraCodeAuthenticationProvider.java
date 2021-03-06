package com.green.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.green.modelo.Area;
import com.green.modelo.TipoUsuario;
import com.green.modelo.Usuario;
import com.green.utility.FacesUtils;
import com.green.utility.VariablesSession;
import com.green.view.BusinessDelegator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura/
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Component("zathuraCodeAuthenticationProvider")
public class ZathuraCodeAuthenticationProvider implements AuthenticationProvider {
	/**
	 * Security Implementation
	 */

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private BusinessDelegator businessDelegatorView;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		try {
			String name = authentication.getName();
			String password = authentication.getCredentials().toString();
			
			Object[] variables = {"correo",true,name,"="};
			Usuario usuario = (Usuario)businessDelegatorView.findByCriteriaInUsuario(variables, null,null).get(0);
			
			if (usuario != null) {
				//Se comparan la similitud de las contraseñas
				if (passwordEncoder.matches(password,usuario.getClave())) {
					
					inicializar(usuario.getIdUsuario());	
					
					List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
					grantedAuths.add(new SimpleGrantedAuthority("ROLE_"+VariablesSession.tipoUsuario.getNombre()));
					
					UserDetails principal = new User(name, password, grantedAuths);
					Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
					
					return auth;
					
				} else {
					//Excepcion si hay error en la contraseña
					throw new Exception("Error en codigo o contraseña");
				}
			} else {
				//Excepcion si no existe el usuario
				throw new Exception("Error en codigo o contraseña");
			}
			
		} catch (Exception e) {
			throw new BadCredentialsException("Error en codigo o contraseña");
		}
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	public void inicializar(long idUsuario) {

		try {
			Usuario usuario = businessDelegatorView.getUsuario(idUsuario);
			TipoUsuario tipoUsuario = businessDelegatorView.getTipoUsuario(usuario.getTipoUsuario().getIdTipoUsuario());
			Area area = businessDelegatorView.getArea(usuario.getArea().getIdArea());

			// se almacena los datos en memoria
			VariablesSession.usuario = usuario;
			VariablesSession.tipoUsuario = tipoUsuario;
			VariablesSession.area = area;

			// Se almacenas los datos en cache
			FacesUtils.putinSession("usuario", usuario);
			FacesUtils.putinSession("tipoUsuario", tipoUsuario);
			FacesUtils.putinSession("area", area);

		} catch (Exception e) {

		}

	}
}
