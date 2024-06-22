package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlumnoMapper {

	AlumnoDTO alumnoToAlumnoDTO(Alumno alumno); 
	
	Alumno alumnoDTOToAlumno(AlumnoDTO alumnoDTO);
	
	List<AlumnoDTO> alumnoDTOListToAlumnoList(List<Alumno> alumnoList);
	
	List<Alumno> alumnoListToAlumnoDTOList(List<AlumnoDTO> alumnoDTOList);
}
