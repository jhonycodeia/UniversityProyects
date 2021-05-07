package com.co.microservicio.monitory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.microservicio.monitory.clientes.IpClienteRest;
import com.co.microservicio.monitory.dto.CountryDTO;
import com.co.microservicio.monitory.dto.IpDTO;
import com.co.microservicio.monitory.dto.ResultadoDTO;
import com.co.microservicio.monitory.model.Ip;
import com.co.microservicio.monitory.repository.IpRepository;
import com.co.microservicio.monitory.service.commons.CommonServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IpServiceImpl extends CommonServiceImpl<Ip,IpRepository> implements IpService {

	@Autowired
	private IpClienteRest ipClienteRestImpl;

	@Override
	@Transactional
	public IpDTO monitory(String ip) throws Exception {		
		Optional<Ip> entity = repository.findById(ip);
		if (entity.isEmpty()) {
			CountryDTO country = ipClienteRestImpl.findCountry(ip);
			
			log.info("Se consulto la ip "+country);
			boolean amazon = ipClienteRestImpl.findAmazon(ip);
			double distance = ipClienteRestImpl.distance(country.getCountryCode());
			
			log.info("Se consulto amazon "+amazon);
			log.info("Se consulto la distancia es "+distance+ " km");
			
			entity = Optional.of(Ip.builder()
					.ip(ip)
					.pais(country.getCountryName())
					.codeISO(country.getCountryCode())
					.distancia(distance)
					.amazon(amazon).build());
			
			repository.save(entity.get());
		}
		else {
			entity.get().setInvocaciones((entity.get().getInvocaciones()+1));
			repository.save(entity.get());
		}
		
		return new IpDTO(entity.get());
	}

	@Override
	@Transactional(readOnly = true)
	public List<ResultadoDTO> resultados() {
		return repository.resultados();
	}

}
