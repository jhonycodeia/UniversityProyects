package co.edu.usbcali.banco.logica;

import java.math.BigDecimal;
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
import co.edu.usbcali.banco.dao.ITipoUsuarioDAO;
import co.edu.usbcali.banco.dao.IUsuarioDAO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Usuario;

@Service
@Scope("singleton")
public class CuentaLogica implements ICuentaLogica {

	@Autowired
	private ICuentaDAO cuentaDAO ;
	
	@Autowired
	private IClienteDAO clienteDAO;

	@Autowired
	private Validator validator;
	
	private void validar(Cuenta cuenta) throws Exception {
	    try {
	        Set<ConstraintViolation<Cuenta>> constraintViolations = validator.validate(cuenta);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Cuenta> constraintViolation : constraintViolations) {
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
	public void create(Cuenta cuenta) throws Exception {
		if(cuenta==null){
			throw new Exception("El cuenta no puede ser nulo");
		}
		
		validar(cuenta);
		
		Cliente cliente = clienteDAO.find(cuenta.getCliente().getClieId());
		
		if(cliente==null){
			throw new Exception("El cliente con id: "+cuenta.getCliente().getClieId()+" No existe");
		}	
	
		
		cuentaDAO.create(cuenta);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Cuenta cuenta) throws Exception {
		if(cuenta==null){
			throw new Exception("El cuenta no puede ser nulo");
		}
		
		validar(cuenta);
	
		Cliente cliente = clienteDAO.find(cuenta.getCliente().getClieId());
		if(cliente==null){
			throw new Exception("El cliente con id: "+cuenta.getCliente().getClieId()+" No existe");
		}
		
		cuentaDAO.update(cuenta);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Cuenta cuenta) throws Exception {
		if(cuenta==null){
			throw new Exception("La cuenta no puede ser nulo");
		}
		if(cuenta.getCuenId()==null || cuenta.getCuenId().equals("")){
			throw new Exception("La identificaci�n no puede ser nula");
		}		
		cuentaDAO.delete(cuenta);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(String id) throws Exception {

		Cuenta entity = find(id);

		if(entity==null){
			throw new Exception("La cuenta con id: "+id+" No existe");
		}
		cuentaDAO.delete(entity);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Cuenta find(String id) {
		return cuentaDAO.find(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cuenta> findAll() {
		return cuentaDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cuenta> findAllCliente(BigDecimal idCliente) {
		return cuentaDAO.findAllCliente(idCliente);
	}

}
