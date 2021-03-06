package com.green.mapper;

import com.green.dto.AreaDTO;

import com.green.modelo.Area;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface AreaMapper {
    public AreaDTO areaToAreaDTO(Area area) throws Exception;

    public Area areaDTOToArea(AreaDTO areaDTO) throws Exception;

    public List<AreaDTO> listAreaToListAreaDTO(List<Area> areas)
        throws Exception;

    public List<Area> listAreaDTOToListArea(List<AreaDTO> areaDTOs)
        throws Exception;
}
