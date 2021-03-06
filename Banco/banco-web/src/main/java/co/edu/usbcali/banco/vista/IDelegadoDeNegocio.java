package co.edu.usbcali.banco.vista;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.CuentaRegistrada;
import co.edu.usbcali.banco.modelo.TipoDocumento;
import co.edu.usbcali.banco.modelo.TipoTransaccion;
import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Transaccion;
import co.edu.usbcali.banco.modelo.Usuario;

public interface IDelegadoDeNegocio {
	//cliente
	public void createCliente(Cliente cliente) throws Exception;
	public void updateCliente(Cliente cliente) throws Exception;
	public void deleteCliente(BigDecimal id) throws Exception;	
	public Cliente findCliente(BigDecimal id);
	public List<Cliente> findAllCliente();
	//tipodocumento
	public void createTipoDocumento(TipoDocumento tipoDocumento) throws Exception;
	public void updateTipoDocumento(TipoDocumento tipoDocumento) throws Exception;
	public void deleteTipoDocumento(TipoDocumento tipoDocumento) throws Exception;	
	public TipoDocumento findTipoDocumento(Long id);
	public List<TipoDocumento> findAllTipoDocumento();
	//usuario
	public void createUsuario(Usuario usuario) throws Exception;
	public void updateUsuario(Usuario usuario) throws Exception;
	public void deleteUsuario(String id) throws Exception;	
	public Usuario findUsuario(String id);
	public List<Usuario> findAllUsuario();
	public Usuario loginUsuario(String id,String pass) throws Exception;
	//tipo usuario
	public void createTipoUsuario(TipoUsuario tipoUsuario) throws Exception;
	public void updateTipoUsuario(TipoUsuario tipoUsuario) throws Exception;
	public void deleteTipoUsuario(TipoUsuario tipoUsuario) throws Exception;	
	public TipoUsuario findTipoUsuario(Long id);
	public List<TipoUsuario> findAllTipoUsuario();
	//cuenta
	public void createCuenta(Cuenta cuenta)throws Exception;
	public void updateCuenta(Cuenta cuenta)throws Exception;	
	public void deleteCuenta(String id)throws Exception;	
	public Cuenta findCuenta(String id);
	public List<Cuenta> findAllCuenta();
	public List<Cuenta> findAllClienteCuenta(BigDecimal idCliente);
	//Transaccion
	public void createTransaccion(Transaccion transaccion)throws Exception;
	public void updateTransaccion(Transaccion transaccion)throws Exception;	
	public void deleteTransaccion(long id)throws Exception;	
	public Transaccion findTransaccion(long id);
	public List<Transaccion> findAllTransaccion();
	//tipo de transaccion
	public void createTipoTransaccion(TipoTransaccion tipoTransaccion)throws Exception;
	public void updateTipoTransaccion(TipoTransaccion tipoTransaccion)throws Exception;	
	public void deleteTipoTransaccion(long id)throws Exception;	
	public TipoTransaccion findTipoTransaccion(long id);
	public List<TipoTransaccion> findAllTipoTransaccion();
	//TransaccionBanco
	public Cuenta retirarTransaccionBanco(String usuUsuario,String cuenId,BigDecimal clieId,BigDecimal valorRetiro)throws Exception;
	public Cuenta consignarTransaccionBanco(String usuUsuario,String cuenId,BigDecimal clieId,BigDecimal valorRetiro)throws Exception;
	public Cuenta transferenciaTransaccionBanco(String usuUsuario,String cuenIdOrigen,String cuenIdDestino,BigDecimal clieIdOrigen,BigDecimal clieIdDestino,BigDecimal valor)throws Exception;
	//nuevas
	public TipoDocumento findNameTipoDocumento(String nombre);
	public TipoTransaccion findNameTipoTransaccion(String nombre);
	public TipoUsuario findNameTipoUsuario(String nombre);
	public List<Transaccion> findAllCuentaTransaccion(String cuenta);
	//cuenta registradas
	public void createCuentaRegistrada(CuentaRegistrada cuentaRegistrada)throws Exception;
	public void updateCuentaRegistrada(CuentaRegistrada cuentaRegistrada)throws Exception;	
	public void deleteCuentaRegistrada(long id)throws Exception;	
	public CuentaRegistrada findCuentaRegistrada(long id);
	public List<CuentaRegistrada> findAllCuentaRegistrada();
	public List<CuentaRegistrada> findClienteCuentaRegistrada(BigDecimal clieId);
	public CuentaRegistrada findClienteCuentaCuentaRegistrada(String cuenId,BigDecimal clieId);
	public CuentaRegistrada registrarCuentaRegistrada(long tipoDocumento,BigDecimal clieId,String cuenId,BigDecimal clieReg)throws Exception;
	public List<CuentaRegistrada> findClienteOnlyCuentaRegistrada(BigDecimal clieId);
	public Cliente loginCliente(BigDecimal clieId,String cuenId,String pass)throws Exception;
}
