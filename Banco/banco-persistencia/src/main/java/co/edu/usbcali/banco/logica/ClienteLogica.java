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
import co.edu.usbcali.banco.dao.ICuentaDAO;
import co.edu.usbcali.banco.dao.ITipoDocumentoDAO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.TipoDocumento;

@Service
@Scope("singleton")
public class ClienteLogica implements IClienteLogica {
	
	@Autowired
	private IClienteDAO clienteDAO;
	
	@Autowired
	private ITipoDocumentoDAO tipoDocumentoDAO;
	
	@Autowired
	private ICuentaDAO cuentaDAO;

	@Autowired
	private Validator validator;
	
	private void validarClientes(Cliente cliente) throws Exception {
	    try {
	        Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Cliente> constraintViolation : constraintViolations) {
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
	public void create(Cliente cliente) throws Exception {
		if(cliente==null){
			throw new Exception("El cliente no puede ser nulo");
		}
		
		validarClientes(cliente);
		
		Cliente entity=clienteDAO.find(cliente.getClieId());
		if(entity!=null){
			throw new Exception("El cliente con id: "+entity.getClieId()+" Ya existe");
		}
		
		if(cliente.getActivo()=='Z')
			throw new Exception("Activo no es valido");
			
		TipoDocumento tipoDocumento=tipoDocumentoDAO.find(cliente.getTipoDocumento().getTdocId());
		if(tipoDocumento==null){
			throw new Exception("El tipo de documento con id: "+cliente.getTipoDocumento().getTdocId()+" No existe");
		}
		
		clienteDAO.create(cliente);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Cliente cliente) throws Exception {
		if(cliente==null){
			throw new Exception("El cliente no puede ser nulo");
		}
		
		validarClientes(cliente);
	
		if(cliente.getActivo()=='Z')
			throw new Exception("Activo no es valido");
		
		TipoDocumento tipoDocumento=tipoDocumentoDAO.find(cliente.getTipoDocumento().getTdocId());
		if(tipoDocumento==null){
			throw new Exception("El tipo de documento con id: "+cliente.getTipoDocumento().getTdocId()+" No existe");
		}
		
		clienteDAO.update(cliente);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Cliente cliente) throws Exception {
		if(cliente==null){
			throw new Exception("El cliente no puede ser nulo");
		}
		if(cliente.getClieId()==null){
			throw new Exception("La identificaciï¿½n no puede ser nula");
		}		
		clienteDAO.delete(cliente);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(BigDecimal id) throws Exception {
		Cliente entity=clienteDAO.find(id);
		if(entity==null){
			throw new Exception("El cliente con id: "+id+" No existe");
		}
		clienteDAO.delete(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente find(BigDecimal id) {
		return clienteDAO.find(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return clienteDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente login(BigDecimal clieId, String cuenId, String pass) throws Exception {
		if(clieId==null)
			throw new Exception("Cliente no valido");
		if(cuenId==null || cuenId.isEmpty())
			throw new Exception("Cuenta no valida");
		
		Cliente cliente = clienteDAO.find(clieId);
		Cuenta cuenta = cuentaDAO.find(cuenId);
		
		if(cliente==null)
			throw new Exception("Cliente no existe");
		if(cuenta==null)
			throw new Exception("Cuenta no existe");
		if(cliente.getActivo()!='S')
			throw new Exception("Cliente no esta Activo");
		if(cliente.getClieId().intValue()!=cuenta.getCliente().getClieId().intValue())
			throw new Exception("Cuenta no es suya");
		if(cuenta.getActiva()!='S')
			throw new Exception("La cuenta no esta Activo");
		if(cuenta.getClave().equals(pass))
			return cliente;
		else
			throw new Exception("Contraseña invalida");
		
	}

}
