package co.edu.usbcali.banco.logica;

import java.math.BigDecimal;

import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.CuentaRegistrada;
import co.edu.usbcali.banco.modelo.Usuario;

public interface ITransaccionBanco {

	public Cuenta retirar(String usuUsuario,String cuenId,BigDecimal clieId,BigDecimal valorRetiro)throws Exception;
	public Cuenta consignar(String usuUsuario,String cuenId,BigDecimal clieId,BigDecimal valorRetiro)throws Exception;
	public Cuenta transferencia(String usuUsuario,String cuenIdOrigen,String cuenIdDestino,BigDecimal clieIdOrigen,BigDecimal clieIdDestino,BigDecimal valor)throws Exception;
	public CuentaRegistrada registrarCuenta(long tipoDocumento,BigDecimal clieId,String cuenId,BigDecimal clieReg)throws Exception;
}
