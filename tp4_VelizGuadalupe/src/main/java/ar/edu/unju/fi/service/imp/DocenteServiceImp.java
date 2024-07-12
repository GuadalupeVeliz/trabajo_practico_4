package ar.edu.unju.fi.service.imp;

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
			return docenteDTO;
		}
		return null;
	}

	@Override
	public List<DocenteDTO> getDocentes() {
		List<Docente> docentes = docenteRepository.findAll();
		return docentes.stream()
				.map(docente -> {
					return docenteMapper.docenteToDocenteDTO(docente);
				})
				.collect(Collectors.toList());
	}

	@Override
	public void saveDocente (DocenteDTO docenteDTO) {	
		Docente docente = docenteMapper.docenteDTOToDocente(docenteDTO);
		docenteRepository.save(docente);
	}

	@Override
	public void editDocente(DocenteDTO docenteDTO) {
		Docente docente = docenteMapper.docenteDTOToDocente(docenteDTO);
		docenteRepository.save(docente);
	}

	@Override
	public void deleteDocente(Long id) {
		Docente docente = docenteRepository.findById(id).orElse(null);
		
		if (docente != null) {
			
			Materia materiaDelDocente = materiaRepository.findAll().stream()
					.filter((materia) -> {
						if (materia.getDocente().getId() == docente.getId())
							return true;
						else
							return false;
					})
					.collect(Collectors.toList())
					.get(0);
			
			
			if (materiaDelDocente != null) {
				
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
			}
			
			docenteRepository.deleteById(id);
		}		
	}
	
}
