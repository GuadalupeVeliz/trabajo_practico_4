package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	private static final Logger logger = LoggerFactory.getLogger(AlumnoServiceImp.class);

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
		logger.info("Obteniendo alumno con id: {}", id);
		Alumno alumno = alumnoRepository.findById(id).orElse(null);
		if (alumno != null) {
			AlumnoDTO alumnoDTO = alumnoMapper.alumnoToAlumnoDTO(alumno);
			logger.info("Alumno obtenido: {}", alumnoDTO.getNombre() + " " + alumnoDTO.getApellido());
			return alumnoDTO;
		}
		logger.warn("Alumno con id: {} no encontrado", id);
		return null;
	}

	@Override
	public List<AlumnoDTO> getAlumnos() {
		logger.info("Obteniendo todos los alumnos");
		List<Alumno> alumnos = alumnoRepository.findAll();
		List<AlumnoDTO> alumnoDTOs = alumnos.stream().map(alumno -> {
			return alumnoMapper.alumnoToAlumnoDTO(alumno);
		}).collect(Collectors.toList());
		logger.info("Alumnos obtenidos: {}", alumnoDTOs.size());
		return alumnoDTOs;
	}

	@Override
	public void saveAlumno(AlumnoDTO alumnoDTO) {
		logger.info("Guardando alumno: {}", alumnoDTO.getNombre() + " " + alumnoDTO.getApellido());
		Alumno alumno = alumnoMapper.alumnoDTOToAlumno(alumnoDTO);
		alumnoRepository.save(alumno);
		logger.info("Alumno guardado con éxito: {}", alumnoDTO.getNombre() + " " + alumnoDTO.getApellido());
	}

	@Override
	public void editAlumno(AlumnoDTO alumnoDTO) {
		logger.info("Editando alumno: {}", alumnoDTO.getNombre() + " " + alumnoDTO.getApellido());
		Alumno alumno = alumnoMapper.alumnoDTOToAlumno(alumnoDTO);
		alumnoRepository.save(alumno);
		logger.info("Alumno editado con éxito: {}", alumnoDTO.getNombre() + " " + alumnoDTO.getApellido());
	}

	@Override
	public void deleteAlumno(Long id) {
		Alumno alumno = alumnoRepository.findById(id).orElse(null);

		if (alumno != null) {

			Carrera carrera = alumno.getCarrera();
			if (carrera != null) {
				carrera.getAlumnos().remove(alumno);
				logger.info("Alumno: {} eliminado de la carrera: {}", alumno.getNombre(), carrera.getNombre());
				carreraRepository.save(carrera);
			}

			for (Materia materia : alumno.getMaterias()) {
				materia.getAlumnos().remove(alumno);
				logger.info("Alumno: {} eliminado de la Materia: {}", alumno.getNombre(), materia.getNombre());
				materiaRepository.save(materia);
			}

			alumnoRepository.deleteById(id);
			logger.info("Alumno con id: {} eliminado con éxito", id);
		} else {
			logger.warn("Alumno con id: {} no encontrado para eliminar", id);
		}
	}

	@Override
	public List<AlumnoDTO> getAlumnosByCarreraId(Long carreraId) {
		return alumnoRepository.findById(carreraId).stream().map(alumnoMapper::alumnoToAlumnoDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<AlumnoDTO> getAlumnosPorMateria(Long materiaId) {
		List<Alumno> alumnos = alumnoRepository.findAlumnosByMateriasId(materiaId);
		return alumnos.stream().map(alumno -> alumnoMapper.alumnoToAlumnoDTO(alumno)).collect(Collectors.toList());
	}

}
