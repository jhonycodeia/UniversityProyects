package com.co.microservicio.monitory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.co.microservicio.monitory.dto.ResultadoDTO;
import com.co.microservicio.monitory.model.Ip;

public interface IpRepository extends CrudRepository<Ip,String>{

	/**
	 * SELECT ip,
		pais,
		round(distancia) ,
		round(SELECT sum(invocaciones)/count(*), 
		FROM IPS  where ip.codeiso=codeiso) FROM IPS ip
	 * @return
	 */
	@Query("select new com.co.microservicio.monitory.dto.ResultadoDTO(ip.ip,ip.pais,round(ip.distancia),(select (sum(ips.invocaciones)/count(ips.ip)) from Ip ips where ips.codeISO=ip.codeISO)) from Ip ip")
	List<ResultadoDTO> resultados();
}
