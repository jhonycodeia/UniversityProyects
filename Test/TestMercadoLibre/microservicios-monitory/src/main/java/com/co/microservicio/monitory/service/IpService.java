package com.co.microservicio.monitory.service;

import java.util.List;

import com.co.microservicio.monitory.dto.IpDTO;
import com.co.microservicio.monitory.dto.ResultadoDTO;
import com.co.microservicio.monitory.model.Ip;
import com.co.microservicio.monitory.service.commons.CommonService;

public interface IpService extends CommonService<Ip>{

	public IpDTO monitory(String ip)throws Exception;
	
	public List<ResultadoDTO> resultados();
}
