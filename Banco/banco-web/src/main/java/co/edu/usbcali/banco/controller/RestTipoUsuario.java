package co.edu.usbcali.banco.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.usbcali.banco.dto.ClienteDTO;
import co.edu.usbcali.banco.dto.TipoUsuarioDTO;
import co.edu.usbcali.banco.dto.UsuarioDTO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Usuario;
import co.edu.usbcali.banco.vista.IDelegadoDeNegocio;

@RestController
@RequestMapping("/restTipoUsuario")
public class RestTipoUsuario {
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@GetMapping("/find/{id}")
	public TipoUsuarioDTO findCliente(@PathVariable("id") long id) {
		
		TipoUsuario tipoUsuario = delegadoDeNegocio.findTipoUsuario(id);
		
		if(tipoUsuario==null)
			return null;
					
		return TipoUsuarioToTipoUsuarioDTO(tipoUsuario);
		
	}
	
	@GetMapping("/findAll")
	public List<TipoUsuarioDTO> findAll(){
		
		List<TipoUsuarioDTO> losTipoUsuario = new ArrayList<>() ;		
		
		for (TipoUsuario tipoUsuario: delegadoDeNegocio.findAllTipoUsuario()) {
			losTipoUsuario.add(TipoUsuarioToTipoUsuarioDTO(tipoUsuario));
		}
		
		return losTipoUsuario;
	}
	

	private TipoUsuarioDTO TipoUsuarioToTipoUsuarioDTO(TipoUsuario tipoUsuario) {
		
		TipoUsuarioDTO tipoUsuarioDTO = new TipoUsuarioDTO();
		
		tipoUsuarioDTO.setTiusId(tipoUsuario.getTiusId());
		tipoUsuarioDTO.setNombre(tipoUsuario.getNombre());
		tipoUsuarioDTO.setActivo(tipoUsuario.getActivo());
		
		return tipoUsuarioDTO;
	}
	
	

}
