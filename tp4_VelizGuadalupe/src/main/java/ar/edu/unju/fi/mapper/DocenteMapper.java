package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.model.Docente;



@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocenteMapper {
	
	DocenteDTO docenteToDocenteDTO (Docente docente); 
	
	Docente docenteDTOToDocente (DocenteDTO docenteDTO);
	
	List<DocenteDTO> docenteDTOListToDocenteList(List<Docente> docenteList);
	
	List<Docente> docenteListToDocenteDTOList(List<DocenteDTO> docenteDTOList);
}
