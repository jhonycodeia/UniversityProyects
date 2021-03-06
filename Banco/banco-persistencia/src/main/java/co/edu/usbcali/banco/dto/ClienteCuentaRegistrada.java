package co.edu.usbcali.banco.dto;

import java.math.BigDecimal;

public class ClienteCuentaRegistrada {

	private String cuenId;
	private String nombreCliente;
	private BigDecimal clieId;

	public ClienteCuentaRegistrada(String cuenId, String nombreCliente, BigDecimal clieId) {
		super();
		this.cuenId = cuenId;
		this.nombreCliente = nombreCliente;
		this.clieId = clieId;
	}

	public String getCuenId() {
		return cuenId;
	}

	public void setCuenId(String cuenId) {
		this.cuenId = cuenId;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public BigDecimal getClieId() {
		return clieId;
	}

	public void setClieId(BigDecimal clieId) {
		this.clieId = clieId;
	}

	public String toString() {
		return cuenId + " " + nombreCliente + " " + clieId;
	}

}
