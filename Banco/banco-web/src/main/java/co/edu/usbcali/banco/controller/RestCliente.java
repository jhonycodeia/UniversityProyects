package co.edu.usbcali.banco.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.usbcali.banco.dto.ClienteDTO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.vista.IDelegadoDeNegocio;

@RestController
@RequestMapping("/restCliente")
public class RestCliente {
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@GetMapping("/find/{id}")
	public ClienteDTO findCliente(@PathVariable("id") BigDecimal id) {
		
		Cliente cliente = delegadoDeNegocio.findCliente(id);	
		
		return clienteToClienteDTO(cliente);
		
	}
	
	@GetMapping("/findAll")
	public List<ClienteDTO> findAll(){
		
		List<ClienteDTO> losClientes = new ArrayList<>() ;		
		
		for (Cliente cliente : delegadoDeNegocio.findAllCliente()) {
			losClientes.add(clienteToClienteDTO(cliente));
		}
		
		return losClientes;
	}
	
	@CrossOrigin(origins="*")
	@PostMapping("/save")
	public ResultadoRest saveCliente(@RequestBody ClienteDTO clienteDTO) {
		try {
			Cliente cliente = clienteDTOToCliente(clienteDTO);
			delegadoDeNegocio.createCliente(cliente);
			
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
	
	@PutMapping("/update")
	public ResultadoRest updateCliente(@RequestBody ClienteDTO clienteDTO) {
		try {
			Cliente cliente = clienteDTOToCliente(clienteDTO);
			delegadoDeNegocio.updateCliente(cliente);
			
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
	
	@DeleteMapping("/delete/{id}")
	public ResultadoRest deleteCliente(@PathVariable("id") BigDecimal clieId) {
		try {
			
			delegadoDeNegocio.deleteCliente(clieId);
			
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
	
	
	private Cliente clienteDTOToCliente(ClienteDTO clienteDTO) {
		
		Cliente cliente = new Cliente();
		
		cliente.setClieId(clienteDTO.getClieId());
		cliente.setDireccion(clienteDTO.getDireccion());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setTelefono(clienteDTO.getTelefono());
		cliente.setActivo(clienteDTO.getActivo());
		cliente.setTipoDocumento(delegadoDeNegocio.findTipoDocumento(clienteDTO.getTdocId()));
		
		return cliente;
	}
	
	private ClienteDTO clienteToClienteDTO(Cliente cliente) {
		
		ClienteDTO clienteDTO = new ClienteDTO();
		
		clienteDTO.setClieId(cliente.getClieId());
		clienteDTO.setDireccion(cliente.getDireccion());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setTelefono(cliente.getTelefono());
		clienteDTO.setActivo(cliente.getActivo());
		clienteDTO.setTdocId(cliente.getTipoDocumento().getTdocId());
		
		return clienteDTO;
	}
	
	

}
