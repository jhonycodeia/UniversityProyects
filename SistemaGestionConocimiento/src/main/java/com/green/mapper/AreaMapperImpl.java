package com.green.mapper;

import com.green.dto.AreaDTO;

import com.green.modelo.*;
import com.green.modelo.Area;

import com.green.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class AreaMapperImpl implements AreaMapper {
    private static final Logger log = LoggerFactory.getLogger(AreaMapperImpl.class);

    @Transactional(readOnly = true)
    public AreaDTO areaToAreaDTO(Area area) throws Exception {
        try {
            AreaDTO areaDTO = new AreaDTO();

            areaDTO.setIdArea(area.getIdArea());
            areaDTO.setActivo((area.getActivo() != null) ? area.getActivo() : null);
            areaDTO.setDescripcion((area.getDescripcion() != null)
                ? area.getDescripcion() : null);
            areaDTO.setFechaCreacion(area.getFechaCreacion());
            areaDTO.setFechaModificacion(area.getFechaModificacion());
            areaDTO.setNombre((area.getNombre() != null) ? area.getNombre() : null);
            areaDTO.setUsuCreador((area.getUsuCreador() != null)
                ? area.getUsuCreador() : null);
            areaDTO.setUsuModificador((area.getUsuModificador() != null)
                ? area.getUsuModificador() : null);

            return areaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Area areaDTOToArea(AreaDTO areaDTO) throws Exception {
        try {
            Area area = new Area();

            area.setIdArea(areaDTO.getIdArea());
            area.setActivo((areaDTO.getActivo() != null) ? areaDTO.getActivo()
                                                         : null);
            area.setDescripcion((areaDTO.getDescripcion() != null)
                ? areaDTO.getDescripcion() : null);
            area.setFechaCreacion(areaDTO.getFechaCreacion());
            area.setFechaModificacion(areaDTO.getFechaModificacion());
            area.setNombre((areaDTO.getNombre() != null) ? areaDTO.getNombre()
                                                         : null);
            area.setUsuCreador((areaDTO.getUsuCreador() != null)
                ? areaDTO.getUsuCreador() : null);
            area.setUsuModificador((areaDTO.getUsuModificador() != null)
                ? areaDTO.getUsuModificador() : null);

            return area;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<AreaDTO> listAreaToListAreaDTO(List<Area> listArea)
        throws Exception {
        try {
            List<AreaDTO> areaDTOs = new ArrayList<AreaDTO>();

            for (Area area : listArea) {
                AreaDTO areaDTO = areaToAreaDTO(area);

                areaDTOs.add(areaDTO);
            }

            return areaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Area> listAreaDTOToListArea(List<AreaDTO> listAreaDTO)
        throws Exception {
        try {
            List<Area> listArea = new ArrayList<Area>();

            for (AreaDTO areaDTO : listAreaDTO) {
                Area area = areaDTOToArea(areaDTO);

                listArea.add(area);
            }

            return listArea;
        } catch (Exception e) {
            throw e;
        }
    }
}
