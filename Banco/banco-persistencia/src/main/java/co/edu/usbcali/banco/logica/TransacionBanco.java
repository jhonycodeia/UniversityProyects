package co.edu.usbcali.banco.logica;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.CuentaRegistrada;
import co.edu.usbcali.banco.modelo.Transaccion;
import co.edu.usbcali.banco.modelo.Usuario;

@Service
@Scope("singleton")
public class TransacionBanco implements ITransaccionBanco {

	@Autowired
	private IClienteLogica clienteLogica;

	@Autowired
	private ICuentaLogica cuentaLogica;

	@Autowired
	private ITransaccionLogica transaccionLogica;

	@Autowired
	private IUsuarioLogica usuarioLogica;

	@Autowired
	private ITipoTransaccionLogica tipoTransaccionLogica;

	@Autowired
	private ICuentaRegistradaLogica cuentaRegistradaLogica;

	@Transactional(readOnly = true)
	private void validadDatos(String usuUsuario, String cuenId, BigDecimal clieId, BigDecimal valor, String message)
			throws Exception {

		if (usuUsuario == null || usuUsuario.trim().isEmpty())
			throw new Exception(message + ": El id usuario no es valido");
		if (cuenId == null || cuenId.trim().isEmpty())
			throw new Exception(message + ": El id cuenta no es valido");
		if (clieId == null)
			throw new Exception(message + ": El id cliente no es valido");
		if (valor == null)
			throw new Exception(message + ": El valor retirar no es valido");
		if (valor.doubleValue() <= 0)
			throw new Exception(message + ": El valor debe ser mayor a 0");

		Usuario usuario = usuarioLogica.find(usuUsuario);
		Cuenta cuenta = cuentaLogica.find(cuenId);
		Cliente cliente = clienteLogica.find(clieId);

		if (usuario == null)
			throw new Exception(message + ": Usuario no existe");
		if (cliente == null)
			throw new Exception(message + ": cliente no existe");
		if (cuenta == null)
			throw new Exception(message + ": Cuenta no existe");
		if (cuenta.getActiva() != 'S' && !message.equals("CONSIGNACION"))
			throw new Exception(message + ": Cuenta " + cuenta.getCuenId() + " no esta activada");
		if (usuario.getActivo() != 'S')
			throw new Exception(message + ": Usuario " + usuario.getUsuUsuario() + " no esta activada");
		if (cliente.getActivo() != 'S')
			throw new Exception(message + ": Cliente " + cliente.getClieId() + " no esta activada");
		if (cuenta.getCliente().getClieId().intValue() != cliente.getClieId().intValue())
			throw new Exception(message + ": Cuenta " + cuenta.getCuenId() + " no tiene ese cliente "
					+ cliente.getClieId() + " asociado");		
		if(usuario.getTipoUsuario().getTiusId()!=1L) 
			throw new Exception(message + ": Solo el cajero puede realizar esta accion");
		 

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Cuenta retirar(String usuUsuario, String cuenId, BigDecimal clieId, BigDecimal valor) throws Exception {

		validadDatos(usuUsuario, cuenId, clieId, valor, "RETIRO");

		Cuenta cuenta = cuentaLogica.find(cuenId);

		if (valor.doubleValue() > cuenta.getSaldo().doubleValue())
			throw new Exception("Cuenta Tiene saldo insuficiente");

		Transaccion transacion = new Transaccion();
		transacion.setCuenta(cuenta);
		transacion.setFecha(new Date());
		transacion.setUsuario(usuarioLogica.find(usuUsuario));
		transacion.setValor(valor);
		transacion.setTipoTransaccion(tipoTransaccionLogica.find(1L));

		transaccionLogica.create(transacion);

		cuenta.setSaldo(new BigDecimal(cuenta.getSaldo().doubleValue() - valor.doubleValue()));
		cuentaLogica.update(cuenta);

		return cuenta;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Cuenta consignar(String usuUsuario, String cuenId, BigDecimal clieId, BigDecimal valor) throws Exception {

		validadDatos(usuUsuario, cuenId, clieId, valor, "CONSIGNACION");

		Cuenta cuenta = cuentaLogica.find(cuenId);

		Transaccion transacion = new Transaccion();
		transacion.setCuenta(cuenta);
		transacion.setFecha(new Date());
		transacion.setUsuario(usuarioLogica.find(usuUsuario));
		transacion.setValor(valor);
		transacion.setTipoTransaccion(tipoTransaccionLogica.find(2L));

		transaccionLogica.create(transacion);

		cuenta.setSaldo(new BigDecimal(cuenta.getSaldo().doubleValue() + valor.doubleValue()));
		if(cuenta.getActiva()=='N' && valor.doubleValue()<200000)
			throw new Exception("Para activar cuenta debe consignar minimo 200000");
		
		if(cuenta.getActiva()=='N' && cuenta.getSaldo().doubleValue()>=(200000))
			cuenta.setActiva('S');
		
		cuentaLogica.update(cuenta);

		return cuenta;

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Cuenta transferencia(String usuUsuario, String cuenIdOrigen, String cuenIdDestino, BigDecimal clieIdOrigen,
			BigDecimal clieIdDestino, BigDecimal valor) throws Exception {

		/*
		 * insert into cliente values(0,'Jhony Sarria','Cra 23A
		 * #24-90','3104965892','jhonymaster@gmail.com','S',1); insert into cuenta
		 * values('9999-9999-9999-9999',0,'12345','S',0);
		 */

		validadDatos(usuUsuario, cuenIdOrigen, clieIdOrigen, valor, "TRASFERENCIA ORIGEN");
		validadDatos(usuUsuario, cuenIdDestino, clieIdDestino, valor, "TRASFERENCIA DESTINO");
			
		
		
		if (cuenIdOrigen.equals(cuenIdDestino))
			throw new Exception("Las cuentas no pueden ser iguales");
		if (valor.doubleValue() > (cuentaLogica.find(cuenIdOrigen).getSaldo().doubleValue() + 900))
			throw new Exception("Cuenta Tiene saldo insuficiente");
		/*
		 * if(cuentaRegistradaLogica.find(cuenIdOrigen)==null) throw new
		 * Exception("Cuenta no esta registrada");
		 */

		retirar(usuUsuario, cuenIdOrigen, clieIdOrigen, valor);
		Cuenta cuenta = consignar(usuUsuario, cuenIdDestino, clieIdDestino, valor);

		Transaccion transacion = new Transaccion();
		transacion.setCuenta(cuentaLogica.find(cuenIdDestino));
		transacion.setFecha(new Date());
		transacion.setUsuario(usuarioLogica.find(usuUsuario));
		transacion.setValor(valor);
		transacion.setTipoTransaccion(tipoTransaccionLogica.find(3L));		

		transaccionLogica.create(transacion);

		retirar(usuUsuario, cuenIdOrigen, clieIdOrigen, new BigDecimal(900));
		consignar(usuUsuario, "9999-9999-9999-9999", new BigDecimal(0), new BigDecimal(900));

		return cuenta;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public CuentaRegistrada registrarCuenta(long tipoDocumento, BigDecimal clieId, String cuenId,BigDecimal clieReg) throws Exception {
		
		if(tipoDocumento<=0L)
			throw new Exception("Tipo Documento Invalido");
		if(clieId==null)
			throw new Exception("Cliente no es valido");
		if(cuenId==null || cuenId.isEmpty())
			throw new Exception("Cuenta no es valida");
		
		Cliente cliente = clienteLogica.find(clieId);
		Cliente clienteRegistra = clienteLogica.find(clieReg);
		Cuenta cuenta = cuentaLogica.find(cuenId);
		CuentaRegistrada cuentaRegistrada = cuentaRegistradaLogica.findClienteCuenta(cuenId, clieReg);
		
		if(cliente==null)
			throw new Exception("Cliente no existe");
		if(clienteRegistra==null)
			throw new Exception("Cliente registrar no existe");
		if(cuenta==null)
			throw new Exception("Cuenta no existe");
		if(cuenta.getActiva()!='S')
			throw new Exception("Las cuenta no esta activa");
		if(cuenta.getCliente().getClieId()!=cliente.getClieId())
			throw new Exception("Las cuenta no es de ese cliente");
		if(cuentaRegistrada!=null)
			throw new Exception("Las cuenta ya esta registrada");
		if(cliente.getTipoDocumento().getTdocId()!=tipoDocumento)
			throw new Exception("Los documentos no coinciden");
		
		CuentaRegistrada entity = new CuentaRegistrada();
		entity.setCliente(clienteRegistra);
		entity.setCuenta(cuenta);
		
		cuentaRegistradaLogica.create(entity);
		
		return entity;
	}

}
