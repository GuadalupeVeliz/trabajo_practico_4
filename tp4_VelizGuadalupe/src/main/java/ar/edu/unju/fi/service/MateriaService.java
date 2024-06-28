package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.MateriaDTO;

public interface MateriaService {
	
	public MateriaDTO getMateria(Long id);
	
	public List<MateriaDTO> getMaterias();
	
	public void saveMateria(MateriaDTO materiaDTO);
	
	public void editMateria(MateriaDTO materiaDTO);
	
	public void deleteMateria(Long id);

}
