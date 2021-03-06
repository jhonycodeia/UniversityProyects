package co.edu.usbcali.arquitectura.rest.controllers;

import co.edu.usbcali.arquitectura.dto.mapper.INombreMapper;
import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.dto.NombreDTO;
import co.edu.usbcali.arquitectura.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

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
@RequestMapping("/nombre")
public class NombreRestController {
    private static final Logger log = LoggerFactory.getLogger(NombreRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private INombreMapper nombreMapper;

    @PostMapping(value = "/saveNombre")
    public void saveNombre(@RequestBody
    NombreDTO nombreDTO) throws Exception {
        try {
            Nombre nombre = nombreMapper.nombreDTOToNombre(nombreDTO);

            businessDelegatorView.saveNombre(nombre);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteNombre/{idNombre}")
    public void deleteNombre(@PathVariable("idNombre")
    Integer idNombre) throws Exception {
        try {
            Nombre nombre = businessDelegatorView.getNombre(idNombre);

            businessDelegatorView.deleteNombre(nombre);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateNombre/")
    public void updateNombre(@RequestBody
    NombreDTO nombreDTO) throws Exception {
        try {
            Nombre nombre = nombreMapper.nombreDTOToNombre(nombreDTO);

            businessDelegatorView.updateNombre(nombre);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataNombre")
    public List<NombreDTO> getDataNombre() throws Exception {
        try {
            return businessDelegatorView.getDataNombre();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getNombre/{idNombre}")
    public NombreDTO getNombre(@PathVariable("idNombre")
    Integer idNombre) throws Exception {
        try {
            Nombre nombre = businessDelegatorView.getNombre(idNombre);

            return nombreMapper.nombreToNombreDTO(nombre);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
