package co.edu.usbcali.banco.rest.cliente;

import java.math.BigDecimal;

import org.springframework.web.client.RestTemplate;

import co.edu.usbcali.banco.dto.ClienteDTO;
import co.edu.usbcali.banco.dto.RetiroDTO;

public class OperacionesCliente {
	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();

		/* test find		 
		 
		 Resultado resultado = restTemplate
				.getForObject("http://localhost:9095/banco-web/controller/operaciones/restar/3/7", Resultado.class);

		System.out.println(resultado.getValor());

		resultado = restTemplate.getForObject("http://localhost:9095/banco-web/controller/operaciones/sumar/3/7",
				Resultado.class);

		System.out.println(resultado.getValor());*/
		
		/* test create
		ClienteDTO clienteDTO = new ClienteDTO();
		
		clienteDTO.setActivo('S');
		clienteDTO.setClieId(new BigDecimal(114403242));
		clienteDTO.setDireccion("Cra 33E #22-90");
		clienteDTO.setEmail("sandoval@gmail.com");
		clienteDTO.setNombre("Diego gomez sandoval");
		clienteDTO.setTdocId(1);
		clienteDTO.setTelefono("3104685932");
		
		restTemplate.postForLocation("http://localhost:9095/banco-web/controller/restCliente/save",clienteDTO);
		*/
		
		
		/* test update
		ClienteDTO clienteDTO = restTemplate
				.getForObject("http://localhost:9090/banco-web/controller/restCliente/find/114403242",ClienteDTO.class);
		
		clienteDTO.setEmail("carlossantiago@gmail.com");
		
		restTemplate.put("http://localhost:9090/banco-web/controller/restCliente/update",clienteDTO);

		*/
		
		//restTemplate.delete("http://localhost:9090/banco-web/controller/restCliente/borrar/114403242");
		
		RetiroDTO retiro = new RetiroDTO();
		retiro.setClieId(new BigDecimal(572));
		retiro.setCuenId("0000-6776-1365-3228");
		retiro.setUsuUsuario("xquereerb");
		retiro.setValor(new BigDecimal(50000));
		
		restTemplate.postForLocation("http://localhost:9090/banco-web/controller/restRetiro/save",retiro);
	}

}
