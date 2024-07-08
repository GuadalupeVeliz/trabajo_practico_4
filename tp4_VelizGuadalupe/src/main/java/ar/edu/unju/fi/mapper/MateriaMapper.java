package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.model.Materia;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MateriaMapper {
	
	@Mapping(target = "carreraDTO", source = "carrera")
	@Mapping(target = "docenteDTO", source = "docente")
	MateriaDTO materiaToMateriaDTO(Materia materia);
	
	@Mapping(target = "carrera", source = "carreraDTO")
	@Mapping(target = "docente", source = "docenteDTO")
	Materia materiaDTOToMateria(MateriaDTO materiaDTO);
	
	List<MateriaDTO> materiaDTOListToMateriaList(List<Materia> materiaList);
	
	List<Materia> materiaListToMateriaDTOList(List<MateriaDTO> materiaDTOList);

}
