package ar.edu.unju.fi.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.MateriaService;

@Service
public class MateriaServiceImp implements MateriaService {

	private static final Logger logger = LoggerFactory.getLogger(MateriaServiceImp.class);

	@Autowired
	private MateriaRepository materiaRepository;

	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private CarreraRepository carreraRepository;

	@Autowired
	private MateriaMapper materiaMapper;

	@Override
	public MateriaDTO getMateria(Long id) {
		Materia materia = materiaRepository.findById(id).orElse(null);
		if (materia != null) {
			MateriaDTO materiaDTO = materiaMapper.materiaToMateriaDTO(materia);
			logger.info("Materia encontrada con id: {}", id);
			return materiaDTO;
		}
		logger.warn("Materia con id: {} no encontrada", id);
		return null;
	}

	@Override
	public List<MateriaDTO> getMaterias() {
		List<Materia> materias = materiaRepository.findAll();
		logger.info("Se obtuvieron {} materias", materias.size());
		return materias.stream().map(materia -> {
			return materiaMapper.materiaToMateriaDTO(materia);
		}).collect(Collectors.toList());
	}

	@Override
	public void saveMateria(MateriaDTO materiaDTO) {
		Materia materia = materiaMapper.materiaDTOToMateria(materiaDTO);
		materiaRepository.save(materia);
		logger.info("Materia guardada con éxito: {}", materiaDTO.getNombre());
	}

	@Override
	public void editMateria(MateriaDTO materiaDTO) {
		Materia materia = materiaMapper.materiaDTOToMateria(materiaDTO);
		materiaRepository.save(materia);
		logger.info("Materia editada con éxito: {}", materiaDTO.getNombre());
	}

	@Override
	public void deleteMateria(Long id) {
		Materia materia = materiaRepository.findById(id).orElse(null);

		if (materia != null) {

			for (Alumno alumno : materia.getAlumnos()) {
				alumno.getMaterias().remove(materia);
				alumnoRepository.save(alumno);
				logger.info("Alumno: {} removido de la Materia: {}", alumno.getNombre(), materia.getNombre());
			}

			Carrera carrera = materia.getCarrera();
			if (carrera != null) {
				carrera.getMaterias().remove(materia);
				carreraRepository.save(carrera);
				logger.info("Materia: {} removida de la Carrera: {}", materia.getNombre(), carrera.getNombre());
			}

			materiaRepository.deleteById(id);
			logger.info("Materia con id: {} eliminada con éxito", id);
		} else {
			logger.warn("Materia con id: {} no encontrada para eliminar", id);
		}
	}

}
