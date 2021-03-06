package co.edu.usbcali.arquitectura.rest.controllers;

import co.edu.usbcali.arquitectura.dto.mapper.ISaludoMapper;
import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoDTO;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoNombreDTO;
import co.edu.usbcali.arquitectura.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

import java.util.List;


@RestController
@RequestMapping("/saludo")
public class SaludoRestController {
    private static final Logger log = LoggerFactory.getLogger(SaludoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ISaludoMapper saludoMapper;

    @PostMapping(value = "/saveSaludo")
    public void saveSaludo(@RequestBody
    SaludoDTO saludoDTO) throws Exception {
        try {
            Saludo saludo = saludoMapper.saludoDTOToSaludo(saludoDTO);

            businessDelegatorView.saveSaludo(saludo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteSaludo/{idSaludo}")
    public void deleteSaludo(@PathVariable("idSaludo")
    Integer idSaludo) throws Exception {
        try {
            Saludo saludo = businessDelegatorView.getSaludo(idSaludo);

            businessDelegatorView.deleteSaludo(saludo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
    @CrossOrigin(origins="*")
    @GetMapping(value = "/saludoNombre/{nombre}")
    public SaludoNombreDTO saludoNombre(@PathVariable("nombre")
    String nombre) throws Exception {
        try {
            SaludoNombreDTO saludo = businessDelegatorView.SaludoNombre(nombre);
            return saludo;

        } catch (Exception e) {
            SaludoNombreDTO error = new SaludoNombreDTO(nombre,"holi");
            return error;
        }
    }

    @PutMapping(value = "/updateSaludo/")
    public void updateSaludo(@RequestBody
    SaludoDTO saludoDTO) throws Exception {
        try {
            Saludo saludo = saludoMapper.saludoDTOToSaludo(saludoDTO);

            businessDelegatorView.updateSaludo(saludo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataSaludo")
    public List<SaludoDTO> getDataSaludo() throws Exception {
        try {
            return businessDelegatorView.getDataSaludo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getSaludo/{idSaludo}")
    public SaludoDTO getSaludo(@PathVariable("idSaludo")
    Integer idSaludo) throws Exception {
        try {
            Saludo saludo = businessDelegatorView.getSaludo(idSaludo);

            return saludoMapper.saludoToSaludoDTO(saludo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
    

}
