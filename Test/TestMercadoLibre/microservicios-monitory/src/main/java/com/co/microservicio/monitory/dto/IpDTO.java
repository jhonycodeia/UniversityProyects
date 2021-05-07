package com.co.microservicio.monitory.dto;

import java.util.Date;

import com.co.microservicio.monitory.model.Ip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class IpDTO {

	private String ip;
	private Date fecha;
	private String pais;
	private String codeISO;
	private String distancia;
	private Boolean amazon;
	
	public IpDTO(Ip ip) {
		this.ip = ip.getIp();
		this.fecha = ip.getFecha()==null ? new Date():ip.getFecha();
		this.pais = ip.getPais();
		this.codeISO = ip.getCodeISO();
		this.distancia = ip.getDistancia()+ " Km";
		this.amazon = ip.getAmazon();
	}
}
