package co.edu.usbcali.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.banco.dto.ClienteDTO;
import co.edu.usbcali.banco.dto.RetiroDTO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.vista.IDelegadoDeNegocio;

@RestController
@RequestMapping("/restRetiro")
public class RestRetiro {

	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@CrossOrigin(origins="*")
	@PostMapping("/save")
	public ResultadoRest saveRetiro(@RequestBody RetiroDTO retiroDTO) {
		try {
			
			delegadoDeNegocio.retirarTransaccionBanco(retiroDTO.getUsuUsuario(),
													  retiroDTO.getCuenId(),
													  retiroDTO.getClieId(),
													  retiroDTO.getValor());
			
			ResultadoRest resultadoRest = new ResultadoRest();
			resultadoRest.setCodigo(0);
			resultadoRest.setMensaje("");
			
			return resultadoRest;
		} catch (Exception e) {
			ResultadoRest resultadoRest = new ResultadoRest();
			resultadoRest.setCodigo(-1);
			resultadoRest.setMensaje(e.getMessage());
			
			return resultadoRest;
		}
	}
}
