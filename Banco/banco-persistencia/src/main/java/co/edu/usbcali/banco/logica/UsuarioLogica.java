package co.edu.usbcali.banco.logica;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.dao.IClienteDAO;
import co.edu.usbcali.banco.dao.ITipoDocumentoDAO;
import co.edu.usbcali.banco.dao.ITipoUsuarioDAO;
import co.edu.usbcali.banco.dao.IUsuarioDAO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.TipoDocumento;
import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Usuario;

@Service
@Scope("singleton")
public class UsuarioLogica implements IUsuarioLogica {

	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	private ITipoUsuarioDAO tipoUsuarioDAO;

	@Autowired
	private Validator validator;
	
	private void validar(Usuario usuario) throws Exception {
	    try {
	        Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Usuario> constraintViolation : constraintViolations) {
	                strMessage.append(constraintViolation.getPropertyPath().toString());
	                strMessage.append(" - ");
	                strMessage.append(constraintViolation.getMessage());
	                strMessage.append(". \n");
	            }

	            throw new Exception(strMessage.toString());
	        }
	    } catch (Exception e) {
	        throw e;
	    }
	}
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void create(Usuario usuario) throws Exception {
		if(usuario==null){
			throw new Exception("El cliente no puede ser nulo");
		}
		
		validar(usuario);
		
		Usuario entity = usuarioDAO.find(usuario.getUsuUsuario());		
	
		
		if(entity!=null){
			throw new Exception("El Usuario con id: "+entity.getUsuUsuario()+" Ya existe");
		}
		
		if(usuario.getActivo()=='Z')
			throw new Exception("El Activo: No valido");
		
		TipoUsuario tipoUsuario = tipoUsuarioDAO.find(usuario.getTipoUsuario().getTiusId());
		if(tipoUsuario==null){
			throw new Exception("El tipoUsuario con id: "+usuario.getTipoUsuario().getTiusId()+" No existe");
		}
		
		usuarioDAO.create(usuario);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Usuario usuario) throws Exception {
		if(usuario==null){
			throw new Exception("El cliente no puede ser nulo");
		}
		
		validar(usuario);
	
		if(usuario.getActivo()=='Z')
			throw new Exception("El Activo: No valido");
		
		TipoUsuario tipoUsuario = tipoUsuarioDAO.find(usuario.getTipoUsuario().getTiusId());
		if(tipoUsuario==null){
			throw new Exception("El tipo de documento con id: "+usuario.getTipoUsuario().getTiusId()+" No existe");
		}
		
		usuarioDAO.update(usuario);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Usuario usuario) throws Exception {
		if(usuario==null){
			throw new Exception("El cliente no puede ser nulo");
		}
		if(usuario.getUsuUsuario()==null || usuario.getUsuUsuario().equals("")){
			throw new Exception("La identificación no puede ser nula");
		}		
		usuarioDAO.delete(usuario);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(String id) throws Exception {

		Usuario entity = usuarioDAO.find(id);

		if(entity==null){
			throw new Exception("El cliente con id: "+id+" No existe");
		}
		usuarioDAO.delete(entity);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario find(String id) {
		return usuarioDAO.find(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		return usuarioDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario login(String id, String pass) throws Exception {
		if(id.isEmpty() || pass.isEmpty()) {
			throw new Exception("Escriba un usuario y una contraseña");
		}
		
		Usuario usuario = usuarioDAO.find(id);
		
		if(usuario==null) {
			throw new Exception("El usuario no existe");
		}
		if(usuario.getActivo()!='S')
			throw new Exception("El usuario no esta Activo");
		
		if(usuario.getClave().equals(pass)) {
			return usuario;
		}
		
		else {
			throw new Exception("La contraseña es invalida");
		}
		
	}

	

	
}
