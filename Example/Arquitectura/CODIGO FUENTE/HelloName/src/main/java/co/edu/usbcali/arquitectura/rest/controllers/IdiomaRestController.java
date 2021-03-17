package co.edu.usbcali.arquitectura.rest.controllers;

import co.edu.usbcali.arquitectura.dto.mapper.IIdiomaMapper;
import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.dto.IdiomaDTO;
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
@RequestMapping("/idioma")
public class IdiomaRestController {
    private static final Logger log = LoggerFactory.getLogger(IdiomaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IIdiomaMapper idiomaMapper;

    @PostMapping(value = "/saveIdioma")
    public void saveIdioma(@RequestBody
    IdiomaDTO idiomaDTO) throws Exception {
        try {
            Idioma idioma = idiomaMapper.idiomaDTOToIdioma(idiomaDTO);

            businessDelegatorView.saveIdioma(idioma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteIdioma/{idIdioma}")
    public void deleteIdioma(@PathVariable("idIdioma")
    Integer idIdioma) throws Exception {
        try {
            Idioma idioma = businessDelegatorView.getIdioma(idIdioma);

            businessDelegatorView.deleteIdioma(idioma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateIdioma/")
    public void updateIdioma(@RequestBody
    IdiomaDTO idiomaDTO) throws Exception {
        try {
            Idioma idioma = idiomaMapper.idiomaDTOToIdioma(idiomaDTO);

            businessDelegatorView.updateIdioma(idioma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataIdioma")
    public List<IdiomaDTO> getDataIdioma() throws Exception {
        try {
            return businessDelegatorView.getDataIdioma();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getIdioma/{idIdioma}")
    public IdiomaDTO getIdioma(@PathVariable("idIdioma")
    Integer idIdioma) throws Exception {
        try {
            Idioma idioma = businessDelegatorView.getIdioma(idIdioma);

            return idiomaMapper.idiomaToIdiomaDTO(idioma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
