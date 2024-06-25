package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.DocenteService;

@Service
public class DocenteServiceImp implements DocenteService {

	@Autowired
	private DocenteRepository docenteRepository;
	
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
		docenteRepository.deleteById(id);
	}
}
