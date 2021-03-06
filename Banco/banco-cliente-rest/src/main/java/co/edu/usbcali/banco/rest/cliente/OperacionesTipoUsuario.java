package co.edu.usbcali.banco.rest.cliente;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import co.edu.usbcali.banco.dto.TipoUsuarioDTO;
import co.edu.usbcali.banco.dto.UsuarioDTO;

public class OperacionesTipoUsuario {
	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();

		TipoUsuarioDTO resultado = restTemplate
				.getForObject("http://localhost:9090/banco-web/controller/restTipoUsuario/find/2",TipoUsuarioDTO.class);

		System.out.println(resultado.getNombre());

		TipoUsuarioDTO[] losresultado = restTemplate.getForObject("http://localhost:9090/banco-web/controller/restTipoUsuario/findAll",TipoUsuarioDTO[].class);

		for (TipoUsuarioDTO usuarioDTO : losresultado) {
			System.out.println(usuarioDTO.getNombre());
		}
	}

}
