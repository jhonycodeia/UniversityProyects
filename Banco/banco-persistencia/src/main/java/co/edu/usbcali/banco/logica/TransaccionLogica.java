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

import co.edu.usbcali.banco.dao.IClienteDAO;
import co.edu.usbcali.banco.dao.ICuentaDAO;
import co.edu.usbcali.banco.dao.ITransaccionDAO;
import co.edu.usbcali.banco.dao.IUsuarioDAO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.Transaccion;
import co.edu.usbcali.banco.modelo.Usuario;

@Service
@Scope("singleton")
public class TransaccionLogica implements ITransaccionLogica {

	
	@Autowired
	private ICuentaDAO cuentaDAO ;
	
	@Autowired
	private ITransaccionDAO transaccionDAO;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;

	@Autowired
	private Validator validator;
	
	private void validar(Transaccion transaccion) throws Exception {
	    try {
	        Set<ConstraintViolation<Transaccion>> constraintViolations = validator.validate(transaccion);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Transaccion> constraintViolation : constraintViolations) {
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
	public void create(Transaccion transaccion) throws Exception {
		if(transaccion==null){
			throw new Exception("El cuenta no puede ser nulo");
		}
		
		validar(transaccion);
		
		Usuario usuario = usuarioDAO.find(transaccion.getUsuario().getUsuUsuario());
		if(usuario==null){
			throw new Exception("El cliente con id: "+transaccion.getUsuario().getUsuUsuario()+" No existe");
		}
		
		transaccionDAO.create(transaccion);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Transaccion transaccion) throws Exception {
		if(transaccion==null){
			throw new Exception("El cuenta no puede ser nulo");
		}
		
		validar(transaccion);
	
		Usuario usuario = usuarioDAO.find(transaccion.getUsuario().getUsuUsuario());
		if(usuario==null){
			throw new Exception("El cliente con id: "+transaccion.getUsuario().getUsuUsuario()+" No existe");
		}
		
		transaccionDAO.update(transaccion);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Transaccion transaccion) throws Exception {
		if(transaccion==null){
			throw new Exception("La cuenta no puede ser nulo");
		}
			
		transaccionDAO.delete(transaccion);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(long id) throws Exception {

		Transaccion entity = find(id);

		if(entity==null){
			throw new Exception("La cuenta con id: "+id+" No existe");
		}
		transaccionDAO.delete(entity);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Transaccion find(long id) {
		return transaccionDAO.find(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Transaccion> findAll() {
		return transaccionDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Transaccion> findAllCuenta(String cuenta) {
		try {
			return transaccionDAO.findAllCuenta(cuenta);
		} catch (Exception e) {
			return null;
		}
	}

}
