package co.edu.usbcali.banco.rest.cliente;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import co.edu.usbcali.banco.dto.UsuarioDTO;

public class OperacionesUsuario {
	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();

		UsuarioDTO resultado = restTemplate
				.getForObject("http://localhost:9090/banco-web/controller/restUsuario/find/jhonycode",UsuarioDTO.class);

		System.out.println(resultado.getNombre()+" "+resultado.getUsuUsuario()+"\n");

		UsuarioDTO[] losresultado = restTemplate.getForObject("http://localhost:9090/banco-web/controller/restUsuario/findAll",UsuarioDTO[].class);

		for (UsuarioDTO usuarioDTO : losresultado) {
			System.out.println(usuarioDTO.getNombre());
		}
	}

}
