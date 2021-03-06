package co.edu.usbcali.banco.dao;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.banco.modelo.CuentaRegistrada;


public interface ICuentaRegistradaDAO {

	public void create(CuentaRegistrada cuentaRegistrada);
	public void update(CuentaRegistrada cuentaRegistrada);
	public void delete(CuentaRegistrada cuentaRegistrada);
	public void delete(long id);	
	public CuentaRegistrada find(long id);
	public List<CuentaRegistrada> findAll();
	public List<CuentaRegistrada> findCliente(BigDecimal clieId);
	public CuentaRegistrada findClienteCuenta(String cuenId,BigDecimal clieId);
	public List<CuentaRegistrada> findClienteOnly(BigDecimal clieId);
}
