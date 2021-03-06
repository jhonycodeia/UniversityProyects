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
import co.edu.usbcali.banco.dao.ICuentaRegistradaDAO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.CuentaRegistrada;

@Service
@Scope("singleton")
public class CuentaRegistradaLogica implements ICuentaRegistradaLogica {

	
	@Autowired
	private ICuentaDAO cuentaDAO ;
	
	@Autowired
	private IClienteDAO clienteDAO;
	
	@Autowired
	private ICuentaRegistradaDAO cuentaRegistradaDAO ;

	@Autowired
	private Validator validator;
	
	private void validar(CuentaRegistrada cuentaRegistrada) throws Exception {
	    try {
	        Set<ConstraintViolation<CuentaRegistrada>> constraintViolations = validator.validate(cuentaRegistrada);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<CuentaRegistrada> constraintViolation : constraintViolations) {
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
	public void create(CuentaRegistrada cuentaRegistrada) throws Exception {
		if(cuentaRegistrada==null){
			throw new Exception("El cuenta no puede ser nulo");
		}
		
		validar(cuentaRegistrada);
		
		Cliente cliente = clienteDAO.find(cuentaRegistrada.getCliente().getClieId());
		if(cliente==null){
			throw new Exception("El cliente con id: "+cuentaRegistrada.getCliente().getClieId()+" No existe");
		}
		
		Cuenta cuenta = cuentaDAO.find(cuentaRegistrada.getCuenta().getCuenId());
		if(cliente==null){
			throw new Exception("El cuenta con id: "+cuentaRegistrada.getCuenta().getCuenId()+" No existe");
		}	
		
		
		cuentaRegistradaDAO.create(cuentaRegistrada);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(CuentaRegistrada cuentaRegistrada) throws Exception {
		if(cuentaRegistrada==null){
			throw new Exception("El cuenta no puede ser nulo");
		}
		
		validar(cuentaRegistrada);
	
		Cliente cliente = clienteDAO.find(cuentaRegistrada.getCliente().getClieId());
		if(cliente==null){
			throw new Exception("El cliente con id: "+cuentaRegistrada.getCliente().getClieId()+" No existe");
		}
		
		Cuenta cuenta = cuentaDAO.find(cuentaRegistrada.getCuenta().getCuenId());
		if(cliente==null){
			throw new Exception("El cuenta con id: "+cuentaRegistrada.getCuenta().getCuenId()+" No existe");
		}
		
		cuentaRegistradaDAO.update(cuentaRegistrada);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(CuentaRegistrada cuentaRegistrada) throws Exception {
		if(cuentaRegistrada==null){
			throw new Exception("La cuenta no puede ser nulo");
		}
			
		cuentaRegistradaDAO.delete(cuentaRegistrada);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(long id) throws Exception {

		CuentaRegistrada entity = find(id);

		if(entity==null){
			throw new Exception("La cuentaregistrada con id: "+id+" No existe");
		}
		cuentaRegistradaDAO.delete(entity);
		
	}

	@Override
	@Transactional(readOnly=true)
	public CuentaRegistrada find(long id) {
		return cuentaRegistradaDAO.find(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CuentaRegistrada> findAll() {
		return cuentaRegistradaDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<CuentaRegistrada> findCliente(BigDecimal clieId) {
		try {
			return cuentaRegistradaDAO.findCliente(clieId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public CuentaRegistrada findClienteCuenta(String cuenId, BigDecimal clieId) {
		try {
			return cuentaRegistradaDAO.findClienteCuenta(cuenId, clieId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<CuentaRegistrada> findClienteOnly(BigDecimal clieId) {
		try {
			return cuentaRegistradaDAO.findClienteOnly(clieId);
		} catch (Exception e) {
			return null;
		}
	}

	

	

}
