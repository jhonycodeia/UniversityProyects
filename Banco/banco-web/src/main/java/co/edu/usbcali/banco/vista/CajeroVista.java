package co.edu.usbcali.banco.vista;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.TipoDocumento;
import co.edu.usbcali.banco.modelo.Usuario;
import co.edu.usbcali.banco.util.FacesUtils;


@ViewScoped
@ManagedBean(name = "cajeroVista")
public class CajeroVista {
	
	@ManagedProperty("#{delegadoDeNegocio}")	
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	private String nombreUsuario;
	
	//consignacion	
	private InputText txtCuenta;
	private InputText txtIdentificacion;
	private InputText txtCuentaResult;
	private InputText txtSaldoResult;
	private InputText txtActivaResult;
	private InputNumber txtValor;	
	//retiro
	private InputText txtRCuenta;
	private InputText txtRIdentificacion;
	private InputText txtRCuentaResult;
	private InputText txtRSaldoResult;
	private InputText txtRActivaResult;
	private InputNumber txtRValor;
	
	public String limpiarConsignar() {
		
		txtCuentaResult.resetValue();
		txtSaldoResult.resetValue();
		txtActivaResult.resetValue();
		
		txtCuenta.resetValue();
		txtIdentificacion.resetValue();
		txtValor.resetValue();
		
		return "";
	}
	
public String limpiarRetiro() {
		
		txtRCuentaResult.resetValue();
		txtRSaldoResult.resetValue();
		txtRActivaResult.resetValue();
		
		txtRCuenta.resetValue();
		txtRIdentificacion.resetValue();
		txtRValor.resetValue();
		
		return "";
	}
	
	public String consignacionAction() {
		
		BigDecimal identificacion = null;
		BigDecimal valor = null;
		
		try {
			identificacion = new BigDecimal(txtIdentificacion.getValue().toString().trim());			
		} catch (Exception e) {
			identificacion = null;			
		}
		try {
			valor = new BigDecimal(txtValor.getValue().toString());
		} catch (Exception e) {
			valor = null;
		}
		
		try {
			Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
			String cuenId = txtCuenta.getValue().toString().trim();			
			
			
			Cuenta cuenta = delegadoDeNegocio.consignarTransaccionBanco(usuario.getUsuUsuario().toString(), cuenId,identificacion, valor);
			
						
			txtCuentaResult.setValue(cuenta.getCuenId());
			txtSaldoResult.setValue(cuenta.getSaldo());
			txtActivaResult.setValue(cuenta.getActiva());
			
			txtCuenta.resetValue();
			txtIdentificacion.resetValue();
			txtValor.resetValue();
			
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La consignacion a la cuenta "+cuenId+" de un valor de "+valor+" fue exitosa", ""));
			
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "";
	}
	
	public String retiroAction() {
		BigDecimal identificacion = null;
		BigDecimal valor = null;
		
		try {
			identificacion = new BigDecimal(txtRIdentificacion.getValue().toString().trim());			
		} catch (Exception e) {
			identificacion = null;			
		}
		try {
			valor = new BigDecimal(txtRValor.getValue().toString());
		} catch (Exception e) {
			valor = null;
		}
		try {
			Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
			String cuenId = txtRCuenta.getValue().toString().trim();			
			
			
			Cuenta cuenta = delegadoDeNegocio.retirarTransaccionBanco(usuario.getUsuUsuario().toString(), cuenId,identificacion, valor);
			
			txtRCuentaResult.setValue(cuenta.getCuenId());
			txtRSaldoResult.setValue(cuenta.getSaldo());
			txtRActivaResult.setValue(cuenta.getActiva());
			
			txtRCuenta.resetValue();
			txtRIdentificacion.resetValue();
			txtRValor.resetValue();
			
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,
					"El retiro a la cuenta "+cuenId+" de un valor de "+valor+" fue exitosa", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "";
	}
	public IDelegadoDeNegocio getDelegadoDeNegocio() {
		return delegadoDeNegocio;
	}

	public void setDelegadoDeNegocio(IDelegadoDeNegocio delegadoDeNegocio) {
		this.delegadoDeNegocio = delegadoDeNegocio;
	}

	public InputText getTxtCuenta() {
		return txtCuenta;
	}

	public void setTxtCuenta(InputText txtCuenta) {
		this.txtCuenta = txtCuenta;
	}

	public InputText getTxtIdentificacion() {
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(InputText txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
	}

	public InputNumber getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(InputNumber txtValor) {
		this.txtValor = txtValor;
	}
	public InputText getTxtCuentaResult() {
		return txtCuentaResult;
	}
	public void setTxtCuentaResult(InputText txtCuentaResult) {
		this.txtCuentaResult = txtCuentaResult;
	}
	public InputText getTxtSaldoResult() {
		return txtSaldoResult;
	}
	public void setTxtSaldoResult(InputText txtSaldoResult) {
		this.txtSaldoResult = txtSaldoResult;
	}
	public InputText getTxtActivaResult() {
		return txtActivaResult;
	}
	public void setTxtActivaResult(InputText txtActivaResult) {
		this.txtActivaResult = txtActivaResult;
	}

	public InputText getTxtRCuenta() {
		return txtRCuenta;
	}

	public void setTxtRCuenta(InputText txtRCuenta) {
		this.txtRCuenta = txtRCuenta;
	}

	public InputText getTxtRIdentificacion() {
		return txtRIdentificacion;
	}

	public void setTxtRIdentificacion(InputText txtRIdentificacion) {
		this.txtRIdentificacion = txtRIdentificacion;
	}

	public InputNumber getTxtRValor() {
		return txtRValor;
	}

	public void setTxtRValor(InputNumber txtRValor) {
		this.txtRValor = txtRValor;
	}

	public InputText getTxtRCuentaResult() {
		return txtRCuentaResult;
	}

	public void setTxtRCuentaResult(InputText txtRCuentaResult) {
		this.txtRCuentaResult = txtRCuentaResult;
	}

	public InputText getTxtRSaldoResult() {
		return txtRSaldoResult;
	}

	public void setTxtRSaldoResult(InputText txtRSaldoResult) {
		this.txtRSaldoResult = txtRSaldoResult;
	}

	public InputText getTxtRActivaResult() {
		return txtRActivaResult;
	}

	public void setTxtRActivaResult(InputText txtRActivaResult) {
		this.txtRActivaResult = txtRActivaResult;
	}

	public String getNombreUsuario() {
		Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
		nombreUsuario=usuario.getNombre();
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
