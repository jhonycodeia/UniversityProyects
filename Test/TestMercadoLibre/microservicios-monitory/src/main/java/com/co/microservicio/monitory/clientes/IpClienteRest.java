package com.co.microservicio.monitory.clientes;

import com.co.microservicio.monitory.dto.CountryDTO;

public interface IpClienteRest {
	
	public CountryDTO findCountry(String ip);	

	public boolean findAmazon(String ip) throws Exception;
	
	public double distance(String iso)throws Exception;
	
}
