package co.edu.usbcali.banco.dto;

import java.math.BigDecimal;

public class RetiroDTO {

	private String usuUsuario;
	private String cuenId;
	private BigDecimal clieId;
	private BigDecimal valor;
	
	public RetiroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RetiroDTO(String usuUsuario, String cuenId, BigDecimal clieId, BigDecimal valor) {
		super();
		this.usuUsuario = usuUsuario;
		this.cuenId = cuenId;
		this.clieId = clieId;
		this.valor = valor;
	}

	public String getUsuUsuario() {
		return usuUsuario;
	}

	public void setUsuUsuario(String usuUsuario) {
		this.usuUsuario = usuUsuario;
	}

	public String getCuenId() {
		return cuenId;
	}

	public void setCuenId(String cuenId) {
		this.cuenId = cuenId;
	}

	public BigDecimal getClieId() {
		return clieId;
	}

	public void setClieId(BigDecimal clieId) {
		this.clieId = clieId;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
