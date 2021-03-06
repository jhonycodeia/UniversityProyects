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

import co.edu.usbcali.banco.dao.ITipoTransaccionDAO;
import co.edu.usbcali.banco.dao.ITipoUsuarioDAO;
import co.edu.usbcali.banco.modelo.TipoTransaccion;
import co.edu.usbcali.banco.modelo.TipoUsuario;

@Service
@Scope("singleton")
public class TipoTransaccionLogica implements ITipoTransaccionLogica {

	@Autowired
	private ITipoTransaccionDAO tipoTransaccionDAO;

	@Autowired
	private Validator validator;
	
	private void validar(TipoTransaccion tipoTransaccion) throws Exception {
	    try {
	        Set<ConstraintViolation<TipoTransaccion>> constraintViolations = validator.validate(tipoTransaccion);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<TipoTransaccion> constraintViolation : constraintViolations) {
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
	public void create(TipoTransaccion tipoTransaccion) throws Exception {
		if(tipoTransaccion==null){
			throw new Exception("El tipoTransaccion no puede ser nulo");
		}
		
		validar(tipoTransaccion);
		
		TipoTransaccion entity = tipoTransaccionDAO.find(tipoTransaccion.getTitrId());
		
		if(entity!=null){
			throw new Exception("El tipoUsuario con id: "+entity.getTitrId()+" Ya existe");
		}
				
		if(tipoTransaccion.getActivo()=='Z')
			throw new Exception("El Activo: No valido");
		
		tipoTransaccionDAO.create(tipoTransaccion);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(TipoTransaccion tipoTransaccion) throws Exception {
		if(tipoTransaccion==null){
			throw new Exception("El tipoUsuario no puede ser nulo");
		}
		
		validar(tipoTransaccion);
		
		TipoTransaccion entity = tipoTransaccionDAO.find(tipoTransaccion.getTitrId());
		
		if(entity==null){
			throw new Exception("El tipoUsuario con id: "+entity.getTitrId()+"No existe");
		}
			
		if(tipoTransaccion.getActivo()=='Z')
			throw new Exception("El Activo: No valido");
		
		tipoTransaccionDAO.update(tipoTransaccion);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(TipoTransaccion tipoTransaccion) throws Exception {
		if(tipoTransaccion==null){
			throw new Exception("El tipoUsuario no puede ser nulo");
		}
		
		validar(tipoTransaccion);
			
		tipoTransaccionDAO.delete(tipoTransaccion);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(long id) throws Exception {
		
		TipoTransaccion entity = tipoTransaccionDAO.find(id);
		
		if(entity==null){
			throw new Exception("El cliente con id: "+id+" No existe");
		}
		tipoTransaccionDAO.delete(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public TipoTransaccion find(long id) {
		return tipoTransaccionDAO.find(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoTransaccion> findAll() {
		return tipoTransaccionDAO.findAll();
	}

	@Override
	public TipoTransaccion findName(String nombre) {
		try {
			return tipoTransaccionDAO.findName(nombre);
		} catch (Exception e) {
			return null;
		}
	}
}
