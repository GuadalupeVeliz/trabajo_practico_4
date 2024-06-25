package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.dto.DocenteDTO;


public interface DocenteService {
	
	public DocenteDTO getDocente(Long id);
	
	public List<DocenteDTO> getDocentes();
	
	public void saveDocente(DocenteDTO docenteDTO);
	
	public void editDocente(DocenteDTO docenteDTO);
	
	public void deleteDocente(Long id);
}
