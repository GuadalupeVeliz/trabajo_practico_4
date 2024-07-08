package ar.edu.unju.fi.service.imp;

import java.util.List;import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.AlumnoService;

@Service
public class AlumnoServiceImp implements AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AlumnoMapper alumnoMapper;
	

	@Override
	public AlumnoDTO getAlumno(Long id) {	
		Alumno alumno = alumnoRepository.findById(id).orElse(null);
		if (alumno != null) {
			AlumnoDTO alunmoDTO = alumnoMapper.alumnoToAlumnoDTO(alumno);			
			return alunmoDTO;
		}
		return null;
	}

	@Override
	public List<AlumnoDTO> getAlumnos() {
		List<Alumno> alumnos = alumnoRepository.findAll();
		return alumnos.stream()
				.map(alumno -> {
					return alumnoMapper.alumnoToAlumnoDTO(alumno);
				})
				.collect(Collectors.toList());
	}

	@Override
	public void saveAlumno(AlumnoDTO alumnoDTO) {	
		Alumno alumno = alumnoMapper.alumnoDTOToAlumno(alumnoDTO);
		alumnoRepository.save(alumno);
	}

	@Override
	public void editAlumno(AlumnoDTO alumnoDTO) {
		Alumno alumno = alumnoMapper.alumnoDTOToAlumno(alumnoDTO);
		alumnoRepository.save(alumno);
	}

	@Override
	public void deleteAlumno(Long id) {
		alumnoRepository.deleteById(id);
	}
	
	@Override
	 public List<AlumnoDTO> getAlumnosByCarreraId(Long carreraId) {
	        return alumnoRepository.findById(carreraId)
	                .stream()
	                .map(alumnoMapper::alumnoToAlumnoDTO)
	                .collect(Collectors.toList());
	    }
	
}
