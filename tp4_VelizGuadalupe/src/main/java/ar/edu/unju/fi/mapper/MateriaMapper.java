package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.model.Materia;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MateriaMapper {
	
	MateriaDTO materiaToMateriaDTO(Materia materia);
	
	Materia materiaDTOToMateria(MateriaDTO materiaDTO);
	
	List<MateriaDTO> materiaDTOListToMateriaList(List<Materia> materiaList);
	
	List<Materia> materiaListToMateriaDTOList(List<MateriaDTO> materiaDTOList);

}
