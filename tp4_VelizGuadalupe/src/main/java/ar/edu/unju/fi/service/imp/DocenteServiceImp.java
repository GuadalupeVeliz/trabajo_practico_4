package ar.edu.unju.fi.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.DocenteService;

@Service
public class DocenteServiceImp implements DocenteService {

	private static final Logger logger = LoggerFactory.getLogger(DocenteServiceImp.class);

	@Autowired
	private DocenteRepository docenteRepository;

	@Autowired
	private MateriaRepository materiaRepository;

	@Autowired
	private CarreraRepository carreraRepository;

	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private DocenteMapper docenteMapper;

	@Override
	public DocenteDTO getDocente(Long id) {
		Docente docente = docenteRepository.findById(id).orElse(null);
		if (docente != null) {
			DocenteDTO docenteDTO = docenteMapper.docenteToDocenteDTO(docente);
			logger.info("Docente encontrado con id: {}", id);
			return docenteDTO;
		}
		logger.warn("Docente con id: {} no encontrado", id);
		return null;
	}

	@Override
	public List<DocenteDTO> getDocentes() {
		List<Docente> docentes = docenteRepository.findAll();
		logger.info("Se obtuvieron {} docentes", docentes.size());
		return docentes.stream().map(docente -> {
			return docenteMapper.docenteToDocenteDTO(docente);
		}).collect(Collectors.toList());
	}

	@Override
	public void saveDocente(DocenteDTO docenteDTO) {
		Docente docente = docenteMapper.docenteDTOToDocente(docenteDTO);
		docenteRepository.save(docente);
		logger.info("Docente guardado con éxito: {}", docenteDTO.getNombre() + " " + docenteDTO.getApellido());
	}

	@Override
	public void editDocente(DocenteDTO docenteDTO) {
		Docente docente = docenteMapper.docenteDTOToDocente(docenteDTO);
		docenteRepository.save(docente);
		logger.info("Docente editado con éxito: {}", docenteDTO);
	}

	@Override
	public void deleteDocente(Long id) {
		Docente docente = docenteRepository.findById(id).orElse(null);

		if (docente != null) {
			List<Materia> materiasDelDocente = materiaRepository.findAll().stream()
					.filter(materia -> materia.getDocente().getId().equals(docente.getId()))
					.collect(Collectors.toList());

			if (!materiasDelDocente.isEmpty()) {
				Materia materiaDelDocente = materiasDelDocente.get(0);

				Carrera carrera = materiaDelDocente.getCarrera();
				if (carrera != null) {
					carrera.getMaterias().remove(materiaDelDocente);
					carreraRepository.save(carrera);
				}

				for (Alumno alumno : materiaDelDocente.getAlumnos()) {
					alumno.getMaterias().remove(materiaDelDocente);
					alumnoRepository.save(alumno);
				}

				materiaRepository.deleteById(materiaDelDocente.getId());
				logger.info("Materia eliminada para el docente con id: {}", id);
			} else {
				logger.warn("El docente con id: {} no tiene materias asociadas", id);
			}

			docenteRepository.deleteById(id);
			logger.info("Docente con id: {} eliminado con éxito", id);
		} else {
			logger.warn("Docente con id: {} no encontrado", id);
		}
	}

}
