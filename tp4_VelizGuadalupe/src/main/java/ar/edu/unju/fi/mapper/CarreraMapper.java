package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarreraMapper {
	
	CarreraDTO carreraToCarreraDTO (Carrera carrera);
	
	Carrera carreraDTOToCarrera (CarreraDTO carreraDTO);
	
	List<CarreraDTO> carreraDTOListToCarreraList(List<Carrera> carreraList);
	
	List<Carrera> carreraListToCarreraDTOList(List<CarreraDTO> carreraDTOList);
}
