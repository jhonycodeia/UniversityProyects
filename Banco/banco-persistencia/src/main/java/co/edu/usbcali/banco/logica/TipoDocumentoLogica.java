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

import co.edu.usbcali.banco.dao.ITipoDocumentoDAO;
import co.edu.usbcali.banco.modelo.TipoDocumento;

@Service
@Scope("singleton")
public class TipoDocumentoLogica implements ITipoDocumentoLogica {

	@Autowired
	private ITipoDocumentoDAO tipoDocumentoDAO;

	@Autowired
	private Validator validator;
	
	private void validar(TipoDocumento tipoDocumento) throws Exception {
	    try {
	        Set<ConstraintViolation<TipoDocumento>> constraintViolations = validator.validate(tipoDocumento);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<TipoDocumento> constraintViolation : constraintViolations) {
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
	public void create(TipoDocumento tipoDocumento) throws Exception {
		if(tipoDocumento==null){
			throw new Exception("El tipoDocumento no puede ser nulo");
		}
		
		validar(tipoDocumento);
		
		
		TipoDocumento entity = tipoDocumentoDAO.find(tipoDocumento.getTdocId());
		
		if(entity!=null){
			throw new Exception("El tipoDocumento con id: "+entity.getTdocId()+" Ya existe");
		}
		
		if(tipoDocumento.getActivo()=='Z')
			throw new Exception("El Activo: No valido");
				
		tipoDocumentoDAO.create(tipoDocumento);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(TipoDocumento tipoDocumento) throws Exception {
		if(tipoDocumento==null){
			throw new Exception("El tipoDocumento no puede ser nulo");
		}
		
		validar(tipoDocumento);
		
		TipoDocumento entity = tipoDocumentoDAO.find(tipoDocumento.getTdocId());
		
		if(entity==null){
			throw new Exception("El tipoDocumento con id: "+entity.getTdocId()+"No existe");
		}
				
		if(tipoDocumento.getActivo()=='Z')
			throw new Exception("El Activo: No valido");
		
		tipoDocumentoDAO.update(tipoDocumento);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(TipoDocumento tipoDocumento) throws Exception {
		if(tipoDocumento==null){
			throw new Exception("El tipoDocumento no puede ser nulo");
		}
		
		validar(tipoDocumento);
			
		tipoDocumentoDAO.delete(tipoDocumento);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(long id) throws Exception {
		
		TipoDocumento entity = tipoDocumentoDAO.find(id);
		
		if(entity==null){
			throw new Exception("El cliente con id: "+id+" No existe");
		}
		tipoDocumentoDAO.delete(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public TipoDocumento find(long id) {
		return tipoDocumentoDAO.find(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoDocumento> findAll() {
		return tipoDocumentoDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public TipoDocumento findName(String nombre) {
		try {
			return tipoDocumentoDAO.findName(nombre);
		} catch (Exception e) {
			return null;
		}
		
	}

	


}
