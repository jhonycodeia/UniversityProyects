package co.edu.usbcali.banco.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operaciones")
public class OperacionesMatematicas {

	@GetMapping("sumar/{num1}/{num2}")
	public Resultado sumar(@PathVariable("num1") Integer a,@PathVariable("num2") Integer b) {
		Resultado resultado = new Resultado();
		resultado.setValor(a+b);
		return resultado;
	}
	
	@GetMapping("restar/{num1}/{num2}")
	public Resultado restar(@PathVariable("num1") Integer a,@PathVariable("num2") Integer b) {
		Resultado resultado = new Resultado();
		resultado.setValor(a-b);
		return resultado;
	}
	
	@GetMapping("multiplicar/{num1}/{num2}")
	public Resultado multiplicar(@PathVariable("num1") Integer a,@PathVariable("num2") Integer b) {
		Resultado resultado = new Resultado();
		resultado.setValor(a*b);
		return resultado;
	}
}
