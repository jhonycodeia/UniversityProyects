package co.edu.usbcali.banco.vista;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import co.edu.usbcali.banco.logica.IClienteLogica;
import co.edu.usbcali.banco.logica.ICuentaLogica;
import co.edu.usbcali.banco.logica.ICuentaRegistradaLogica;
import co.edu.usbcali.banco.logica.ITipoDocumentoLogica;
import co.edu.usbcali.banco.logica.ITipoTransaccionLogica;
import co.edu.usbcali.banco.logica.ITipoUsuarioLogica;
import co.edu.usbcali.banco.logica.ITransaccionBanco;
import co.edu.usbcali.banco.logica.ITransaccionLogica;
import co.edu.usbcali.banco.logica.IUsuarioLogica;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.CuentaRegistrada;
import co.edu.usbcali.banco.modelo.TipoDocumento;
import co.edu.usbcali.banco.modelo.TipoTransaccion;
import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Transaccion;
import co.edu.usbcali.banco.modelo.Usuario;

@Component("delegadoDeNegocio")
@Scope("singleton")
public class DelegadoDeNegocio implements IDelegadoDeNegocio {
	
	@Autowired
	private IClienteLogica clienteLogica;
	@Autowired
	private ITipoDocumentoLogica tipoDocumentoLogica;
	@Autowired
	private IUsuarioLogica usuarioLogica;
	@Autowired
	private ITipoUsuarioLogica tipoUsuarioLogica;
	@Autowired
	private ICuentaLogica cuentaLogica;
	@Autowired
	private ITransaccionLogica transaccionLogica;
	@Autowired
	private ITipoTransaccionLogica tipoTransaccionLogica;
	@Autowired
	private ITransaccionBanco transaccionBanco;
	@Autowired
	private ICuentaRegistradaLogica cuentaRegistradaLogica;

	
	/*							Cliente 						*/	
	
	@Override
	public void createCliente(Cliente cliente) throws Exception {
		clienteLogica.create(cliente);

	}

	@Override
	public void updateCliente(Cliente cliente) throws Exception {
		clienteLogica.update(cliente);

	}

	@Override
	public void deleteCliente(BigDecimal id) throws Exception {
		clienteLogica.delete(id);

	}

	@Override
	public Cliente findCliente(BigDecimal id) {
		return clienteLogica.find(id);
	}

	@Override
	public List<Cliente> findAllCliente() {
		return clienteLogica.findAll();
		
	}

	
/*							Tipo de Documento 								*/	
	
	@Override
	public void createTipoDocumento(TipoDocumento tipoDocumento) throws Exception {
		tipoDocumentoLogica.create(tipoDocumento);
	}

	@Override
	public void updateTipoDocumento(TipoDocumento tipoDocumento) throws Exception {
		tipoDocumentoLogica.update(tipoDocumento);

	}

	@Override
	public void deleteTipoDocumento(TipoDocumento tipoDocumento) throws Exception {
		tipoDocumentoLogica.delete(tipoDocumento);

	}

	@Override
	public TipoDocumento findTipoDocumento(Long id) {
		
		return tipoDocumentoLogica.find(id);
	}

	@Override
	public List<TipoDocumento> findAllTipoDocumento() {
		
		return tipoDocumentoLogica.findAll();
	}

	/*						Usuario 							*/		
	
	@Override
	public void createUsuario(Usuario usuario) throws Exception {
		usuarioLogica.create(usuario);
		
	}

	@Override
	public void updateUsuario(Usuario usuario) throws Exception {
		usuarioLogica.update(usuario);
		
	}

	@Override
	public void deleteUsuario(String id) throws Exception {
		usuarioLogica.delete(id);
		
	}

	@Override
	public Usuario findUsuario(String id) {
		return usuarioLogica.find(id);
	}

	@Override
	public List<Usuario> findAllUsuario() {
		return usuarioLogica.findAll();
	}
	
	@Override
	public Usuario loginUsuario(String id,String pass) throws Exception {
		return usuarioLogica.login(id, pass);
	}
	
	
	/*						Tipo de Usuario 							*/	

	@Override
	public void createTipoUsuario(TipoUsuario tipoUsuario) throws Exception {
		tipoUsuarioLogica.create(tipoUsuario);
		
	}

	@Override
	public void updateTipoUsuario(TipoUsuario tipoUsuario) throws Exception {
		tipoUsuarioLogica.update(tipoUsuario);
		
	}

	@Override
	public void deleteTipoUsuario(TipoUsuario tipoUsuario) throws Exception {
		tipoUsuarioLogica.delete(tipoUsuario);
		
	}

	@Override
	public TipoUsuario findTipoUsuario(Long id) {
		return tipoUsuarioLogica.find(id);
	}

	@Override
	public List<TipoUsuario> findAllTipoUsuario() {
		return tipoUsuarioLogica.findAll();
	}

	/*						cuenta 							*/	
	@Override
	public void createCuenta(Cuenta cuenta) throws Exception {
		cuentaLogica.create(cuenta);
		
	}

	@Override
	public void updateCuenta(Cuenta cuenta) throws Exception {
		cuentaLogica.update(cuenta);
		
	}

	@Override
	public void deleteCuenta(String id) throws Exception {
		cuentaLogica.delete(id);
		
	}

	@Override
	public Cuenta findCuenta(String id) {
		return cuentaLogica.find(id);
	}

