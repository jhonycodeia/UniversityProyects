package com.saberpro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.Programa;
import com.saberpro.modelo.ProgramaUsuario;
import com.saberpro.modelo.TipoUsuario;
import com.saberpro.modelo.Usuario;
import com.saberpro.modelo.dto.UsuarioDTO;
import com.saberpro.presentation.businessDelegate.IBusinessDelegatorView;
import com.saberpro.utilities.Constantes;
import com.saberpro.utilities.FacesUtils;
import com.saberpro.utilities.VariablesSession;;




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
	//variable que almacena la logica de negocio
	@Autowired
	IBusinessDelegatorView businessDelegatorView;
	
	//Variable encargada de encriptacion y comparacion de contraseñas
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) {
		
		//Se toman los datos de la vista el codigo y clave
		long codigo = Long.parseLong(authentication.getName());
		String password = authentication.getCredentials().toString();

		try {
			//Se consulta el usuario y los permisos si existe
			User user = businessDelegatorView.loadByCodigoUsuario(codigo);
			
			if (user != null) {
				//Se comparan la similitud de las contraseñas
				if (passwordEncoder.matches(password, user.getPassword())) {
					
					inicializar(businessDelegatorView.findByCodigoUsuario(codigo).getIdUsuario());	
					
					//Se envia el token de seguridad con datos de usuario y sus permisos
					return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),user.getAuthorities());
					
				} else {
					//Excepcion si hay error en la contraseña
					throw new Exception("Error en codigo o contraseña");
				}
			} else {
				//Excepcion si no existe el usuario
				throw new Exception("Error en codigo o contraseña");
			}
		} catch (Exception e) {			
			//Excepcion falla algo del codigo
			e.printStackTrace();
			throw new BadCredentialsException("Error en codigo o contraseña");
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
    /**
    *
    * Metodo encargado de almacenar los datos de session
    *
    * @param idUsuario long id del usuario que se esta logeando 
    */ 
	public void inicializar(long idUsuario) {
		
		 
		try {
			Usuario usuario = businessDelegatorView.getUsuario(idUsuario);
			TipoUsuario tipoUsuario = businessDelegatorView.getTipoUsuario(usuario.getTipoUsuario().getIdTipoUsuario());
			
			Object[] variableProgramaUsuario = {"usuario.idUsuario",true,usuario.getIdUsuario(),"="};
			ProgramaUsuario programaUsuario = businessDelegatorView.findByCriteriaInProgramaUsuario(variableProgramaUsuario,null,null).get(0);	
			
			Programa programa = businessDelegatorView.getPrograma(programaUsuario.getPrograma().getIdPrograma());
			Facultad facultad = businessDelegatorView.getFacultad(programa.getFacultad().getIdFacultad());
			
			//se almacena los datos en memoria
			VariablesSession.usuario = usuario;
			VariablesSession.tipoUsuario = tipoUsuario;
			VariablesSession.programaUsuario = programaUsuario;
			VariablesSession.programa = programa;
			VariablesSession.facultad = facultad;
			
			//Se almacenas los datos en cache
			FacesUtils.putinSession("usuario",usuario); 
			FacesUtils.putinSession("tipoUsuario",tipoUsuario); 
			FacesUtils.putinSession("programaUsuario",programaUsuario); 
			FacesUtils.putinSession("programa",programa); 
			FacesUtils.putinSession("facultad",facultad); 			
			
			//Falta limpiar
			FacesUtils.putinSession("usuarioDTO",businessDelegatorView.findDataByCodigoUsuario(usuario.getCodigo()));  
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
		
	}
}
