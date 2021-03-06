package co.edu.usbcali.banco.dto;

import java.math.BigDecimal;

public class ClienteCuenta {
	private BigDecimal clieId;
	private String nombre;
	private BigDecimal saldoTotal;
	public BigDecimal getClieId() {
		return clieId;
	}
	public void setClieId(BigDecimal clieId) {
		this.clieId = clieId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getSaldoTotal() {
		return saldoTotal;
	}
	public void setSaldoTotal(BigDecimal saldoTotal) {
		this.saldoTotal = saldoTotal;
	}
	public ClienteCuenta(BigDecimal clieId, String nombre, BigDecimal saldoTotal) {
		super();
		this.clieId = clieId;
		this.nombre = nombre;
		this.saldoTotal = saldoTotal;
	}

	
}
