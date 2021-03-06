package co.edu.usbcali.banco.logica;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.dao.ITipoUsuarioDAO;
import co.edu.usbcali.banco.modelo.TipoUsuario;

@Service
@Scope("singleton")
public class TipoUsuarioLogica implements ITipoUsuarioLogica {

	@Autowired
	private ITipoUsuarioDAO tipoUsuarioDAO;

	@Autowired
	private Validator validator;
	
	private void validar(TipoUsuario tipoUsuario) throws Exception {
	    try {
	        Set<ConstraintViolation<TipoUsuario>> constraintViolations = validator.validate(tipoUsuario);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<TipoUsuario> constraintViolation : constraintViolations) {
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
	public void create(TipoUsuario tipoUsuario) throws Exception {
		if(tipoUsuario==null){
			throw new Exception("El tipoUsuario no puede ser nulo");
		}
		
		validar(tipoUsuario);
		
		TipoUsuario entity = tipoUsuarioDAO.find(tipoUsuario.getTiusId());
		
		if(entity!=null){
			throw new Exception("El tipoUsuario con id: "+entity.getTiusId()+" Ya existe");
		}
		
		if(tipoUsuario.getActivo()=='Z')
			throw new Exception("El Activo: No valido");
				
		tipoUsuarioDAO.create(tipoUsuario);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(TipoUsuario tipoUsuario) throws Exception {
		if(tipoUsuario==null){
			throw new Exception("El tipoUsuario no puede ser nulo");
		}
		
		validar(tipoUsuario);
		
		TipoUsuario entity = tipoUsuarioDAO.find(tipoUsuario.getTiusId());
		
		if(entity==null){
			throw new Exception("El tipoUsuario con id: "+entity.getTiusId()+"No existe");
		}
			
		if(tipoUsuario.getActivo()=='Z')
			throw new Exception("El Activo: No valido");
		
		tipoUsuarioDAO.update(tipoUsuario);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(TipoUsuario tipoUsuario) throws Exception {
		if(tipoUsuario==null){
			throw new Exception("El tipoUsuario no puede ser nulo");
		}
		
		validar(tipoUsuario);
			
		tipoUsuarioDAO.delete(tipoUsuario);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(long id) throws Exception {
		
		TipoUsuario entity = tipoUsuarioDAO.find(id);
		
		if(entity==null){
			throw new Exception("El cliente con id: "+id+" No existe");
		}
		tipoUsuarioDAO.delete(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public TipoUsuario find(long id) {
		return tipoUsuarioDAO.find(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoUsuario> findAll() {
		return tipoUsuarioDAO.findAll();
	}

	@Override
	public TipoUsuario findName(String nombre) {
		try {
			return tipoUsuarioDAO.findName(nombre);
		} catch (Exception e) {
			return null;
		}
	}

}
