package ar.edu.unju.fi.service.imp;

import java.util.List;import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.AlumnoService;
 
@Service
public class AlumnoServiceImp implements AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private CarreraRepository carreraRepository;
	
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
		Alumno alumno = alumnoRepository.findById(id).orElse(null);
		
		if (alumno != null) {
			
			Carrera carrera = alumno.getCarrera();
			if (carrera != null) {
				carrera.getAlumnos().remove(alumno);
				carreraRepository.save(carrera);
			}
			
			for (Materia materia : alumno.getMaterias()) {
				materia.getAlumnos().remove(alumno);
				materiaRepository.save(materia);
			}
			
			alumnoRepository.deleteById(id);
		}		
	}
	
	@Override
	 public List<AlumnoDTO> getAlumnosByCarreraId(Long carreraId) {
	        return alumnoRepository.findById(carreraId)
	                .stream()
	                .map(alumnoMapper::alumnoToAlumnoDTO)
	                .collect(Collectors.toList());
	    }
	
	@Override
    public List<AlumnoDTO> getAlumnosPorMateria(Long materiaId) {
        List<Alumno> alumnos = alumnoRepository.findAlumnosByMateriasId(materiaId);
        return alumnos.stream().map(alumno -> alumnoMapper.alumnoToAlumnoDTO(alumno)).collect(Collectors.toList());
    }
	
}