	@Override
	public List<Cuenta> findAllCuenta() {
		return cuentaLogica.findAll();
	}

	@Override
	public List<Cuenta> findAllClienteCuenta(BigDecimal idCliente) {
		return cuentaLogica.findAllCliente(idCliente);
	}
	
	
	/*							Transaccion						*/	
	@Override
	public void createTransaccion(Transaccion transaccion) throws Exception {
		transaccionLogica.create(transaccion);
		
	}

	@Override
	public void updateTransaccion(Transaccion transaccion) throws Exception {
		transaccionLogica.update(transaccion);
		
	}

	@Override
	public void deleteTransaccion(long id) throws Exception {
		transaccionLogica.delete(id);
		
	}

	@Override
	public Transaccion findTransaccion(long id) {
		return transaccionLogica.find(id);
	}

	@Override
	public List<Transaccion> findAllTransaccion() {
		return transaccionLogica.findAll();
	}

	@Override
	public void createTipoTransaccion(TipoTransaccion tipoTransaccion) throws Exception {
		tipoTransaccionLogica.create(tipoTransaccion);
		
	}
	
	/*					Tipo Transaccion						*/	
	@Override
	public void updateTipoTransaccion(TipoTransaccion tipoTransaccion) throws Exception {
		tipoTransaccionLogica.update(tipoTransaccion);
		
	}

	@Override
	public void deleteTipoTransaccion(long id) throws Exception {
		tipoTransaccionLogica.delete(id);
		
	}

	@Override
	public TipoTransaccion findTipoTransaccion(long id) {
		return tipoTransaccionLogica.find(id);
	}

	@Override
	public List<TipoTransaccion> findAllTipoTransaccion() {
		return tipoTransaccionLogica.findAll();
	}
	/*					Transaccion	Banco				*/

	@Override
	public Cuenta retirarTransaccionBanco(String usuUsuario, String cuenId, BigDecimal clieId, BigDecimal valorRetiro)
			throws Exception {
		return transaccionBanco.retirar(usuUsuario, cuenId, clieId, valorRetiro);
	}

	@Override
	public Cuenta consignarTransaccionBanco(String usuUsuario, String cuenId, BigDecimal clieId, BigDecimal valorRetiro)
			throws Exception {
		return transaccionBanco.consignar(usuUsuario, cuenId, clieId, valorRetiro);
	}

	@Override
	public Cuenta transferenciaTransaccionBanco(String usuUsuario, String cuenIdOrigen, String cuenIdDestino,
			BigDecimal clieIdOrigen, BigDecimal clieIdDestino, BigDecimal valor) throws Exception {
		return transaccionBanco.transferencia(usuUsuario, cuenIdOrigen, cuenIdDestino, clieIdOrigen, clieIdDestino, valor);
	}

	@Override
	public TipoDocumento findNameTipoDocumento(String nombre) {
		return tipoDocumentoLogica.findName(nombre);
	}

	@Override
	public TipoTransaccion findNameTipoTransaccion(String nombre) {
		return tipoTransaccionLogica.findName(nombre);
	}

	@Override
	public TipoUsuario findNameTipoUsuario(String nombre) {
		return tipoUsuarioLogica.findName(nombre);
	}

	@Override
	public List<Transaccion> findAllCuentaTransaccion(String cuenta) {
		return transaccionLogica.findAllCuenta(cuenta);
	}
	
	//Cuenta registrada
	@Override
	public void createCuentaRegistrada(CuentaRegistrada cuentaRegistrada) throws Exception {
		cuentaRegistradaLogica.create(cuentaRegistrada);		
	}

	@Override
	public void updateCuentaRegistrada(CuentaRegistrada cuentaRegistrada) throws Exception {
		cuentaRegistradaLogica.update(cuentaRegistrada);		
	}

	@Override
	public void deleteCuentaRegistrada(long id) throws Exception {
		cuentaRegistradaLogica.delete(id);		
	}

	@Override
	public CuentaRegistrada findCuentaRegistrada(long id) {
		return cuentaRegistradaLogica.find(id);
	}

	@Override
	public List<CuentaRegistrada> findAllCuentaRegistrada() {
		return cuentaRegistradaLogica.findAll();
	}

	@Override
	public List<CuentaRegistrada> findClienteCuentaRegistrada(BigDecimal clieId) {
		return cuentaRegistradaLogica.findCliente(clieId);
	}

	@Override
	public CuentaRegistrada findClienteCuentaCuentaRegistrada(String cuenId, BigDecimal clieId) {
		return cuentaRegistradaLogica.findClienteCuenta(cuenId, clieId);
	}

	@Override
	public CuentaRegistrada registrarCuentaRegistrada(long tipoDocumento, BigDecimal clieId, String cuenId,BigDecimal clieReg)
			throws Exception {
		return transaccionBanco.registrarCuenta(tipoDocumento, clieId, cuenId,clieReg);
	}

	@Override
	public List<CuentaRegistrada> findClienteOnlyCuentaRegistrada(BigDecimal clieId) {
		return cuentaRegistradaLogica.findClienteOnly(clieId);
	}

	@Override
	public Cliente loginCliente(BigDecimal clieId, String cuenId, String pass) throws Exception {
		return clienteLogica.login(clieId, cuenId, pass);
	}	

}
