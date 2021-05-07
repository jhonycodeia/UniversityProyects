package com.co.microservicio.monitory.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ips")
@Builder
@ToString
public class Ip {
	
	@Id
	private String ip;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	private String pais;
	private String codeISO;
	private Double distancia;
	private Double invocaciones;
	private Boolean amazon;
	
	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
		this.invocaciones= 1.0;
	}

}
