package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;

public interface AlumnoService {

	public AlumnoDTO getAlumno(Long id);
	
	public List<AlumnoDTO> getAlumnos();
	
	public void saveAlumno(AlumnoDTO alumnoDTO);
	
	public void editAlumno(AlumnoDTO alumnoDTO);
	
	public void deleteAlumno(Long id);
	
}
