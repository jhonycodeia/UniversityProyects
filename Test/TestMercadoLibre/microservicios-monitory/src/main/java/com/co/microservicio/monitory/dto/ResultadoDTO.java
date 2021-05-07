package com.co.microservicio.monitory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultadoDTO {

	private String ip;
	private String pais;
	private Double distancia;
	private Double invocaciones;
}
