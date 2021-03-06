package co.edu.usbcali.banco.logica;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.banco.modelo.CuentaRegistrada;



public interface ICuentaRegistradaLogica {

	public void create(CuentaRegistrada cuentaRegistrada)throws Exception;
	public void update(CuentaRegistrada cuentaRegistrada)throws Exception;
	public void delete(CuentaRegistrada cuentaRegistrada)throws Exception;
	public void delete(long id)throws Exception;	
	public CuentaRegistrada find(long id);
	public List<CuentaRegistrada> findAll();
	public List<CuentaRegistrada> findCliente(BigDecimal clieId);
	public CuentaRegistrada findClienteCuenta(String cuenId,BigDecimal clieId);
	public List<CuentaRegistrada> findClienteOnly(BigDecimal clieId);
}
