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
import co.edu.usbcali.banco.dto.UsuarioDTO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Usuario;
import co.edu.usbcali.banco.vista.IDelegadoDeNegocio;

@RestController
@RequestMapping("/restUsuario")
public class RestUsuario {
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@GetMapping("/find/{id}")
	public UsuarioDTO findCliente(@PathVariable("id") String id) {
		
		Usuario usuario = delegadoDeNegocio.findUsuario(id);
		
		return UsuarioToUsuarioDTO(usuario);
		
	}
	
	@GetMapping("/findAll")
	public List<UsuarioDTO> findAll(){
		
		List<UsuarioDTO> losUsuario = new ArrayList<>() ;		
		
		for (Usuario usuario : delegadoDeNegocio.findAllUsuario()) {
			losUsuario.add(UsuarioToUsuarioDTO(usuario));
		}
		
		return losUsuario;
	}
	

	private UsuarioDTO UsuarioToUsuarioDTO(Usuario usuario) {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		usuarioDTO.setUsuUsuario(usuario.getUsuUsuario());
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setIdentificacion(usuario.getIdentificacion());
		usuarioDTO.setActivo(usuario.getActivo());
		usuarioDTO.setClave(usuario.getClave());
		usuarioDTO.setTiusId(usuario.getTipoUsuario().getTiusId());
		
		return usuarioDTO;
	}
	
	

}
